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
            Node<T> last = getLastNode(headNode);
            last.next = node;
        }
    }

    private Node<T> getLastNode(Node<T> head) {
        Node<T> lastNode = null;
        if(head != null) {
            lastNode = head;
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
        mergeSort();
    }

    private class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    private Node<T> traverse(Node<T> node, int length){
        int index = 0;
        Node<T> newNode = node;
        while (index < length && node != null){
            node = node.next;
            index++;
        }
        return node;
    }

    private void mergeSort(){
        int size = size();
        if(size <= 1) // Already Sorted
            return;

        Node<T> firstHalf = headNode;
        Node<T> secondHalf = headNode.next;
        Node<T> prevLastNode = null;
        Node<T> newHead = null;
        for(int currentSize = 1; currentSize < size; currentSize  *= 2){
            newHead = null;
            while(firstHalf != null || secondHalf != null) {
                Node<T> sortedHead = mergeSorted(firstHalf, secondHalf, currentSize);
                if (newHead == null) {
                    newHead = sortedHead;
                } else {
                    prevLastNode.next = sortedHead;
                }
                prevLastNode = getLastNode(sortedHead);
                firstHalf = traverse(firstHalf, currentSize*2);
                secondHalf = traverse(firstHalf, currentSize);
            }
            firstHalf = newHead;
            secondHalf = traverse(newHead, currentSize *2);

        }
        headNode = newHead;
    }

    private Node<T> mergeSorted(Node<T> firstNode, Node<T> secondNode, int length){
        Node<T> head = null;
        Node<T> last = null;

        Node<T> traverseFirst = firstNode;
        Node<T> traverseSecond = secondNode;

        int firstIdx = 0;
        int secondIdx = 0;
        if(firstNode != null && secondNode != null) {
            while (firstIdx < length && secondIdx < length && traverseFirst != null && traverseSecond != null ) {
                if (traverseFirst.data.compareTo(traverseSecond.data) < 0) {
                    if (head == null) {
                        head = new Node<>(traverseFirst.data);
                        last = head;
                    } else {
                        last.next = new Node<>(traverseFirst.data);
                        last = last.next;
                    }
                    traverseFirst = traverseFirst.next;
                    firstIdx++;
                } else {
                    if (head == null) {
                        head = new Node<>(traverseSecond.data);
                        last = head;
                    } else {
                        last.next = new Node<>(traverseSecond.data);
                        last = last.next;
                    }

                    traverseSecond = traverseSecond.next;
                    secondIdx++;
                }
            }
        }else{
            if(firstNode != null) {
                head = firstNode;
                last = head;
                traverseFirst = last.next;
            }else if(secondNode != null) {
                head = secondNode;
                last = secondNode;
                traverseSecond = last.next;
            }
        }

        while (firstIdx < length && traverseFirst != null){
            last.next = new Node<>(traverseFirst.data);
            last = last.next;
            traverseFirst = traverseFirst.next;
            firstIdx++;
        }

        while(secondIdx < length && traverseSecond != null){
            last.next = new Node<>(traverseSecond.data);
            last = last.next;
            traverseSecond = traverseSecond.next;
            secondIdx++;
        }

        last.next = null;
        return head;
    }
}
