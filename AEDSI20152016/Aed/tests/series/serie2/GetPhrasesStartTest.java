package series.serie2;

import org.junit.Test;

import static series.serie2.Iterables.getPhrasesStart;

import java.util.*;

public class GetPhrasesStartTest extends IterablesTest {
    static Iterable<String> empty = Collections.<String>emptyList();

    static Iterable<String> aRato = unmodifiable(Arrays.asList("o", "rato", "roeu", "a",
            "rolha", "da", "garrafa", "do", "rei", "da", "russia")),
            aRio = unmodifiable(Arrays.asList("fui", "ao", "mar", "colher",
                    "cordões", "vim", "do", "mar", "cordões", "colhi")),
            aOriginal = unmodifiable(Arrays.asList("o", "original", "nunca",
                    "se", "desoriginou", "nem", "nunca", "se",
                    "desoriginalizara")),
            aTigre = unmodifiable(Arrays.asList("três", "pratos", "de",
                    "trigo", "para", "três", "tristes", "tigres")),
            aMassa = unmodifiable(Arrays.asList("o", "mação", "amassou", "a", "massa", "com", "o", "maçarico"));

    static String strRato = "o rato roeu a rolha da garrafa do rei da russia",
            strRio = "fui ao mar colher cordões vim do mar cordões colhi",
            strOriginal = "o original nunca se desoriginou nem nunca se desoriginalizara",
            strTigre = "três pratos de trigo para três tristes tigres",
            strMassa = "o mação amassou a massa com o maçarico";

    @Test
    public void getPhrasesStart_onEmptySequence() {
        // None sequences
        Collection<Iterable<String>> seq = new ArrayList<Iterable<String>>();
        assertIterableEmpty(getPhrasesStart(seq, "pri"));
        // Four sequences empty
        for (int i = 0; i < 4; ++i)
            seq.add(empty);
        assertIterableEmpty(getPhrasesStart(seq, "pri"));
    }

    @Test
    public void getPhrasesStart_onSequenceOfOneElementSequence() {
        List<Iterable<String>> seq = new ArrayList<Iterable<String>>();
        List<String> expected = Arrays.asList(strRio);

        // One sequence of one element which does not contain the prefix
        seq.add(aRio);
        assertIterableEmpty(getPhrasesStart(seq, "rio"));

        // One sequence of one element containing the prefix
        assertIterableEquals(expected, getPhrasesStart(seq, "fui"));
    }

    @Test
    public void getPhrasesStart_onSequencesWhichNotStarts() {
        List<Iterable<String>> seq = new ArrayList<Iterable<String>>();
        // One sequence of sequences empty and not empty which does not start with the prefix
        // seq ={ empty, aRato, empty, aTigre, empty };
        for (int i = 0; i < 3; ++i)
            seq.add(empty);
        seq.add(1, aRato);
        seq.add(3, aTigre);
        assertIterableEmpty(getPhrasesStart(seq, "original"));
    }

    @Test
    public void getPhrasesStart_onSequencesThatStarts() {
        List<Iterable<String>> seq = new ArrayList<Iterable<String>>();
        List<String> expected = Arrays.asList(strRato, strOriginal);
        // First and last sequence containing the prefix
        // seq ={ aRato, aRio, aTigre, aOriginal};
        seq.add(aRato);
        seq.add(aRio);
        seq.add(aTigre);
        seq.add(aOriginal);
        assertIterableEquals(expected, getPhrasesStart(seq, "o"));

        // First sequence containing the prefix
        // seq ={ aTigre, empty, empty, aRio, aRato, empty, aOriginal, empty,
        // empty};
        seq = new ArrayList<Iterable<String>>();
        expected = Arrays.asList(strTigre);
        for (int i = 0; i < 5; ++i)
            seq.add(empty);
        seq.add(0, aTigre);
        seq.add(3, aRio);
        seq.add(4, aRato);
        seq.add(6, aOriginal);
        assertIterableEquals(expected, getPhrasesStart(seq, "três"));
    }

    @Test
    public void getPhrasesStart_onSeveralSequencesThatStarts() {
        List<Iterable<String>> seq = new ArrayList<Iterable<String>>();
        List<String> expected = Arrays.asList(strRato, strOriginal, strMassa);

        // Several sequences starting with the prefix
        // seq ={ aRato , aOriginal, aTigre};
        seq.add(aRato);
        seq.add(aRio);
        seq.add(aOriginal);
        seq.add(aTigre);
        seq.add(aMassa);
        assertIterableEquals(expected, getPhrasesStart(seq, "o"));
    }
}