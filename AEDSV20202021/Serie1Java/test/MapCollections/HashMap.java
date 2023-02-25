package MapCollections;

import java.util.Iterator;

public class HashMap<K,V> implements MutableMap<K,V>{

    static class Node<K,V> implements MutableEntry<K,V>{
        Node<K,V> next;
        Node<K,V> previous;
        K key;
        V value;

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            return this.value=value;
        }
    }


    private Node<K,V>[] table;
    private int dimTable;
    private int size;

    public HashMap(){
        table=(Node<K,V>[]) new Node[10];
        dimTable=10;
        // A função de dispersão aplica-se à chave key
    }

    @Override
    public int getSize() {
        return size;
    }

    private int index(K key){
        int k=key.hashCode()%dimTable;
        return (k<0)?  k+dimTable : k;
    }

    private Node<K,V> search (K key, int pos){
        Node<K,V> current=table[pos];
        while(current!=null){
            if(current.key.equals(key)) return current;
            current=current.next;
        }
        return null;
    }

    //NUnca há chaves repetidas no mapa.
    public V put(K key, V value){
        int pos =index(key);
        Node<K,V> current=search(key,pos);
        if(current!=null) {
            V aux=current.value;
            current.value=value;
            return aux;
        }

        else{
            if(size/dimTable>0.75) { resize();}
            Node<K,V> novo=new Node<>();
            novo.key=key;
            novo.value=value;
            pos=index(key);
            novo.next=table[pos];
            if(table[pos]!=null) table[pos].previous=novo;
            table[pos]=novo;
            size++;
            return null;
        }
    }


    @Override
    public V remove(K key) {
        int pos=index(key);
        Node<K,V> node=search(key,pos);
        if(node!=null) {
            if(node.previous!=null){
                node.previous.next = node.next;}
            else{table[pos]=null;}
            if(node.next!=null)node.next.previous = node.previous;
            size--;
            return node.value;
        }
        return null;
    }

    @Override
    public V get(K key) {
        int pos=index(key);
        Node<K,V> node=search(key,pos);
         if(node!=null) return node.value; else return null;
    }

    @Override
    public Iterator<MutableEntry<K, V>> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<MutableMap.MutableEntry<K, V>> {
       int currentPos= -1;
       Node<K,V> nodeIt= null;
       Node<K,V> currentValue= null;

       public boolean hasNext() {
            if (currentValue != null) return true;
            while (currentPos < table.length) {
                if (nodeIt == null) {
                    currentPos++;
                    if(currentPos<table.length) {
                        if(table[currentPos]!=null)
                        nodeIt = table[currentPos];
                    }
                } else {

                    currentValue = nodeIt;
                 //   System.out.println("it"+currentValue.key);
                    nodeIt = nodeIt.next;
                    return true;
                }

            }
            return false;
        }


        public MutableMap.MutableEntry<K, V> next() {
         //   System.out.println("next"+currentValue.key);
            hasNext();
            Node<K,V> aux = currentValue;
            currentValue = null;
            return aux;
        }
    }












    private void resize(){
        //identico ao outro
    }


}
