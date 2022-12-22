package se.hig.aod.lab3;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

    public class MainShuffle {
        public static void main(String[] args) throws IOException {
            final int[] INT_FIXTURES = {10000, 20000, 40000, 80000, 160000, 320000, 640000, 1280000, 2560000 };
            List<Integer> list = loadListFromFile(2500000);
            for (int i : INT_FIXTURES) {
                long total = 0;
                for (int j = 0; j < 4; j++) {
                    BinarySearchTree<Integer> tree = new BinarySearchTree<>();
                    List<Integer> data = loadListFromFile(i);
                    Collections.shuffle(data);
                    for (Integer vene : data) {
                        tree.addElement(vene);
                    }
                    long timeMillis = System.currentTimeMillis();
                    for (Integer ints : list) {
                        tree.searchElement(ints);
                    }
                    long time = System.currentTimeMillis() - timeMillis;
                    total += time;
                    System.out.println("For " + i + " it takes: " + time + " ms for shuffled");
                }
                long avgTime = total / 4;
                System.out.println("Average time: " +avgTime);
            }
        }
    private static List<Integer> loadListFromFile(int size)
            throws IOException {
        List<Integer> list = new ArrayList<>();
        int cnt = 0;
        try (Scanner in = new Scanner(new FileReader("data.txt"))) {
            while (cnt < size && in.hasNextLine()) {
                String line = in.nextLine();
                try {
                    list.add(Integer.parseInt(line));
                    cnt++;
                } catch (NumberFormatException nfe) {
                    System.err.printf("Not an integer while reading from data file " +
                            "\"%s\": %s (ignoring)%n", "data.txt", nfe.getLocalizedMessage());
                }
            }
        }// här har in.close() garanterat anropats
        if (cnt != size) {
            System.err.printf("Didn't read %d integers, only %d.%n", size, cnt);
        }
        return list;
    }
}
