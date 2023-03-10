package pl.tk.datastructures;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SingleLinkedListTest {
    final int INDEX = 1;
    final int OUT_OF_BOUND_INDEX = 10;
    final int DATA = 5;
    final int INDEX_DATA = 0;
    private final SingleLinkedList singleLinkedList = new SingleLinkedList();

    @BeforeEach
    void setUp() {
        singleLinkedList.head = null;
    }

    @Test
    void testAddToEnd() {
        //GIVEN
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        //WHEN
        for (int el : expected) {
            singleLinkedList.addToEnd(el);
        }

        //THEN
        Assertions.assertArrayEquals(expected, singleLinkedList.toArray());
    }

    @Test
    void testAddToStart() {
        //GIVEN
        Integer[] data = {15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Integer[] expected = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        //WHEN
        for (int el : data) {
            singleLinkedList.addToStart(el);
        }

        //THEN
        Assertions.assertArrayEquals(expected, singleLinkedList.toArray());
    }

    @Test
    void testAddAtIndex() {
        //GIVEN
        final int EXPECTED_INDEX_DATA = 0;
        final int EXPECTED_ARRAY_LENGTH = 4;

        //WHEN
        singleLinkedList.addToStart(DATA);
        singleLinkedList.addToStart(DATA);
        singleLinkedList.addToStart(DATA);
        singleLinkedList.addAtIndex(INDEX_DATA, INDEX);

        //THEN
        Assertions.assertEquals(EXPECTED_ARRAY_LENGTH, singleLinkedList.toArray().length);
        Assertions.assertEquals(EXPECTED_INDEX_DATA, singleLinkedList.toArray()[INDEX]);
    }

    @Test
    void testAddToIndexWithEmptyListShouldThrowIndexOutOfBounds() {
        //GIVEN
        //WHEN
        //THEN
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> singleLinkedList.addAtIndex(DATA, INDEX));
    }

    @Test
    void testAddToIndexShouldThrowIndexOutOfBounds() {
        //GIVEN
        singleLinkedList.addToStart(DATA);
        singleLinkedList.addToStart(DATA);

        //WHEN
        //THEN
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> singleLinkedList.addAtIndex(DATA, OUT_OF_BOUND_INDEX));
    }

    @Test
    void testCombinedAdd() {
        //GIVEN
        Integer[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] expected = {10, 7, 9, 4, 6, 1, 3, 2, 5, 8};

        //WHEN
        for (int el : data) {
            if (el % 3 == 1)
                singleLinkedList.addToStart(el);
            else if (el % 3 == 2)
                singleLinkedList.addToEnd(el);
            else
                singleLinkedList.addAtIndex(el, INDEX);
        }

        //THEN
        Assertions.assertArrayEquals(expected, singleLinkedList.toArray());
    }

    @Test
    void testDeleteFirst() {
        //GIVEN
        Integer[] expected = {5, 5, 5};
        singleLinkedList.addToStart(DATA);
        singleLinkedList.addToStart(DATA);
        singleLinkedList.addToStart(DATA);
        singleLinkedList.addToStart(INDEX_DATA);

        //WHEN
        singleLinkedList.deleteFirst();

        //THEN
        Assertions.assertArrayEquals(expected, singleLinkedList.toArray());
    }

    @Test
    void testDeleteLast() {
        //GIVEN
        Integer[] expected = {0, 5, 5, 5};
        singleLinkedList.addToStart(DATA);
        singleLinkedList.addToStart(DATA);
        singleLinkedList.addToStart(DATA);
        singleLinkedList.addToStart(DATA);
        singleLinkedList.addToStart(INDEX_DATA);

        //WHEN
        singleLinkedList.deleteLast();

        //THEN
        Assertions.assertArrayEquals(expected, singleLinkedList.toArray());
    }

    @Test
    void testDeleteAtIndex() {
        //GIVEN
        Integer[] expected = {0, 0};
        singleLinkedList.addToStart(DATA);
        singleLinkedList.addToStart(INDEX_DATA);
        singleLinkedList.addToStart(DATA);
        singleLinkedList.addToStart(INDEX_DATA);
        singleLinkedList.addToStart(DATA);

        //WHEN
        singleLinkedList.deleteAtIndex(0);
        singleLinkedList.deleteAtIndex(1);
        singleLinkedList.deleteAtIndex(2);

        //THEN
        Assertions.assertArrayEquals(expected, singleLinkedList.toArray());
    }

    @Test
    void testDeleteAtIndexShouldThrowIndexOutOfBounds() {
        //GIVEN
        singleLinkedList.addToEnd(DATA);

        //WHEN
        //THEN
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> singleLinkedList.deleteAtIndex(INDEX));
    }


    @Test
    void testCombinedDelete() {
        //GIVEN
        Integer[] expected = {3, 4, 5, 6, 7};
        Integer[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int el : data) {
            singleLinkedList.addToEnd(el);
        }

        //WHEN
        singleLinkedList.deleteFirst();
        singleLinkedList.deleteFirst();
        singleLinkedList.deleteLast();
        singleLinkedList.deleteAtIndex(5);
        singleLinkedList.deleteAtIndex(5);

        //THEN
        Assertions.assertArrayEquals(expected, singleLinkedList.toArray());
    }

    @Test
    void testReverse() {
        //GIVEN
        Integer[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] expected = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

        //WHEN
        for (int el : data) {
            singleLinkedList.addToEnd(el);
        }
        singleLinkedList.reverse();

        //THEN
        Assertions.assertArrayEquals(expected, singleLinkedList.toArray());

    }


}