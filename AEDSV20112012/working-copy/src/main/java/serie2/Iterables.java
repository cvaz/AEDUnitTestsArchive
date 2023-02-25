package serie2;

import java.util.*;

public class Iterables {
	public static <T> Iterable<T> concat( final Iterable< Iterable<T> > src) {
		return new Iterable<T>() {
			@Override
			public Iterator<T> iterator() {
				// TODO Auto-generated method stub
				return new Iterator<T>() {
					Iterator< Iterable<T> > i1 = src.iterator();
					Iterator<T> i2 = i1.hasNext()? i1.next().iterator()
							                     : Collections.<T>emptyList().iterator();
					@Override
					public boolean hasNext() {
						if ( i2.hasNext() ) return true;
						while ( i1.hasNext() ) {
							i2 = i1.next().iterator();
							if ( i2.hasNext() ) return true;
						}
						return false;
					}

					@Override
					public T next() {
						if ( ! hasNext() ) throw new NoSuchElementException(" ... ");
						return i2.next();
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException(" ... ");
					}
					
				};
			}
			
		};
	}
	
	public static Iterable<Integer> intersection( final Iterable< Integer > s1, final Iterable<Integer> s2) {
		return new Iterable<Integer>() {

			@Override
			public Iterator<Integer> iterator() {
				// TODO Auto-generated method stub
				return new Iterator<Integer> () {
					Integer  v;
					Iterator<Integer> i1= s1.iterator(), i2= s2.iterator();
					@Override
					public boolean hasNext() {
						// TODO Auto-generated method stub
						if ( v != null ) return true;
						if ( i1.hasNext() && i2.hasNext() ) {
							Integer v1= i1.next(), v2 = i2.next();					
							while ( v1 != null && v2 != null  ) {
								if ( v1 > v2 ) {
									if ( i2.hasNext() ) v2= i2.next();
									else break;
								}
								else if ( v1 < v2 ) {
									if ( i1.hasNext() ) v1= i1.next();
									else break;
								}
								else {
									v= v1;
									return true;
								}
							}
						}
						return false;
					}

					@Override
					public Integer next() {
						if ( !hasNext() ) throw new NoSuchElementException(" ... ");
						Integer res = v; 
						v= null;
						return res;
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException(" ... ");
					}				
				};
			}
			
		};
	}
	
	public static Iterable<String> getWordsThatContains(final Iterable<Iterable<String>> src, final String word) {
		return new Iterable<String>() {

			@Override
			public Iterator<String> iterator() {
				// TODO Auto-generated method stub
				return new Iterator<String> () {
					Iterator<String> it = concat( src ).iterator();
					String v;
					@Override
					public boolean hasNext() {
						if ( v != null ) return true;
						while ( it.hasNext() ) {
							v = it.next(); 
							if ( v.contains( word ) ) return true;
						}
						v= null;
						return false;
					}

					@Override
					public String next() {
						if ( !hasNext() ) throw new NoSuchElementException(" ... ");
						String res = v; 
						v= null;
						return res;
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException(" ... ");
					}				
						
				};
			}
			
		};
	}
}
