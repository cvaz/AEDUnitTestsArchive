package serie2;

import java.util.Comparator;

public class Utils {

	
	public static boolean verifyPairing(String s){
		String open = "{[(";
		String close = "}])";
		char[]	stack= new char[ s.length() ];
		int sp = 0, indexOfPair;
		char c;
		for (int i= 0; i < s.length(); ++i ) {
			c = s.charAt( i );
			if ( ( indexOfPair = close.indexOf( c) ) != -1 ) {
				if ( sp == 0 || c != stack[--sp] ) 
					return false;
			}
			else if ( ( indexOfPair = open.indexOf(c) ) != -1 )
				stack[ sp++ ] = close.charAt( indexOfPair );
		}
		return sp == 0;
	}
	
	public static <E> boolean containsAll(HashNode<E>[] hashTable1, HashNode<E>[] hashTable2, Comparator<E> cmp){
		throw new UnsupportedOperationException();
	}
	
}
