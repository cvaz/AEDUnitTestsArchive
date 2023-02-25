package serie2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iterables {

	public static Iterable<Integer> getValuesBetween(final Iterable<Integer> src, final int min, final int max ){
		return new Iterable<Integer>() {
			@Override
			public Iterator<Integer> iterator() {
				return new Iterator<Integer>() {
					Integer current=null;
					boolean lastResult = false;
					Iterator<Integer> it= src.iterator();
					
					@Override
					public boolean hasNext() {
						if( current !=null ) return lastResult;
						while( it.hasNext() ){
							current = it.next();		
							if( current.compareTo( min ) >= 0) {
								return lastResult = current.compareTo(max) <= 0;
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
	
	public static Iterable<Integer> exclusiveOr(Iterable<Integer> s1, Iterable<Integer> s2){
		final Iterator<Integer> it1= s1.iterator();
		final Iterator<Integer> it2= s2.iterator();
		return new Iterable<Integer>(){
	
			@Override
			public Iterator<Integer> iterator() {
				return new Iterator<Integer>(){
					private Integer current=null;
					private Integer aux1=null;
					private Integer aux2=null;
					@Override
					public boolean hasNext() {
						if(current!=null) return true;
						if(aux1==null && it1.hasNext()) aux1=it1.next();
						if(aux2==null && it2.hasNext()) aux2=it2.next();
						while(it1.hasNext() && it2.hasNext()){
							if(aux1.equals(aux2)) { aux1=it1.next(); aux2=it2.next();}
							else{
								if(aux1< aux2) { current=aux1; aux1=null; return true;}
								else{current=aux2; aux2=null; return true;
									   }
								}
							}
						if(aux1!=null && aux2!=null){
							 if (aux1.equals(aux2)) {aux1=null; aux2=null;return false;}
							 else{ 
								 if(aux1<aux2) {  current=aux1;aux1=null; return true;}
								 else { current=aux2; aux2=null;  return true;}
							 }	
						}
						else{
							if(aux1==null && aux2==null) return false;
							else{
								if(aux1!=null){ current=aux1;aux1=null; return true;}
								else{
									current=aux2; aux2=null;  return true;
								}
							}
						}
					}

					@Override
					public Integer next() {
						if(hasNext()){
							Integer aux=current;
							current =null;
							return aux;
						}
						throw new NoSuchElementException();
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
