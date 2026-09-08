import java.util.Arrays;

public class HashMap<K,V> {

    private int size;
    private int capacity;
    private int numDeleted;
    private Entry<K,V> [] table;
    public static final double MAX_LOAD = 0.75;
    private final Entry<K, V> DELETED = new Entry<>(null, null);


    private static class Entry<K,V> {
        private K key;
        private V value;

        public Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
        public String toString(){
            return key + ":" + value;
        }

    }
    public HashMap(){
        size = 0;
        capacity = 10;
        table = new Entry[capacity];
    }
    public V put(K key, V value){
        if(key == null){
            return null;
        }
        int index = key.hashCode() % capacity;
        while(true){
            if(table[index] == null){ // found an empty spot
                table[index] = new Entry<K, V>(key, value);
                size++;
                if((1.0 *size+numDeleted)/capacity >= MAX_LOAD){
                    rehash();
                }
                return null;
            } else if(key.equals(table[index].key)){ // key is already here, but update value
                V old = table[index].value;
                table[index].value = value;
                return old;
            } else { // Linear probing
                index = (index + 1) % capacity;

            }

        }
    }
    private void rehash(){
        size = 0;
        numDeleted = 0;
        capacity = 2 * capacity + 1;
        Entry<K,V>[] oldTable = table;
        table = new Entry[capacity];
        for(int i = 0; i < oldTable.length;i++){
            if(oldTable[i] == null|| oldTable[i] == DELETED){
                continue;
            } else {
                K key = oldTable[i].key;
                V value = oldTable[i].value;
                this.put(key, value);
            }
        }
    }
    public V get(K key){
        int index = key.hashCode() % capacity;
        while(true){
            if(table[index] == null){
                return null;
            } else if(key.equals(table[index].key)){
                return table[index].value;
            } else {
                index = (index + 1) % capacity;
            }

        }
    }
    public V remove(K key){
          int index = key.hashCode() % capacity;
        while(true){
            if(table[index] == null || table[index] == DELETED){
                return null;
            } else if(key.equals(table[index].key)){
                V old = table[index].value;
                table[index] = DELETED;
                size--;
                numDeleted++;
                return old;
            } else {
                index = (index + 1) % capacity;
            }

        }
    }
    public String toString(){
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for(Entry<K,V> entry: table){
            if(entry == null || entry == DELETED){
                continue;
            }
            builder.append(entry + ", ");
        }
        return builder.substring(0,builder.length() - 2) + "}";
    }
    public int size(){
            return size;
        }


    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0;i < 10; i++){
            map.put( (char)('a' + i) + "ello", i);
            System.out.println(map);
        }
        System.out.println(map);
        System.out.println(map.get("bello"));
    }

}
