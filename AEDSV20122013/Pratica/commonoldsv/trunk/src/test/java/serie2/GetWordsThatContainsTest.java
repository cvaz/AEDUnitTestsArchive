package serie2;

import org.junit.Test;

import static serie2.Iterables.getWordsThatContains;
import java.util.*;

public class GetWordsThatContainsTest extends IterablesTest {
	static Iterable<String> se = Collections.<String>emptyList();
	
	@Test 
	public void getWordsThatContains_OnEmptySequence(){
		// None sequences
		Collection< Iterable<String>> seq = new ArrayList< Iterable<String> >();
		assertIterableEmpty( getWordsThatContains( seq, "AED" ) );	
		// Four sequences empty
		for ( int i= 0; i < 4; ++ i )
			seq.add( se );
		assertIterableEmpty( getWordsThatContains( seq, "AED" ) );	
	}

	@Test 
	public void getWordsThatContains_OnSequenceOfOneElementSequence(){
		List< Iterable< String >> seq = new ArrayList< Iterable<String>>();
		
		// One sequence of one element which does not contain the word
		seq.add( Collections.singleton( "Teste" ) );
		assertIterableEmpty( getWordsThatContains( seq, "AED" ) );	

		// One sequence of one element containing the word
		Collection<String> s = singleton( "Teste de AED" );
		seq.set( 0, s );
		assertIterableEquals( s, getWordsThatContains(seq, "AED") );
	}

	static Iterable<String> PG_POO_AED = unmodifiable( Arrays.asList("PG", "POO", "AED" ) ),
                            aPG = unmodifiable( Arrays.asList("Avaliação de PG", "minitestes", "exame" ) ),
                            aPOO = unmodifiable( Arrays.asList("Avaliação de POO", "trabalhos", "2 testes", "ou exame" ) ),
                            aAED = unmodifiable( Arrays.asList("Avaliação de AED", "3 series", "3 fichas", " exame" ) ),
                            sAED = unmodifiable( Arrays.asList("1ª Serie de AED", "2ª Serie de AED", "3ª Serie de AED" ) );
	@Test 
	public void getWordsThatContains_onSequencesWhichNotContaining(){
		List< Iterable< String > > seq = new ArrayList< Iterable<String>>();
		// One sequence of sequences empty and not empty which does not contain the word
		//   seq ={ se, aPG, se, aPOO, se };
		for ( int i= 0; i < 3; ++i ) 
			seq.add( se);
		seq.add(1, aPG);
		seq.add(3, aPOO);
		assertIterableEmpty( getWordsThatContains( seq, "AED" ) );	
	}
	
	@Test 
	public void getWordsThatContains_onSequencesThatContains(){
		List< Iterable< String >> seq = new ArrayList< Iterable<String>>();
		List< String > expected =  Arrays.asList("AED",  "Avaliação de AED" );
		// First and last sequence containing the word
		//   seq ={ PG_POO_AED, aPG, aPOO, aAED };
		seq.add(PG_POO_AED); seq.add(aPG); seq.add(aPOO); seq.add( aAED ); 
		assertIterableEquals( expected, getWordsThatContains( seq, "AED" ) );
		
		// First element of the first sequence and last element of last sequence containing the word
		//   seq ={ aAED, aPOO, aPG, PG_POO_AED };
		Collections.reverse( seq );
		Collections.reverse( expected );
		assertIterableEquals( expected, getWordsThatContains( seq, "AED" ) );
		
		// All elements of the middle sequence containing the word
		//   seq ={ aPOO, se, se, sAED, aPG, se, se};
		seq = new ArrayList< Iterable<String>>();
		for ( int i= 0; i < 5; ++i ) 
			seq.add( se );
		seq.add( 0, aPOO); seq.add( 3, sAED); seq.add( 4, aPG);
		assertIterableEquals( sAED,  getWordsThatContains(seq, "AED") );
	}

}
