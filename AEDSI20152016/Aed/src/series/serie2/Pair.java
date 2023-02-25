package series.serie2;

public class Pair<K,V> {
    public K key;
    public V value;

    public Pair(){}
    public Pair(K k, V v){
        key=k;
        value=v;
    }

    public boolean equals(Object o){
        if(! (o instanceof Pair)) return false;
        Pair<K,V> pair=(Pair<K,V>) o;
        return this.key.equals(pair.key) && this.value.equals(pair.value);
    }
}
