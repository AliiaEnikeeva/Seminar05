import java.util.HashMap;
import java.util.Map;

public class Task0 {

    private static final Map<Integer, String> passportToName = new HashMap<>();
    public static void main(String[] args) {

        passportToName.put(123456,"Иванов");
        passportToName.put(321456,"Васильев");
        passportToName.put(234432, "Иванов");
        passportToName.put(654321, "Петрова");
        passportToName.put(345678, "Иванов");

        System.out.println(passportToName);

        for(Map.Entry<Integer, String> entry : passportToName.entrySet())
            if (entry.getValue().equals("Иванов")) {
                System.out.println(entry);
            }
    }

}
