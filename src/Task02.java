import java.util.HashMap;
import java.util.Stack;
import java.util.Map;

public class Task02 {

    static Stack<Character> characters = new Stack<>();
    public static void main(String[] args) {
        System.out.println(isValid("{[A()[B]]}C"));

    }

    public static void fillStack(Character symbol) {
        characters.push(symbol);
    }

    public static void fillMap(Map<Character, Character> map) {
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        map.put('<', '>');
//        map = Map.of('{', '}', '<', '>', '[', ']','(', ')');
//        map = Map.ofEntries(Map.entry('{', '}'), Map.entry('(', ')'));
        System.out.println(map);
    }

    public static boolean isValid(String arg) {
        Map<Character, Character> map = new HashMap<>();
        fillMap(map);
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arg.length(); i++) {
            if (map.containsKey(arg.charAt(i))) {
                stack.push(arg.charAt(i));
            }
            if (map.containsValue(arg.charAt(i))) {
                Character key = getKey(map, arg.charAt(i));
                if (key != stack.pop()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static Character getKey(Map<Character, Character> map, Character value)
    {
        for (Map.Entry<Character, Character> entry: map.entrySet())
        {
            if (value.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }


}

//    public static void initMap(String open, String close){
//        for (int i = 0; i < open.length(); i++)
//            map.put(close.charAt(i), open.charAt(i));
//    }
//
//    public static void addChar(Character c){
//        if(isClosed(c)) if(stack.peek() == map.get(c)) stack.pop();
//        stack.push(c);
//    }
//
//    private static boolean isClosed(Character c) {
//        return map.containsKey(c);
//    }