package org.example.answers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyHashMap<K, V> {

    private static final int DEFAULT_CAPACITY = 16;

    private static class Entry<K, V> {
        K key;
        V value;
        Entry(K key, V value) { this.key = key; this.value = value; }
    }

    private final List<List<Entry<K, V>>> buckets;
    private int size;

    public MyHashMap() {
        buckets = new ArrayList<>(DEFAULT_CAPACITY);
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    private int bucketIndex(K key) {
        return (key == null) ? 0 : Math.abs(Objects.hashCode(key) % DEFAULT_CAPACITY);
    }

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

    public V get(K key) {
        for (Entry<K, V> entry : buckets.get(bucketIndex(key))) {
            if (Objects.equals(entry.key, key)) return entry.value;
        }
        return null;
    }

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
