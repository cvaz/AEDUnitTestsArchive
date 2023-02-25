package serie2;

import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class Iterables {
	
	//cvaz
	public static Iterable<Integer> 
	getValuesBetween(final Iterable<Integer> src,  final int l,final int r) {
	
		return new Iterable<Integer>() {
			@Override
			public Iterator<Integer> iterator() {
				return new Iterator<Integer>() {
					Integer current=null;
					boolean lastResult = false;
					Iterator<Integer> it= src.iterator();
					Comparator<Integer> cmp= new Comparator<Integer>() {
						public int compare(Integer i1, Integer i2) {
							return i1.compareTo(i2);
						}
					};	
					@Override
					public boolean hasNext() {
						if( current !=null ) return lastResult;
						while( it.hasNext() ){
							current = it.next();							
							if( cmp.compare(current, l)>=0) {								
								return lastResult = cmp.compare(current, r)<=0;
							}
						}
						return false;
					}

					@Override
					public Integer next() {
						if( !hasNext() ) throw new NoSuchElementException("getValuesBetween:Iterator - no such element");
						Integer next=current;
						current =null;
						return next;
					}

					@Override
					public void remove() {	throw new UnsupportedOperationException("getValuesBetween:Iterator - remove not supported");	}
					
				};
			}
			
		};
	}

	
	public static <K,V> Iterable<K> getKeys(final HashNode<K,V>[] hashMap){
		return new Iterable<K>() {
			public Iterator<K> iterator() {
				return new Iterator<K>() {
					int i = 0;
					HashNode<K,V> it = hashMap[i];
					K curr = null;
				
					public boolean hasNext() {
						while (curr == null) {
							if (i < hashMap.length) {
								if (it == null) { 
									i++; 
									if (i < hashMap.length) it = hashMap[i];
								}
								else {
									curr = it.key;
									it = it.next;
								}
							}
							else return false;
						}
						return true;
					}
				
					public K next() {
						if (!hasNext()) throw new NoSuchElementException("no more elements");
						K result = curr;
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


}
