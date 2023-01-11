package pl.tk.datastructures;

import java.util.ArrayList;
import java.util.Objects;

public class HashTable {

    class HashNode {
        int key;
        int value;
        int hashCode;
        HashNode next;

        public HashNode(int key, int value, int hashCode) {
            this.key = key;
            this.value = value;
            this.hashCode = hashCode;
            this.next = null;
        }
    }

    ArrayList<HashNode> buckets;
    int bucketsNumber;
    int size;

    public HashTable() {
        buckets = new ArrayList<>();
        bucketsNumber = 10;
        size = 0;

        for (int i = 0; i < bucketsNumber; i++) {
            buckets.add(null);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private int hashCode(int data) {
        return Objects.hashCode(data);
    }

    private int getBucketIndex(int key) {
        var keyHash = this.hashCode(key);
        var index = keyHash % bucketsNumber;
        return Math.abs(index);
    }

    public int remove(int key) {
        var bucketIndex = getBucketIndex(key);
        var keyHash = hashCode(key);
        var hashNode = buckets.get(bucketIndex);

        if(Objects.isNull(hashNode.next)){
            buckets.set(bucketIndex, null);
            size -= 1;
        }

        while (Objects.nonNull(hashNode.next)) {
            if (hashNode.next.key == key && keyHash == hashNode.next.hashCode) {
                hashNode.next = hashNode.next.next;
                size -= 1;
                return hashNode.value;
            }
        }
        return -1;
    }

    public int add(int key, int value) {
        var bucketIndex = getBucketIndex(key);
        var keyHash = hashCode(key);
        var hashNode = buckets.get(bucketIndex);

        var newHashNode = new HashNode(key, value, keyHash);
        if (Objects.isNull(hashNode)) {
            hashNode = newHashNode;
            buckets.set(bucketIndex, hashNode);
            size += 1;
            return value;
        }

        while (Objects.nonNull(hashNode.next)) {
            if (hashNode.key == key && hashNode.hashCode == keyHash) {
                hashNode.value = value;
                return value;
            }
            hashNode = hashNode.next;
        }

        newHashNode.next = buckets.get(bucketIndex);
        buckets.set(bucketIndex, newHashNode);

        this.size += 1;

        if ((1.0 * size) / bucketsNumber >= 0.7) {
            ArrayList<HashNode> temp = buckets;
            buckets = new ArrayList<>();
            bucketsNumber = 2 * bucketsNumber;
            size = 0;
            for (int i = 0; i < bucketsNumber; i++)
                buckets.add(null);

            for (HashNode headNode : temp) {
                while (headNode != null) {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
        return value;
    }

    public int get(int key) {
        var bucketIndex = getBucketIndex(key);
        var keyHash = hashCode(key);
        var hashNode = buckets.get(bucketIndex);

        while (Objects.nonNull(hashNode)) {
            if (hashNode.key == key && keyHash == hashNode.hashCode) {
                return hashNode.value;
            }
        }
        return -1;
    }
}
