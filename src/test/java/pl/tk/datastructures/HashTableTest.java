package pl.tk.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HashTableTest {

    private final int KEY = 1;
    private final int DATA = 1;

    private HashTable hashTable = new HashTable();

    @BeforeEach
    void setUp(){
        hashTable = new HashTable();
    }

    @Test
    void testAdd(){
        //GIVEN
        int expectedSize = 1;
        boolean expectedIsEmpty = false;
        int expectedValue = 1;

        //WHEN
        var actualValue = hashTable.add(KEY, DATA);

        //THEN
        Assertions.assertEquals(expectedIsEmpty, hashTable.isEmpty());
        Assertions.assertEquals(expectedSize, hashTable.size);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    void testRemove() {
        //GIVEN
        int expectedSize = 0;
        boolean expectedIsEmpty = true;
        int expectedValue = 1;

        //WHEN
        hashTable.add(KEY, DATA);
        var actualValue = hashTable.remove(KEY);

        //THEN
        Assertions.assertEquals(expectedIsEmpty, hashTable.isEmpty());
        Assertions.assertEquals(expectedSize, hashTable.size);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    void testGet() {
        //GIVEN
        int expectedValue = 1;

        //WHEN
        hashTable.add(KEY, DATA);
        var actualValue = hashTable.get(KEY);

        //THEN
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    void testCombinedAddRemoveGet(){
        //GIVEN
        //WHEN
        hashTable.add(1, 1);
        hashTable.add(2, 2);
        hashTable.add(3, 3);
        hashTable.add(1, 4);
        hashTable.remove(2);

        //THEN
        Assertions.assertEquals(3, hashTable.size());
        Assertions.assertEquals(4, hashTable.get(1));
        Assertions.assertEquals(3, hashTable.get(3));
        Assertions.assertEquals(-1, hashTable.get(2));
    }
}