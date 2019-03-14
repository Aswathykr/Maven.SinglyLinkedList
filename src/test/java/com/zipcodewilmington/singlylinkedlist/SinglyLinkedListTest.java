package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Test
    public void addtoHeadTest(){
        SinglyLinkedList<Integer> intList = new SinglyLinkedList<Integer>();
        Integer valueToadd = new Integer(5);
        intList.add(valueToadd);

        Integer retrievedValue = intList.get(0);
        Assert.assertEquals(retrievedValue, valueToadd);
    }

    @Test
    public void addtoLastTest(){
        SinglyLinkedList<Integer> intList = new SinglyLinkedList<Integer>();
        Integer valuesToadd[] ={ 5,3,6};
        Arrays.stream(valuesToadd)
                .forEach(value -> intList.add(value));

        Integer[] retrievedValue = new Integer[valuesToadd.length];
        for (int i = 0; i < valuesToadd.length; i++) {
            retrievedValue[i] = intList.get(i);
            Assert.assertEquals(retrievedValue[i], valuesToadd[i]);
        }
    }

    @Test
    public void removeFromHeadTest(){
        SinglyLinkedList<Integer> intList = new SinglyLinkedList<Integer>();
        Integer valuesToadd[] ={ 5,3,6};
        Arrays.stream(valuesToadd)
                .forEach(value -> intList.add(value));
        intList.remove(0);
        Integer retrievedValue = intList.get(0);
        Assert.assertEquals(retrievedValue, valuesToadd[1]);
    }

    @Test
    public void removeFromMiddleTest(){
        SinglyLinkedList<Integer> intList = new SinglyLinkedList<Integer>();
        Integer valuesToadd[] ={ 5,3,6};
        Arrays.stream(valuesToadd)
                .forEach(value -> intList.add(value));
        intList.remove(1);
        Integer retrievedValue = intList.get(1);
        Assert.assertEquals(retrievedValue, valuesToadd[2]);
    }

    @Test
    public void removeFromEndTest(){
        SinglyLinkedList<Integer> intList = new SinglyLinkedList<Integer>();
        Integer valuesToadd[] ={ 5,3,6};
        Arrays.stream(valuesToadd)
                .forEach(value -> intList.add(value));
        intList.remove(2);
        Integer retrievedValue = intList.get(2);
        Assert.assertNull(retrievedValue);
    }

    @Test
    public void containsInHeadTrueTest(){
        SinglyLinkedList<Integer> intList = new SinglyLinkedList<Integer>();
        Integer valuesToadd[] ={ 5,3,6};
        Arrays.stream(valuesToadd)
                .forEach(value -> intList.add(value));
        boolean retrievedResult = intList.contains(5);
        Assert.assertTrue(retrievedResult);

    }

    @Test
    public void containsInMiddleTrueTest(){
        SinglyLinkedList<Integer> intList = new SinglyLinkedList<Integer>();
        Integer valuesToadd[] ={ 5,3,6};
        Arrays.stream(valuesToadd)
                .forEach(value -> intList.add(value));
        boolean retrievedResult = intList.contains(3);
        Assert.assertTrue(retrievedResult);

    }

    @Test
    public void containsInEndTrueTest(){
        SinglyLinkedList<Integer> intList = new SinglyLinkedList<Integer>();
        Integer valuesToadd[] ={ 5,3,6};
        Arrays.stream(valuesToadd)
                .forEach(value -> intList.add(value));
        boolean retrievedResult = intList.contains(6);
        Assert.assertTrue(retrievedResult);

    }

    @Test
    public void containsFalseTest(){
        SinglyLinkedList<Integer> intList = new SinglyLinkedList<Integer>();
        Integer valuesToadd[] ={ 5,3,6};
        Arrays.stream(valuesToadd)
                .forEach(value -> intList.add(value));
        boolean retrievedResult = intList.contains(8);
        Assert.assertFalse(retrievedResult);

    }

    @Test
    public void findInHeadTrueTest(){
        SinglyLinkedList<Integer> intList = new SinglyLinkedList<Integer>();
        Integer valuesToadd[] ={ 5,3,6};
        Arrays.stream(valuesToadd)
                .forEach(value -> intList.add(value));
        int retrievedResult = intList.find(5);
        Assert.assertEquals(retrievedResult, 0);

    }

    @Test
    public void findInMiddleTrueTest(){
        SinglyLinkedList<Integer> intList = new SinglyLinkedList<Integer>();
        Integer valuesToadd[] ={ 5,3,6};
        Arrays.stream(valuesToadd)
                .forEach(value -> intList.add(value));
        int retrievedResult = intList.find(3);
        Assert.assertEquals(retrievedResult, 1);

    }

    @Test
    public void findInEndTrueTest(){
        SinglyLinkedList<Integer> intList = new SinglyLinkedList<Integer>();
        Integer valuesToadd[] ={ 5,3,6};
        Arrays.stream(valuesToadd)
                .forEach(value -> intList.add(value));
        int retrievedResult = intList.find(6);
        Assert.assertEquals(retrievedResult, 2);

    }

    @Test
    public void findFalseTest(){
        SinglyLinkedList<Integer> intList = new SinglyLinkedList<Integer>();
        Integer valuesToadd[] ={ 5,3,6};
        Arrays.stream(valuesToadd)
                .forEach(value -> intList.add(value));
        int retrievedResult = intList.find(8);
        Assert.assertEquals(retrievedResult, -1);

    }

    @Test
    public void sizeTest(){
        SinglyLinkedList<Integer> intList = new SinglyLinkedList<Integer>();
        Integer valuesToadd[] ={ 5,3,6};
        Arrays.stream(valuesToadd)
                .forEach(value -> intList.add(value));
        int retrievedResult = intList.size();
        Assert.assertEquals(retrievedResult, 3);

    }
    @Test
    public void sizeFalseTest(){
        SinglyLinkedList<Integer> intList = new SinglyLinkedList<Integer>();

        int retrievedResult = intList.size();
        Assert.assertEquals(retrievedResult, 0);

    }

    @Test
    public void getInHeadTrueTest(){
        SinglyLinkedList<Integer> intList = new SinglyLinkedList<Integer>();
        Integer valuesToadd[] ={ 5,3,6};
        Arrays.stream(valuesToadd)
                .forEach(value -> intList.add(value));
        Integer retrievedResult = intList.get(0);
        Assert.assertEquals(retrievedResult, valuesToadd[0]);

    }

    @Test
    public void getInMiddleTrueTest(){
        SinglyLinkedList<Integer> intList = new SinglyLinkedList<Integer>();
        Integer valuesToadd[] ={ 5,3,6};
        Arrays.stream(valuesToadd)
                .forEach(value -> intList.add(value));
        Integer retrievedResult = intList.get(1);
        Assert.assertEquals(retrievedResult, valuesToadd[1]);

    }

    @Test
    public void getInEndTrueTest(){
        SinglyLinkedList<Integer> intList = new SinglyLinkedList<Integer>();
        Integer valuesToadd[] ={ 5,3,6};
        Arrays.stream(valuesToadd)
                .forEach(value -> intList.add(value));
        Integer retrievedResult = intList.get(2);
        Assert.assertEquals(retrievedResult, valuesToadd[2]);

    }

    @Test
    public void getFalseTest(){
        SinglyLinkedList<Integer> intList = new SinglyLinkedList<Integer>();
        Integer valuesToadd[] ={ 5,3,6};
        Arrays.stream(valuesToadd)
                .forEach(value -> intList.add(value));
        Integer retrievedResult = intList.get(3);
        Assert.assertNull(retrievedResult);

    }

    @Test
    public void copyTest(){
        SinglyLinkedList<Integer> intList = new SinglyLinkedList<Integer>();
        Integer valuesToadd[] ={ 5,3,6};
        Arrays.stream(valuesToadd)
                .forEach(value -> intList.add(value));

        SinglyLinkedList<Integer> copyList= intList.copy();
        Assert.assertEquals(copyList.get(0), valuesToadd[0]);
        Assert.assertEquals(copyList.get(1), valuesToadd[1]);
        Assert.assertEquals(copyList.get(2), valuesToadd[2]);

        intList.remove(0); // This should modify only the intList

        Assert.assertEquals(intList.get(0), valuesToadd[1]);
        Assert.assertEquals(copyList.get(0), valuesToadd[0]);

    }

    public void sortTest(){

    }

}
