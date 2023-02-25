package MapCollections;

import java.util.Iterator;

interface MutableMap<K,V> {
  interface  MutableEntry<K,V>{
        K getKey();
        V getValue();
        V setValue(V newValue) ;
    }

    int getSize();
    V put(K key, V value);
    V remove(K key);
    V get(K key);
    Iterator<MutableEntry<K,V>> iterator();

}
