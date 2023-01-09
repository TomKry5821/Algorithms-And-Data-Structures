package pl.tk.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {

    final int INDEX = 1;
    final int OUT_OF_BOUND_INDEX = 10;
    final int DATA = 5;
    final int INDEX_DATA = 0;
    private final DoubleLinkedList doubleLinkedList = new DoubleLinkedList();

    @BeforeEach
    void setUp() {
        doubleLinkedList.head = null;
        doubleLinkedList.tail = null;
    }

    @Test
    void testAddToEnd() {
        //GIVEN
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        //WHEN
        for (int el : expected) {
            doubleLinkedList.addToEnd(el);
        }

        //THEN
        Assertions.assertArrayEquals(expected, doubleLinkedList.toArray());
    }

    @Test
    void testAddToStart() {
        //GIVEN
        Integer[] data = {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        //WHEN
        for (int el : data) {
            doubleLinkedList.addToStart(el);
        }

        //THEN
        Assertions.assertArrayEquals(expected, doubleLinkedList.toArray());
    }

    @Test
    void testAddToIndexWithEmptyListShouldThrowIndexOutOfBounds() {
        //GIVEN
        //WHEN
        //THEN
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> doubleLinkedList.addAtIndex(DATA, INDEX));
    }

    @Test
    void testAddToIndexShouldThrowIndexOutOfBounds() {
        //GIVEN
        doubleLinkedList.addToStart(DATA);
        doubleLinkedList.addToStart(DATA);

        //WHEN
        //THEN
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> doubleLinkedList.addAtIndex(DATA, OUT_OF_BOUND_INDEX));
    }

    @Test
    void testCombinedAdd() {
        //GIVEN
        Integer[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] expected = {10, 7, 9, 4, 6, 1, 3, 2, 5, 8};

        //WHEN
        for (int el : data) {
            if (el % 3 == 1)
                doubleLinkedList.addToStart(el);
            else if (el % 3 == 2)
                doubleLinkedList.addToEnd(el);
            else
                doubleLinkedList.addAtIndex(el, INDEX);
        }

        //THEN
        Assertions.assertArrayEquals(expected, doubleLinkedList.toArray());
    }

    @Test
    void testDeleteFirst() {
        //GIVEN
        Integer[] expected = {5, 5, 5};
        doubleLinkedList.addToStart(DATA);
        doubleLinkedList.addToStart(DATA);
        doubleLinkedList.addToStart(DATA);
        doubleLinkedList.addToStart(INDEX_DATA);

        //WHEN
        doubleLinkedList.deleteFirst();

        //THEN
        assertArrayEquals(expected, doubleLinkedList.toArray());
    }

    @Test
    void testDeleteLast() {
        //GIVEN
        Integer[] expected = {0, 5, 5, 5};
        doubleLinkedList.addToStart(DATA);
        doubleLinkedList.addToStart(DATA);
        doubleLinkedList.addToStart(DATA);
        doubleLinkedList.addToStart(DATA);
        doubleLinkedList.addToStart(INDEX_DATA);

        //WHEN
        doubleLinkedList.deleteLast();

        //THEN
        assertArrayEquals(expected, doubleLinkedList.toArray());
    }

    @Test
    void testDeleteAtIndex() {
        //GIVEN
        Integer[] expected = {0, 5, 5};
        doubleLinkedList.addToStart(DATA);
        doubleLinkedList.addToStart(INDEX_DATA);
        doubleLinkedList.addToStart(DATA);
        doubleLinkedList.addToStart(INDEX_DATA);
        doubleLinkedList.addToStart(DATA);

        //WHEN
        doubleLinkedList.deleteAtIndex(0);
        doubleLinkedList.deleteAtIndex(2);

        //THEN
        assertArrayEquals(expected, doubleLinkedList.toArray());
    }

    @Test
    void testDeleteAtIndexShouldThrowIndexOutOfBounds() {
        //GIVEN
        doubleLinkedList.addToEnd(DATA);

        //WHEN
        //THEN
        assertThrows(IndexOutOfBoundsException.class, () -> doubleLinkedList.deleteAtIndex(INDEX));
    }


    @Test
    void testCombinedDelete() {
        //GIVEN
        Integer[] expected = {3, 4, 5, 6, 7};
        Integer[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int el : data) {
            doubleLinkedList.addToEnd(el);
        }

        //WHEN
        doubleLinkedList.deleteFirst();
        doubleLinkedList.deleteFirst();
        doubleLinkedList.deleteLast();
        doubleLinkedList.deleteAtIndex(5);
        doubleLinkedList.deleteAtIndex(5);

        //THEN
        assertArrayEquals(expected, doubleLinkedList.toArray());
    }

    @Test
    void testReverse() {
        //GIVEN
        Integer[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] expected = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        //WHEN
        for (int el : data) {
            doubleLinkedList.addToEnd(el);
        }
        doubleLinkedList.reverse();

        //THEN
        assertArrayEquals(expected, doubleLinkedList.toArray());

    }

}