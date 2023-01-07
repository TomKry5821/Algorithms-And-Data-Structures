package pl.tk.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SingleLinkedList {
    SingleLinkedListNode head = null;

    public void addToEnd(int data) {
        if (Objects.isNull(this.head)) {
            head = new SingleLinkedListNode(data);
            return;
        }
        var headCopy = head;
        while (!Objects.isNull(headCopy.next)) {
            headCopy = headCopy.next;
        }
        headCopy.next = new SingleLinkedListNode(data);
    }

    public void addToStart(int data) {
        if (Objects.isNull(this.head)) {
            head = new SingleLinkedListNode(data);
            return;
        }
        var newNode = new SingleLinkedListNode(data);
        newNode.next = head;
        head = newNode;
    }

    public void addAtIndex(int data, int index) {
        if (Objects.isNull(head))
            throw new IndexOutOfBoundsException();

        var headCopy = head;
        int actualIndex = 0;
        while (Objects.nonNull(headCopy.next)) {
            if (actualIndex == index - 1) {
                var newNode = new SingleLinkedListNode(data);
                newNode.next = headCopy.next;
                headCopy.next = newNode;
                return;
            }
            actualIndex += 1;
            headCopy = headCopy.next;
        }
        throw new IndexOutOfBoundsException();
    }

    public Integer[] toArray() {
        List<Integer> arr = new ArrayList<>();
        var headCopy = head;

        while (!Objects.isNull(headCopy)) {
            arr.add(headCopy.data);
            headCopy = headCopy.next;
        }
        return arr.toArray(Integer[]::new);
    }

}

class SingleLinkedListNode {
    int data;
    SingleLinkedListNode next;

    public SingleLinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
