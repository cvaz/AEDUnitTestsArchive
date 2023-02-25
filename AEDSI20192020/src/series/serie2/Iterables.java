package series.serie2;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class Iterables {


    public static Iterable<Pair<String, Integer>> groupingEquals(Iterable<String> words) {
        return new Iterable<Pair<String,Integer>>() {
            public Iterator<Pair<String,Integer>> iterator() {
                return new Iterator<Pair<String,Integer>>() {
                    Iterator<String> iterator = words.iterator();
                    Pair<String, Integer> pair = null;
                     String currentString = null;
                     String nextString = null;

                    public boolean hasNext(){
                        if (pair != null) return true;
                        if (!iterator.hasNext() && currentString == null) return false;
                        if (currentString == null) {
                            currentString = iterator.next();
                            nextString = currentString;
                        }
                        pair = new Pair<String, Integer>(currentString, 1);
                        while (iterator.hasNext() && currentString.equals(nextString = iterator.next())) {
                            pair.second++;
                        }
                        if (!iterator.hasNext() && currentString.equals(nextString))
                            currentString = null;
                        else {
                            currentString = nextString;
                            nextString = null;
                        }
                        return true;
                    }

                    @Override
                    public Pair<String, Integer> next() {
                        if (!hasNext()) throw new NoSuchElementException();
                        Pair<String, Integer> aux = pair;
                        pair = null;
                        return aux;
                    }

                    ;
                };
            }
        };
   }


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
}



