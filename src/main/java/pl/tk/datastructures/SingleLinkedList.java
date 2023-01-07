package pl.tk.datastructures;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SingleLinkedList {
    SingleLinkedListNode head = null;

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
