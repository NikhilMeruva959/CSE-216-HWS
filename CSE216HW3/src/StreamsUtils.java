import java.util.*;
import java.util.stream.Collectors;


public class StreamsUtils {
    /**
     * @param strings: the input collection of <code>String</code>s.
     * @return a collection of those <code>String</code>s in the input collection that start with a capital letter.
     */

    public static Collection<String> capitalized(Collection<String> strings) {
        return strings.stream().filter(str -> Character.isUpperCase(str.charAt(0))).collect(Collectors.toList());
    }

    /**
     * Find and return the longest <code>String</code> in a given collection of <code>String</code>s.
     *
     * @param strings:    the given collection of <code>String</code>s.
     * @param from_start: a <code>boolean</code> flag that decides how ties are broken.
     *                    If <code>true</code>, then the element encountered earlier in
     *                    the iteration is returned, otherwise the later element is returned.
     * @return the longest <code>String</code> in the given collection,
     * where ties are broken based on <code>from_start</code>.
     */
    public static String longest(Collection<String> strings, boolean from_start) {
        return (from_start) ? strings.stream().max(Comparator.comparing((String str) -> str.length())).get() :
                //strings.stream().max(Comparator.comparing((String str) -> str.length()).thenComparing(String::indexOf)).get();
                strings.stream().max(Comparator.comparing((String str) -> str.length()).thenComparing((String str) -> Arrays.asList(strings.toArray(new String[strings.size()])).indexOf(str))).get();
    }

    /**
     * Find and return the least element from a collection of given elements that are comparable.
     *
     * @param items:      the given collection of elements
     * @param from_start: a <code>boolean</code> flag that decides how ties are broken.
     *                    If <code>true</code>, the element encountered earlier in the
     *                    iteration is returned, otherwise the later element is returned.
     * @param <T>:        the type parameter of the collection (i.e., the items are all of type T).
     * @return the least element in <code>items</code>, where ties are
     * broken based on <code>from_start</code>.
     */
    public static <T extends Comparable<T>> T least(Collection<T> items, boolean from_start) {
        return from_start ? items.stream().min(Comparator.comparing((T x) -> x)).get() :
                items.stream().min(Comparator.comparing((T x) -> x).thenComparing((T x) -> Arrays.asList(items.toArray()).indexOf(x))).get();

    }

    /**
     * Flattens a map to a stream of <code>String</code>s, where each element in the list
     * is formatted as "key -> value" (i.e., each key-value pair is converted to a string
     * with this format).
     *
     * @param aMap the specified input map.
     * @param <K>  the type parameter of keys in <code>aMap</code>.
     * @param <V>  the type parameter of values in <code>aMap</code>.
     * @return the flattened list representation of <code>aMap</code>.
     */
    public static <K, V> List<String> flatten(Map<K, V> aMap) {
        return aMap.keySet().stream().map(key -> key + " -> " + aMap.get(key)).collect(Collectors.toList());
    }

    public static void main(String[] args) {
//        List<String> str = new ArrayList<String>();
//        str.add("a");
//        str.add("aa");
//        str.add("aaa");
//        str.add("bbb");
//        str.add("ccc");
//        str.add("dd");
//        str.add("e");
//
//        System.out.println(longest(str, false));
//
//        List<Integer> y = new ArrayList<Integer>();
//        y.add(12);
//        y.add(23765);
//        y.add(8);
//        y.add(19861);
//        y.add(970);
//        y.add(19091091);
//        y.add(8);

        //str.add("blueberry");
        //System.out.println(capitalized(str));
//        System.out.println(least(y, false));

//        System.out.println();
//        HashMap<Integer, String> hm = new HashMap<Integer, String>();
//        hm.put(1, "Ram");
//        hm.put(2, "Shyam");
//        hm.put(3, "Sita");

//        System.out.println((flatten(hm)));
//        System.out.println();
//        System.out.println((flatten(hm)).get(0));
//        System.out.println();
//        System.out.println((flatten(hm)).get(0).substring(1, 2));
//        System.out.println();
//        System.out.println((flatten(hm)).get(0).substring(3, 4));
//        System.out.println();
//        System.out.println((flatten(hm)).get(0).length());
    }

}
