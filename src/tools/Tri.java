package tools;

import java.util.Map;
import java.util.TreeMap;

import modelisation.ValueComparator;

public class Tri {
	//TODO ADRIEN trier tab[] pour faire un classement
	
	public static Map sortMapByValue(Map unsortedMap) {
		Map sortedMap = new TreeMap(new ValueComparator(unsortedMap));
		sortedMap.putAll(unsortedMap);
		return sortedMap;
	}
 
}
