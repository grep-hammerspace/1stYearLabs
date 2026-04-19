package org.example.answers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyHashMap<K, V> {

    // 16 is Java's own default — a power of two, which makes modulo cheap and
    // distributes keys evenly. A real implementation would resize when the load
    // factor (size / capacity) exceeds ~0.75 to keep operations O(1) amortised.
    private static final int DEFAULT_CAPACITY = 16;

    // Each bucket entry stores a key-value pair (separate chaining collision strategy).
    private static class Entry<K, V> {
        K key;
        V value;
        Entry(K key, V value) { this.key = key; this.value = value; }
    }

    // Each bucket is a list that holds all entries whose keys hash to the same index.
    private final List<List<Entry<K, V>>> buckets;
    private int size;

    public MyHashMap() {
        buckets = new ArrayList<>(DEFAULT_CAPACITY);
        // Pre-fill every bucket slot so we never get an IndexOutOfBoundsException
        // when trying to access a bucket that hasn't had an entry added yet.
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    // Maps any key to a valid bucket index [0, DEFAULT_CAPACITY).
    // Math.abs handles negative hash codes; null always goes to bucket 0.
    private int bucketIndex(K key) {
        return (key == null) ? 0 : Math.abs(Objects.hashCode(key) % DEFAULT_CAPACITY);
    }

    // If the key already exists in the bucket, update its value (no duplicate keys).
    // Otherwise append a new entry.
    public void put(K key, V value) {
        List<Entry<K, V>> bucket = buckets.get(bucketIndex(key));
        for (Entry<K, V> entry : bucket) {
            if (Objects.equals(entry.key, key)) {
                entry.value = value;
                return;
            }
        }
        bucket.add(new Entry<>(key, value));
        size++;
    }

    // Hash to the correct bucket, then scan for an exact key match.
    // Returns null if the key is not present (same contract as java.util.HashMap).
    public V get(K key) {
        for (Entry<K, V> entry : buckets.get(bucketIndex(key))) {
            if (Objects.equals(entry.key, key)) return entry.value;
        }
        return null;
    }

    // Use an index-based loop so we can call bucket.remove(i) — a for-each loop
    // would throw ConcurrentModificationException if we removed during iteration.
    public V remove(K key) {
        List<Entry<K, V>> bucket = buckets.get(bucketIndex(key));
        for (int i = 0; i < bucket.size(); i++) {
            if (Objects.equals(bucket.get(i).key, key)) {
                V value = bucket.get(i).value;
                bucket.remove(i);
                size--;
                return value;
            }
        }
        return null;
    }

    public boolean containsKey(K key) {
        for (Entry<K, V> entry : buckets.get(bucketIndex(key))) {
            if (Objects.equals(entry.key, key)) return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
