package se.hig.aod.lab3;

public class BinarySearchTree<T extends Comparable<? super T>> implements SearchableDataStructure<T> {
    private TreeNode<T> root;

    private int counter;



    @Override
    public int size() {
        return counter;
    }

    @Override
    public void addElement(T newElement) {
        if (root == null){
            root = new TreeNode<>(newElement, null, null);
        }else {
            addElementRecursive(newElement, root);
        }

        counter++;
    }

    public void addElementRecursive(T newElement, TreeNode<T> current){
        if (newElement.compareTo(current.data)<0){
            if (current.left == null){
                current.left = new TreeNode<>(newElement, null, null);
            } else {
                addElementRecursive(newElement, current.left);
            }
        }
        else if (current.right == null){
            current.right = new TreeNode<>(newElement, null, null);
        }
        else {
            addElementRecursive(newElement, current.right);
        }
    }

    @Override
    public T searchElement(T elementToFind) {

        return searchElementRecursive(elementToFind, root);
    }


    public T searchElementRecursive(T elementToFind, TreeNode<T> node){
        if (node == null){
            return null;
        }
        else if (elementToFind == node.data){
            return node.data;
        } else if (elementToFind.compareTo(node.data) <0) {
            return searchElementRecursive(elementToFind, node.left);
        } else {
            return searchElementRecursive( elementToFind,node.right);
        }
    }

    public String inOrder(TreeNode<T> current){
        if (current == null){
            return "";
        }else{
            return inOrder(current.left) + current.data + inOrder(current.right);
        }
    }

    public String ToString(){
        return inOrder(root);
    }

    static class TreeNode<T> {
        T  data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data, TreeNode<T>left,TreeNode<T>  right){
            this.left = left;
            this.right = right;
            this.data = data;
        }

    }
}


