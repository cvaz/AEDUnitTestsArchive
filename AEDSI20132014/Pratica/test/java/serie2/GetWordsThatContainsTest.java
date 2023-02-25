package serie2;

import org.junit.Test;

import static serie2.Iterables.getWordsThatContains;

import java.util.*;

public class GetWordsThatContainsTest extends IterablesTest {
	static Iterable<String> empty = Collections.<String> emptyList();

	@Test
	public void getWordsThatContains_onEmptySequence() {
		// None sequences
		Collection<Iterable<String>> seq = new ArrayList<Iterable<String>>();
		assertIterableEmpty(getWordsThatContains(seq, "ori"));
		// Four sequences empty
		for (int i = 0; i < 4; ++i)
			seq.add(empty);
		assertIterableEmpty(getWordsThatContains(seq, "ori"));
	}

	@Test
	public void getWordsThatContains_onSequenceOfOneElementSequence() {
		List<Iterable<String>> seq = new ArrayList<Iterable<String>>();

		// One sequence of one element which does not contain the word
		seq.add(Collections.singleton("originou"));
		assertIterableEmpty(getWordsThatContains(seq, "des"));

		// One sequence of one element containing the word
		Collection<String> s = singleton("desoriginou");
		seq.set(0, s);
		assertIterableEquals(s, getWordsThatContains(seq, "des"));
	}

	static Iterable<String> aRatoOriginalTigre = unmodifiable(Arrays.asList(
			"rato", "original", "tigre")),
			aRato = unmodifiable(Arrays.asList("o", "rato", "roeu", "a",
					"rolha", "da", "garrafa", "do", "rei", "da", "russia")),
			aOriginal = unmodifiable(Arrays.asList("o", "original", "nunca",
					"se", "desoriginou", "nem", "nunca", "se",
					"desoriginalizara")),
			aTigre = unmodifiable(Arrays.asList("tres", "pratos", "de",
					"trigo", "para", "tres", "tristes", "tigres")),
			aMassa = unmodifiable(Arrays.asList("massa", "massinha", "massada"));

	@Test
	public void getWordsThatContains_onSequencesWhichNotContains() {
		List<Iterable<String>> seq = new ArrayList<Iterable<String>>();
		// One sequence of sequences empty and not empty which does not contain
		// the substr
		// seq ={ empty, aRato, empty, aTigre, empty };
		for (int i = 0; i < 3; ++i)
			seq.add(empty);
		seq.add(1, aRato);
		seq.add(3, aTigre);
		assertIterableEmpty(getWordsThatContains(seq, "original"));
	}

	@Test
	public void getWordsThatContains_onSequencesThatContains() {
		List<Iterable<String>> seq = new ArrayList<Iterable<String>>();
		List<String> expected = Arrays.asList("tigre", "tigres");
		// First and last sequence containing the substr
		// seq ={ aRatoOriginalTigre, aRato, aOriginal, aTigre };
		seq.add(aRatoOriginalTigre);
		seq.add(aRato);
		seq.add(aOriginal);
		seq.add(aTigre);
		assertIterableEquals(expected, getWordsThatContains(seq, "tigre"));

		// All elements of the last sequence containing the substr
		// seq ={ aRato, empty, empty, aOriginal, aTigre, empty, aMassa, empty,
		// empty};
		seq = new ArrayList<Iterable<String>>();
		for (int i = 0; i < 5; ++i)
			seq.add(empty);
		seq.add(0, aRato);
		seq.add(3, aOriginal);
		seq.add(4, aTigre);
		seq.add(6, aMassa);
		assertIterableEquals(aMassa, getWordsThatContains(seq, "mass"));
	}

	@Test
	public void getWordsThatContains_onSeveralSequencesThatContains() {
		List<Iterable<String>> seq = new ArrayList<Iterable<String>>();
		List<String> expected = Arrays.asList("rato", "roeu", "rolha",
				"garrafa", "rei", "russia", "original", "desoriginou",
				"desoriginalizara", "tres", "pratos", "trigo", "para", "tres",
				"tristes", "tigres");

		// Several sequences containing the word
		// seq ={ aRato , aOriginal, aTigre};
		seq.add(aRato);
		seq.add(aOriginal);
		seq.add(aTigre);
		assertIterableEquals(expected, getWordsThatContains(seq, "r"));
	}
}
