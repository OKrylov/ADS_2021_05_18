package my_lesson8;

import java.util.ArrayList;

public interface MyHashTable<K, V> {

    boolean put(K key, V value);

    ArrayList<V> get(K key);

    ArrayList<V> remove(K key);

    int size();

    boolean isEmpty();

    void display();

    interface Entry<K, V> {

        K getKey();

        V getValue();

        void setValue(V value);
    }

}
