import java.util.LinkedHashMap;
import java.util.Map;
import java.util.HashMap;

/**
 * Даны 2 строки, написать метод, который вернет true, если эти строки являются изоморфными и false, если нет. Строки изоморфны, если одну букву в первом слове можно заменить на некоторую букву во втором слове, при этом
 * повторяющиеся буквы одного слова меняются на одну и ту же букву с сохранением порядка следования. (Например, add - egg изоморфны)
 * буква может не меняться, а остаться такой же. (Например, note - code)
 */

public class Task01 {

    public static void main(String[] args) {
        System.out.println(isIsamorf_2("abba", "baab"));

    }

    public static boolean isIsamorf(String a, String b) {
        Map<Character, Character> pair = new LinkedHashMap<>();
        if(a.length() != b.length()) return false;
        else {
            for (int i = 0; i < a.length(); i++) {
                if(pair.containsKey(a.charAt(i))) {
                    if(pair.get(a.charAt(i)) != b.charAt(i)) return false;
                }
                else pair.put((a.charAt(i)), b.charAt(i));
                }
            }
        return true;
        }

    public static boolean isIsamorf_2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> usedValues = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            } else {
                if (usedValues.containsKey(c2)) {
                    return false;
                }
                map.put(c1, c2);
                usedValues.put(c2, c1);
            }
        }

        return true;

    }


}

