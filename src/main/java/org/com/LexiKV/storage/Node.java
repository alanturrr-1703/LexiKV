package org.com.LexiKV.storage;

import java.time.LocalDateTime;

public class Node<K, V> {

    int hash;
    public final K key;
    public V value;
    public Node<K, V> next;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;

    public Node(int hash, K key, V value) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = null;
        LocalDateTime now = LocalDateTime.now();
        this.createdAt = now;
        this.updatedAt = now;
    }

    public void updateValue(V value) {
        this.value = value;
        LocalDateTime now = LocalDateTime.now();
        this.updatedAt = now;
    }
}
