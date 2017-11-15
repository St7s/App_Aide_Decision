package tools;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Tri {

	public static HashMap sortByValues(Map<Integer, Integer> map) {
		List<Object> list = new LinkedList<Object>(map.entrySet());
		// Defined Custom Comparator here
		Collections.sort(list, new Comparator<Object>() {
			public int compare(Object o1, Object o2) {
				return ((Comparable) ((Entry) (o2)).getValue()).compareTo(((Entry) (o1)).getValue());
			}
		});

		HashMap<Integer, Integer> sortedHashMap = new LinkedHashMap<>();
		Entry entry = null;
		for (Iterator it = list.iterator(); it.hasNext();) {
			entry = (Entry) it.next();
			sortedHashMap.put((Integer) entry.getKey(), (Integer) entry.getValue());
		}
		return sortedHashMap;
	}

}
