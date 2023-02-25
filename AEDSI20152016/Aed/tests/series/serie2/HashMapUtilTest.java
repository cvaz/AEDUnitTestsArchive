package series.serie2;

import java.util.ArrayList;
import java.util.Iterator;

public class HashMapUtilTest {
	
	public static <K,V> HashNode<K,V>[] emptyHashMap(int dim) {
		 HashNode<K,V>[] empty= ( HashNode<K,V>[]) new HashNode[dim];
		 return empty;
	}
	
	public static <K,V> boolean isEmptyHashMap(HashNode<K,V>[] hashMap){
		for(HashNode<K,V> node:hashMap){
			if(node!=null) return false;
		}
		return true;
	}
	
	public static <K,V>  HashNode<K, V> getList(ArrayList<K> keys, ArrayList<V> values){
		HashNode<K,V> toReturn=null;
		Iterator<K> iter1= keys.iterator();
		Iterator<V> iter2=values.iterator();
		while(iter1.hasNext() && iter2.hasNext()){
 			HashNode<K, V> n=new HashNode<K, V>();
			n.pair=new Pair<K,V>();
			n.pair.key=iter1.next();
			n.pair.value=iter2.next();
			n.next=toReturn;
			toReturn=n;
		}
		return toReturn;
	}
	
	public static <K,V> HashNode<K,V>[] getHashMap(ArrayList<K> keys, ArrayList<V> values, int dim){
		 HashNode<K,V>[] hashMap= ( HashNode<K,V>[]) new HashNode[dim];
		 Iterator<K> iter1= keys.iterator();
			Iterator<V> iter2=values.iterator();
			K key;
			V value;
			while(iter1.hasNext() && iter2.hasNext()){
	 			 key=iter1.next();
	 			 value=iter2.next();
	 			 int index=index(key,hashMap);
				 if(search(hashMap[index], key)==null){
					 HashNode<K, V> n=new HashNode<K, V>();
					 n.pair=new Pair<K,V>();
					 n.pair.key=key; n.pair.value=value;
					 n.next=hashMap[index];
					 hashMap[index]=n;
				 }
			}
			return hashMap;
	}
	private static  <K,V> HashNode<K,V> search(HashNode<K,V> list, K key){
		while(list!=null){
			if(list.pair.key.equals(key)) return list;
			list=list.next;
		}
		return null;
	}
	
	
	public static <K,V> boolean isSubMap(HashNode<K,V>[] subMap, HashNode<K,V>[] map ){
		for(HashNode<K,V> node:subMap){
			if(!containsEntry(node.pair.key,node.pair.value, map)) return false;
		}
		return true;
	}
	
	public static <K,V> boolean containsKey(K key, HashNode<K,V>[] map){
		 int index=index(key,map);
		 HashNode<K,V> node=map[index];
		 while(node!=null){
			 if(node.pair.key.equals(key) ) return true;
			 node=node.next;
		 }
		 return false;
		 
	}
	
	public static <K,V> boolean containsEntry(K key, V value, HashNode<K,V>[] map){
		 int index=index(key,map);
		 HashNode<K,V> node=map[index];
		 while(node!=null){
			 if(node.pair.key.equals(key) && node.pair.value.equals(value)) return true;
			 node=node.next;
		 }
		 return false;
	}

	public static <K,V> boolean containsEntry(Pair<K,V> pair, HashNode<K,V>[] map){
		return containsEntry(pair.key,pair.value, map);
	}


	
	private static <K,V> int index(K key, HashNode<K,V>[] map){
		 int index=key.hashCode()%map.length;
		 return (index<0)? index+=map.length:index;
	}
	
	
	

}
