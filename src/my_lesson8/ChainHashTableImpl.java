package my_lesson8;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class ChainHashTableImpl<K, V> implements MyHashTable<K, V> {
    private LinkedList<Item<K, V>>[] hashArray;
    private int hashArraySize = 16;
    private  float fillingCoefficient = 0.75f;
    private int countItem = 0;
    static class Item<K, V> implements Entry<K, V> {
        private K key;
        private V value;

        public Item (K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }
    }

    public ChainHashTableImpl(){
        this.hashArray = new LinkedList[this.hashArraySize];
        for (int i = 0; i < this.hashArraySize; i++) {
            this.hashArray[i] = new LinkedList<>();
        }
    }
    public ChainHashTableImpl(int hashArraySize){
        this.hashArraySize = hashArraySize;
        this.hashArray = new LinkedList[this.hashArraySize];
        for (int i = 0; i < this.hashArraySize; i++) {
            this.hashArray[i] = new LinkedList<>();
        }
    }
    public ChainHashTableImpl(int hashArraySize, float fillingCoefficient){
        this.fillingCoefficient = fillingCoefficient;
        this.hashArraySize = hashArraySize;
        this.hashArray = new LinkedList[this.hashArraySize];
        for (int i = 0; i < this.hashArraySize; i++) {
            this.hashArray[i] = new LinkedList<>();
        }
    }
    public ChainHashTableImpl(float fillingCoefficient){
        this.fillingCoefficient = fillingCoefficient;
        this.hashArray = new LinkedList[this.hashArraySize];
        for (int i = 0; i < this.hashArraySize; i++) {
            this.hashArray[i] = new LinkedList<>();
        }
    }




    @Override
    public boolean put(K key, V value) {
        if ((float) countItem / (float) hashArraySize > fillingCoefficient){
            resizeHaseTable();
        }
        Item item = new Item(key, value);
        int hashIndex = hashFunc(key);
        hashArray[hashIndex].add(item);
        countItem++;
        return true;
    }

    @Override
    public ArrayList<V> get(K key) {
        ArrayList<V> valueList = new ArrayList<>();
        int hashIndex = hashFunc(key);
        LinkedList<Item<K, V>> itemList = hashArray[hashIndex];
        if (!itemList.isEmpty()){
            for (int i = 0; i < itemList.size(); i++) {
                if (itemList.get(i).getKey().equals(key)) {
                    valueList.add(itemList.get(i).getValue());
                }
            }
        }
        return valueList;
    }

    @Override
    public ArrayList<V> remove(K key) {
        ArrayList<V> valueList = new ArrayList<>();
        int hashIndex = hashFunc(key);
        LinkedList<Item<K, V>> itemList = hashArray[hashIndex];
        if (!itemList.isEmpty()){
            Iterator<Item<K, V>> iterator = itemList.iterator();
            while (iterator.hasNext()){
                Item<K, V> item = iterator.next();
                if (item.getKey().equals(key)){
                    valueList.add(item.getValue());
                    iterator.remove();
                    countItem--;
                }
            }
        }
        return valueList;
    }

    @Override
    public int size() {
        return countItem;
    }

    @Override
    public boolean isEmpty() {
        return countItem == 0;
    }

    @Override
    public void display() {
        for (int i = 0; i < hashArraySize; i++) {
            System.out.print("hashArray[" + i + "] chain: ");
            for (int j = 0; j < hashArray[i].size(); j++) {
                if (j == hashArray[i].size() - 1){
                    System.out.print("K:" + hashArray[i].get(j).getKey() + ", V:" + hashArray[i].get(j).getValue());
                } else {
                    System.out.print("K:" + hashArray[i].get(j).getKey() + ", V:" + hashArray[i].get(j).getValue() + " --> ");
                }

            }
            System.out.println();
        }
    }

    private void resizeHaseTable(){
        this.hashArraySize *= 2;
        LinkedList<Item<K, V>>[] oldHashArray = hashArray;
        this.hashArray = new LinkedList[hashArraySize];
        for (int i = 0; i < this.hashArraySize; i++) {
            this.hashArray[i] = new LinkedList<>();
        }
        this.countItem = 0;
        for (int i = 0; i < oldHashArray.length; i++) {
            for (int j = 0; j < oldHashArray[i].size(); j++) {
                put(oldHashArray[i].get(j).getKey(), oldHashArray[i].get(j).getValue());
            }
        }
    }
    private int hashFunc(K key){
        return key.hashCode() % hashArraySize;
    }
}
