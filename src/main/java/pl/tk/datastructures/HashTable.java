package pl.tk.datastructures;

import java.util.ArrayList;
import java.util.Objects;

public class HashTable {

    class HashNode {
        int key;
        int value;
        int hashCode;
        HashNode next;

        public HashNode(int key, int value, int hashCode){
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
            this.next = null;
        }
    }

    ArrayList<HashNode> buckets;
    int bucketsNumber;
    int size;

    public HashTable(){
        buckets = new ArrayList<>();
        bucketsNumber = 10;
        size = 0;

        for(int i = 0; i < bucketsNumber; i++){
            buckets.add(null);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private int hashCode(int data){
        return Objects.hashCode(data);
    }


}
