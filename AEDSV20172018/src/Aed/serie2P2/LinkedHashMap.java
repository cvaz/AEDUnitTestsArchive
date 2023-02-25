package Aed.serie2P2;

import java.util.*;
import java.util.function.BiFunction;

public class LinkedHashMap<K,V> extends AbstractMap<K, V> {
private static final int DEFAULT_CAPACITY = 11;
private static final float DEFAULT_LOAD_FACTOR = 0.75F;

private static class Node<K,V> extends AbstractMap.SimpleEntry<K,V> {
    private final int hc;
    private Node<K,V> next;

    private Node(K key, V value, int hc, Node<K,V> next) {
        super( key, value );
        this.hc = hc;
        this.next = next;
    }
}
    // << Variaveis de instância >>
    //TODO

    //<< Construtores >>
    public LinkedHashMap( int initialCapacity, float lf ) {
        //TODO
    }
    public LinkedHashMap(  ) {
        this( DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR );
    }
    public LinkedHashMap(Map<? extends K, ? extends V> m) {
        this(m.size(), DEFAULT_LOAD_FACTOR);
        putAll(m);
    }

    public V compute(K key, BiFunction<? super K,? super V,? extends V> remappingFunction){
        super.compute(key, remappingFunction);
        return null;
    }

    @Override
    public Set<Entry<K,V>> entrySet() { return entrySet; }
    private Set<Entry<K,V>> entrySet = new AbstractSet<Entry<K, V>>() {
        @Override
        public Iterator<Entry<K, V>> iterator() {
            //TODO
            return null;
        }
        @Override
        public int size() {
            //TODO
            return 0;
        }
        /* Métodos que têm que ser redefinidos OBRIGATORIAMENTE no SET
         * embora tenham herdado uma implementação de AbstractSet
         */
        @Override
        public boolean contains(Object o) {
            //TODO
            // Substituir para fazer O(1)
            return super.contains( o ); // O(n)
        }
        @Override
        public void clear() {
            LinkedHashMap.this.clear();
        }
    };

    /* Métodos que devem ser redefinidos OBRIGATORIAMENTE no SET
     * embora tenham herdado uma implementação de AbstractCollection
     */

    @Override
    public V get( Object k ) {
        //TODO
        // Substituir para fazer O(1)
        return super.get( k ); // O(n)
    }


    @Override
    public boolean containsKey(Object key) {
        //TODO
        // Substituir para fazer O(1)
        return super.containsKey( key);
    }

    @Override
    public void clear() {
        // Substituir para fazer uma implementação mais eficiente
        super.clear();
    }

    //Analisar os métodos
    @Override
    public Set<K> keySet() {
        // Só implementar se conseguirem diminuir a complexidade dos métodos
        // caso contrário, remover este Override
        return super.keySet();
    }
    @Override
    public Collection<V> values() {
        // Só implementar se conseguirem diminuir a complexidade dos métodos
        // caso contrário, remover este Override
        return super.values();
    }

    public V remove( Object k ) {
        throw new UnsupportedOperationException();
    }
}
