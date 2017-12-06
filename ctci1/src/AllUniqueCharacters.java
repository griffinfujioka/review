import java.util.HashMap;
import java.util.Map;

/**
 * Created by griffin on 12/5/17.
 */
public class AllUniqueCharacters {
    
    public boolean hasAllUniqueCharacters(String s) {
        if(s.length() > 256)
            return false;

        Map<Character, Integer> map = new HashMap<>();

        for(char c: s.toCharArray()) {
            if(map.containsKey(c))
                return false;

            map.put(c, 1);
        }

        return true;
    }
}

