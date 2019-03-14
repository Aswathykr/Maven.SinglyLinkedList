package com.zipcodewilmington.singlylinkedlist;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedList<T extends Comparable<T> > {

    Node<T> headNode;

    public void add(T item){
        Node<T> node= new Node<T>(item);
        if(headNode == null){
            headNode = node;
        }
        else{
            Node<T> last = getLastNode();
            last.next = node;
        }
    }

    private Node<T> getLastNode() {
        Node<T> lastNode = null;
        if(headNode != null) {
            lastNode = headNode;
            while (lastNode.next != null) {
                lastNode = lastNode.next;
            }
        }
        return lastNode;
    }

    private Node<T> getPrevNode(int index) {
        Node<T> node = null;
        if(headNode != null) {
            node = headNode;
            int count = 0;
            while (node != null && count != index - 1) {
                node = node.next;
                count++;
            }
        }
        return node;
    }

    public void remove(int index){
        if(index == 0){
            headNode = headNode.next;
        }
        else{
            Node<T> node = getPrevNode(index);
            if(node != null) {
                Node<T> temp = node.next;
                node.next = temp.next;
            }
        }
    }

    public boolean contains(T item){
        return find(item) != -1;
    }

    public int find(T item){
        Node<T> node = null;
        int index = -1;
        if(headNode != null) {
            node = headNode;
            while (node != null) {
                index++;
                if(node.data.equals(item)){
                    break;
                }
                node = node.next;
            }
            if(node == null){
                index = -1;
            }
        }
        return index;
    }

    public int size(){
        Node<T> lastNode = null;
        int index = 0;
        if(headNode != null) {
            lastNode = headNode;
            while (lastNode != null) {
                index++;
                lastNode = lastNode.next;
            }
        }
        return index;
    }

    public T get(int index){
        T data = null;
        if(index == 0 && headNode != null){
            data = headNode.data;
        }else{
            Node<T> prevNode = getPrevNode(index);
            if(prevNode != null && prevNode.next != null)
                data = prevNode.next.data;
        }
        return data;
    }

    public SinglyLinkedList<T> copy(){
        SinglyLinkedList listCopy = new SinglyLinkedList();
        Node<T> node = null;
        int index = 0;
        if(headNode != null) {
            node = headNode;
            while (node != null) {
                index++;
                listCopy.add(node.data);
                node = node.next;
            }
        }
        return listCopy;
    }

    public void sort(){

    }

    private class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }
}
