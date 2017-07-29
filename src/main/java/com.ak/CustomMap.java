package com.ak;


public class CustomMap<K, V> {
    private final int defaultSize = 1000;
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

    private int getHash(Integer key) {
        return key.hashCode();
    }

    public boolean put(Integer key, Long value) {
        int h = getHash(key);
        int i = 0;
        try {
            for (i = h + 1; i != h; i = (i + 1) % entries.length) {
                if (entries[i].getKey() == key) {
                    entries[i] = new Entry(key, value);
                    return true;
                }
            }
            return false;
        } catch (NullPointerException e) {
            entries[h] = new Entry(key, value);
            return true;
        }
    }

    public Long get(Integer key) {
        int h = getHash(key);
        try {
            if (entries[h].getKey() == key) {
                return entries[h].getValue();
            }
            for (int i = h + 1; i != h; i = (i + 1) % entries.length) {
                if (entries[i].getKey() == key) {
                    return entries[h].getValue();
                }
            }
            return null;
        } catch (NullPointerException e) {
            return null;
        }
    }

    public int size(){
        size = 0;
        for (int i = 0; i < entries.length; i++) {
            if(entries[i] != null)
                size++;
        }
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
