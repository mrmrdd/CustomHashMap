package com.ak;

import java.util.Arrays;

public class CustomMap<K, V> {
    private final int defaultSize = 500;
    private Entry[] entries;
    private int size = 0;

    public CustomMap() {
        entries = new Entry[defaultSize];
    }

    public CustomMap(int size) {
        entries = new Entry[size];
    }

    public CustomMap(CustomMap<Integer, Long> map) {
        entries = map.getEntries();
    }

    public Entry[] getEntries() {
        return entries;
    }

    public boolean put(Integer key, Long value) {
        if(key >= entries.length)
            ensureCapacity(key);
        if(entries[key] == null)
            size++;
        entries[key] = new Entry(key, value);
        return true;
    }

    private void ensureCapacity(int key) {
        entries = Arrays.copyOf(entries, key + 1000);
    }

    public Long get(Integer key) {
        for (int i = 0; i < entries.length; i++) {
            if (entries[i] != null) {
                if (entries[i].getKey() == key)
                    return entries[i].getValue();
            }
        }
        return null;
    }

    public int size(){
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < entries.length; i++) {
            if(entries[i] != null)
            sb.append("(" + entries[i].getKey() + " - " + entries[i].getValue() + ")");
        }
        sb.append(" ]");
        return sb.toString();
    }
}
