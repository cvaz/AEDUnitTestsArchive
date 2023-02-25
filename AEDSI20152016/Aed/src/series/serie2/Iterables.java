package series.serie2;

import java.util.*;
public class Iterables {

	public static <K,V> Iterable<Pair<K,V>> getEntries(HashNode<K,V>[] hashMap){
		return new Iterable<Pair<K,V>>() {
			public Iterator<Pair<K,V>> iterator() {
				return new Iterator<Pair<K,V>>() {
					int i = 0;
					HashNode<K,V> it = hashMap[i];
					Pair<K,V> curr = null;
				
					public boolean hasNext() {
						while (curr == null) {
							if (i < hashMap.length) {
								if (it == null) { 
									i++; 
									if (i < hashMap.length) it = hashMap[i];
								}
								else {
									curr = it.pair;
									it = it.next;
								}
							}
							else return false;
						}
						return true;
					}
				
					public Pair<K,V> next() {
						if (!hasNext()) throw new NoSuchElementException("no more elements");
						Pair<K,V> result = curr;
						curr = null;
						return result;
					}
				
					@Override
					public void remove() {
						throw new UnsupportedOperationException("remove not supported");
					}	
				};
			}
		};
	}

	public static Iterable<String> getPhrasesStart(Iterable<Iterable<String>> phrases, String prefix){
		return new Iterable<String>(){
			public Iterator<String> iterator(){
				return new Iterator<String>(){
					Iterator<Iterable<String>> it = phrases.iterator();
					Iterator<String> itStr;
					String curr, currSeq = "";
					boolean endSubList = true;
					public boolean hasNext() {
						while (curr == null){
							if (endSubList){
								if (currSeq.indexOf(prefix) == 0) curr = currSeq;
								else curr = null;
								currSeq = "";
								endSubList = false;
								if (it.hasNext()) itStr = it.next().iterator();
								else if (curr == null) return false;
							}
							else {
								if(itStr.hasNext()) currSeq += itStr.next() + " ";
								else endSubList = true;
							}
						}
						return true;
					}
					public String next() {
						if(!hasNext()) throw new NoSuchElementException("getPhrasesStart: no more elements");
						String aux=curr;
						curr=null;
						return aux.trim();
					}

					public void remove() {
						throw new UnsupportedOperationException("getPhrasesStart: remove not supported");
					}
				};
			}
		};
	}

	public static <E> Iterable<Pair<E, Integer>> histogram(final E[] array){
		//BATOTA
		final HashMap<E, Integer> hashmap=new HashMap<E,Integer>();
		for(int i=0; i<array.length;i++){
			Integer count=hashmap.get(array[i]);
			if(count!=null)
				hashmap.put(array[i], ++count);
			else
				hashmap.put(array[i], 1);
		}
		return new Iterable<Pair<E,Integer>>() {
			@Override
			public Iterator<Pair<E, Integer>> iterator() {
				return new Iterator<Pair<E,Integer>>() {

					Pair<E, Integer> curr = null;

					Iterator<Map.Entry<E, Integer>> setIterator = hashmap.entrySet().iterator();
					@Override
					public boolean hasNext() {
						if (curr != null)
							return true;
						if(setIterator.hasNext()){
							Map.Entry<E,Integer> elem=setIterator.next();
							curr=new Pair(elem.getKey(),elem.getValue());
							return true;
						}

						return false;
					}

					@Override
					public Pair<E, Integer> next() {
						Pair<E, Integer> aux = null;
						if (hasNext()) {
							aux = curr;
							curr = null;
							return aux;
						}
						return null;
					}
					@Override
					public void remove() {
						throw new UnsupportedOperationException();
					}
				};
			}

		};
	}



}
