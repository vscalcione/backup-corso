/**
 * 
 */
package it.intersistemi.corsojava.classianonime;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Spellucci
 *
 */
public class ArraySort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] stringArray = new String[] {
				"aaaa", "aaaaaaa", "bbb",
				"lll", "z", "cccc", "mmm"
		};
		Arrays.sort(stringArray, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return -1*o1.compareTo(o2);
			}
		});
		for (String string : stringArray) {
			System.out.println(string);
		}

	}

}
