package it.intersistemi.corsojava.generics.esempi;

public class ComparableMultiChiave<K1 extends Comparable<K1>, K2 extends Comparable<K2>, K3 extends Comparable<K3>>
		extends MultiChiave<K1, K2, K3> implements Comparable<ComparableMultiChiave<K1, K2, K3>> // anche le singole
																									// chiavi devono
																									// essere Comparable
																									// per poter
																									// implementare il
																									// compareTo

{

	// private static Comparable keyOther;
	// private static Comparable keyThis;

	public ComparableMultiChiave(K1 key1, K2 key2, K3 key3) {
		super(key1, key2, key3);

	}

	@Override
	public int compareTo(ComparableMultiChiave<K1, K2, K3> other) {

		int compare = super.getKey1().compareTo(other.getKey1());
		if (compare == 0) {
			compare = internalKeyCompare(super.getKey2(), other.getKey2());
			if (compare == 0) {
				return internalKeyCompare(super.getKey3(), other.getKey3());

			}
		}

		return compare;
	}

	private static <T extends Comparable<T>> int internalKeyCompare(T keyThis, T keyOther) {
		if (keyThis != null && keyOther != null) {
			return keyThis.compareTo(keyOther);
		} else if (keyThis == null && keyOther == null) {
			return 0;
		} else if (keyThis == null) {
			return -1;
		} else {
			return 1;
		}

	}

	public static void main(String[] args) {

		ComparableMultiChiave<Integer, String, String> primo = new ComparableMultiChiave<Integer, String, String>(1,
				null, null);
		ComparableMultiChiave<Integer, String, String> secondo = new ComparableMultiChiave<Integer, String, String>(1,
				null, "home");

		System.out.println(primo.compareTo(secondo));

	}
}
