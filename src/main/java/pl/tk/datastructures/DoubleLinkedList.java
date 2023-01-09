package pl.tk.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DoubleLinkedList {

    DoubleLinkedListNode head = null;
    DoubleLinkedListNode tail = null;

    public void addToEnd(int data) {
        if (isEmpty()) {
            head = new DoubleLinkedListNode(data);
            tail = head;
            return;
        }

        var newNode = new DoubleLinkedListNode(data);
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void addToStart(int data) {
        if (isEmpty()) {
            head = new DoubleLinkedListNode(data);
            tail = head;
            return;
        }
        var newNode = new DoubleLinkedListNode(data);
        head.prev = newNode;
        newNode.next = head;
        head = newNode;
    }

    public void addAtIndex(int data, int index) {
        if (isEmpty())
            throw new IndexOutOfBoundsException();

        var headCopy = head;
        int actualIndex = 0;
        while (Objects.nonNull(headCopy.next)) {
            if (actualIndex == index - 1) {
                var newNode = new DoubleLinkedListNode(data);
                newNode.next = headCopy.next;
                newNode.prev = headCopy;
                headCopy.next = newNode;
                return;
            }
            actualIndex += 1;
            headCopy = headCopy.next;
        }
        throw new IndexOutOfBoundsException();
    }

    public void deleteFirst() {
        if (isEmpty())
            return;
        head = head.next;
        head.prev = null;
    }

    public void deleteLast() {
        if (isEmpty())
            return;
        tail = tail.prev;
        tail.next = null;
    }

    public void deleteAtIndex(int index) {
        if (isEmpty())
            throw new IndexOutOfBoundsException();
        if (index == 0) {
            deleteFirst();
            return;
        }

        var headCopy = head;
        int actualIndex = 0;
        while (Objects.nonNull(headCopy)) {
            if (actualIndex == index) {
                if (headCopy == tail) {
                    deleteLast();
                    return;
                }
                if (headCopy.next != null)
                    headCopy.next.prev = headCopy.prev;
                if (headCopy.prev != null)
                    headCopy.prev.next = headCopy.next;
                return;
            }
            actualIndex += 1;
            headCopy = headCopy.next;
        }

        throw new IndexOutOfBoundsException();
    }

    public void reverse() {
        if (isEmpty())
            return;

        var current = head;
        DoubleLinkedListNode tmp;
        while (Objects.nonNull(current)) {
            tmp = current.next;
            current.next = current.prev;
            current.prev = tmp;
            current = tmp;
        }
        tmp = head;
        head = tail;
        tail = tmp;
    }

    public Integer[] toArray() {
        List<Integer> arr = new ArrayList<>();
        var headCopy = head;

        while (Objects.nonNull(headCopy)) {
            arr.add(headCopy.data);
            headCopy = headCopy.next;
        }
        return arr.toArray(Integer[]::new);
    }

    private boolean isEmpty() {
        return Objects.isNull(head) && Objects.isNull(tail);
    }

}

class DoubleLinkedListNode {
    int data;
    DoubleLinkedListNode next;
    DoubleLinkedListNode prev;

    public DoubleLinkedListNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}
