package org.com.LexiKV.storage;

public class KV<K, V> {

    private Node<K, V>[] table;
    private int capacity;
    private int size;
    private final float loadFactor;

    private static final int DEFAULT_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    @SuppressWarnings("unchecked")
    public KV() {
        this.capacity = DEFAULT_CAPACITY;
        this.loadFactor = DEFAULT_LOAD_FACTOR;
        this.table = new Node[capacity];
        this.size = 0;
    }

    private int hash(K key) {
        if (key == null) return 0;
        int h = key.hashCode();
        return h ^ (h >>> 16);
    }

    @SuppressWarnings("unused")
    private int index(int hash) {
        return hash & (capacity - 1);
    }

    @SuppressWarnings("unused")
    private void resize() {
        int newCapacity = capacity * 2;
        @SuppressWarnings("unchecked")
        Node<K, V>[] newTable = new Node[newCapacity];
        for (int i = 0; i < table.length; i++) {
            Node<K, V> curr = table[i];
            while (curr != null) {
                Node<K, V> next = curr.next;
                int newIndex = hash(curr.key) & (newCapacity - 1);
                curr.next = newTable[newIndex];
                newTable[newIndex] = curr;
                curr = next;
            }
        }
        table = newTable;
        capacity = newCapacity;
    }

    @SuppressWarnings("unused")
    private void rehash(Node<K, V> node, Node<K, V>[] newTable) {}

    public void put(K key, V value) {}

    public V get(K key) {}

    public V remove(V value) {}

    public boolean containsKey(K key) {}

    public int size() {}

    public boolean isEmpty() {}

    public void clear() {}

    public Set<K> keySet() {}

    public Collection<V> values() {}

    public int capacity() {}

    public float loadFactor() {}
}
