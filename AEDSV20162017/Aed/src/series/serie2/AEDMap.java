package series.serie2;

/**
 * Created by cvaz on 15/05/2017.
 */
public class AEDMap<K,V> {

    static class Pair<K,V>{
        K k;
        V v;
    }
    private static class Node<K,V>{
        Pair<K,V> p;
        Node<K,V> next;
    }

    private Node<K,V>[] table;

    public AEDMap(){
        table=(Node<K,V>[]) new Object[10];
    }
}
