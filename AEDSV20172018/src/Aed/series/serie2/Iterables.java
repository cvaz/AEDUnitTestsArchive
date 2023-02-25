package Aed.series.serie2;

import java.util.Collections;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Iterables {
	
	public static <T> Iterable<T> flatten( final Iterable< Iterable<T> > src) {
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

	public static  Iterable<Integer> alternateEvenOdd(final Iterable<Integer> src){
		/*throw new UnsupportedOperationException();*/

		return new Iterable<Integer>() {
			@Override
			public Iterator<Integer> iterator() {
				return new Iterator<Integer>() {
					Iterator<Integer> it = src.iterator();
					Integer value;
					boolean odd = true;

					@Override
					public boolean hasNext() {
						while (value == null) {
							if (it.hasNext()) {
								value = it.next();
								if(odd)
									if (value%2==0) value = null;
									else odd = !odd;
								else
									if (value%2!=0) value = null;
									else odd = !odd;
							}
							else return false;
						}
						return true;
					}

					@Override
					public Integer next() {
						if (!hasNext()) throw new NoSuchElementException("alternateEvenoOdd: no more elements");
						Integer result = value;
						value= null;
						return result;
					}

					@Override
					public void remove() {
						throw new UnsupportedOperationException("alternateEvenoOdd: remove not supported");
					}
				};
			}
		};
	}



}
