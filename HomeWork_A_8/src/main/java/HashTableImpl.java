import java.util.ArrayList;

public class HashTableImpl<K, V> implements HashTable<K, V> {

    private final ArrayList<Item<K, V>>[] data;
    private int size;
    private Item<K, V> emptyItem;

    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" + "key=" + key + ", value=" + value + '}';
        }
    }

    public HashTableImpl(int initialCapacity) {
        this.data = new ArrayList[initialCapacity * 2];
        emptyItem = new Item<>(null, null);
    }

    public HashTableImpl() {
        this(16);
    }

    @Override
    public boolean put(K key, V value) {
        if (size() == data.length) {
            return false;
        }

        int index = hashFunc(key);

        if (data[index] != null) {
            for (Item<K, V> dt: data[index]) {
                if (isKeysEquals(dt, key)) {
                    dt.setValue(value);
                    return true;
                }
            }
            data[index].add(new Item<>(key, value));

        } else {
            data[index] = new ArrayList<>();
            data[index].add(new Item<>(key, value));
            size++;
        }
        return true;
    }

    private boolean isKeysEquals(Item<K, V> item, K key) {
        if (item == emptyItem) {
            return false;
        }
        return (item.getKey() == null) ? (key == null) : item.getKey().equals(key);
    }


    private int hashFunc(K key) {
        return Math.abs(key.hashCode() % data.length);
    }

    @Override
    public V get(K key) {

        int index = indexOf(key);
        if (index > 0) {

            for (Item<K, V> dt : data[index]) {
                if (dt.key.equals(key)) {
                    return dt.getValue();

                }
            }
        }
        return null;
    }

    private int indexOf (K key) {
        int index = hashFunc(key);

        int count = 0;
        while (count < data.length) {
            ArrayList item = data[index];
            if (item == null) {
                break;
            }
            for (Item<K, V> dt: data[index]) {
                if (isKeysEquals(dt, key)) {
                    return index;
                }
            }
        }
        return -1;
    }

    @Override
    public V remove(K key) {
        int index = indexOf(key);

        if (index > 0) {

            for (Item<K, V> dt : data[index]) {
                if (isKeysEquals(dt, key)) {
                    Item<K, V> temp = dt;
                    data[index].remove(dt);

                    if (data[index].isEmpty()){
                        data[index] = null;
                    }
                    return temp.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size != 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-----------------------\n");
        for (int i = 0; i < data.length; i++) {
            sb.append(String.format("%d = [%s]%n", i, data[i]));
        }
        sb.append("-----------------------\n");
        return sb.toString();
    }
}
