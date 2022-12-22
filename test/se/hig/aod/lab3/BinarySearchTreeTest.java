package se.hig.aod.lab3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {
    private BinarySearchTree<Integer> fullTreeUnderTest;
    private BinarySearchTree<Integer> emptyTreeUnderTest;
    static final Integer[] INT_FIX = {3, 4, 5, 2, 1}; // TODO fill with random integers



    @BeforeEach
    void setUp() {
        fullTreeUnderTest = new BinarySearchTree<>();
        for(int vene : INT_FIX){
            fullTreeUnderTest.addElement(vene);
        }
        emptyTreeUnderTest = new BinarySearchTree<>();


    }

    @AfterEach
    void tearDown() {
        fullTreeUnderTest = null;
        emptyTreeUnderTest = null;
    }

    @Test
    void size() {
        assertEquals(INT_FIX.length, fullTreeUnderTest.size(), "Storleken på trädet borde vara 5");
        assertEquals(0, emptyTreeUnderTest.size());
    }

    @Test
    void addElement() {
        fullTreeUnderTest.addElement(6);
        assertEquals(6, fullTreeUnderTest.searchElement(6), "Ska hitta nummer 6 i trädet");

        emptyTreeUnderTest.addElement(1);
        assertEquals(1, emptyTreeUnderTest.searchElement(1));

    }


    @Test
    void searchElement() {
        fullTreeUnderTest.addElement(25);
        assertEquals(25, fullTreeUnderTest.searchElement(25), " ska hitta nummer 25 i träder");

        assertNull(emptyTreeUnderTest.searchElement(2));
    }

    @Test
    void String(){
        assertEquals("12345", fullTreeUnderTest.ToString(), "Borde skriva ut 1234525");

        assertEquals("", emptyTreeUnderTest.ToString());
    }



}