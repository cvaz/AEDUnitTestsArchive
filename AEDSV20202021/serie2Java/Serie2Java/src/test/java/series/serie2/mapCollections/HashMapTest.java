package series.serie2.mapCollections;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;

import static java.util.Comparator.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class HashMapTest {
    @Test
    public void hashMap_empty() {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        assertEquals(0, map.getSize());
    }

    @Test
    public void hashMap_singleton() {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "aed");
        assertEquals(1, map.getSize());
        assertEquals("aed", map.get(1));
        assertEquals(null, map.get(2));
        assertEquals(1, map.iterator().next().getKey());
        assertEquals("aed", map.iterator().next().getValue());
        map.remove(2);
        assertEquals(1, map.getSize());
        map.remove(1);
        assertEquals(0, map.getSize());
    }

    @Test
    public void hashMap_equalElements() {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "aed");
        map.put(1, "aed");
        assertEquals("aed", map.get(1));
        map.put(1, "xpto");
        map.put(1, "xpto");
        assertEquals(1, map.getSize());
        assertEquals("xpto", map.get(1));
        assertEquals(null, map.get(2));
    }

    @Test
    public void hashMap_someElements() {
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        for (int i = 0; i < 100; i++) {
            map.put(i, "" + i);
        }
        assertEquals(100, map.getSize());
        assertEquals("10", map.get(10));
        Iterator<MutableMap.MutableEntry<Integer, String>> it = map.iterator();
        ArrayList<Integer> list = new ArrayList<>();
        while (it.hasNext()) {
            list.add(it.next().getKey());
        }
        list.sort(naturalOrder());
        for (int i = 0; i < 100; i++) {
            assertEquals(i, list.get(i));
        }

        for (int i = 0; i <= 100; i++) {
            map.remove(2 * i + 1);
        }
        it = map.iterator();
        list = new ArrayList<>();
        while (it.hasNext()) {
            list.add(it.next().getKey());
        }
        list.sort(naturalOrder());
        for (int i = 0; i < list.size(); i++) {
            assertEquals(2 * i, list.get(i));
        }
    }
}





