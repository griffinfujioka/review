import java.util.HashMap;
import java.util.Map;

/**
 * Created by griffin on 12/8/17.
 */
public class AreTwoStringsPermutations {
    public boolean arePermutations(String firstString, String secondString) {
        if(firstString.length() != secondString.length())
            return false;

        Map<Character, Integer> firstStringMap = new HashMap<>();

        for(char c : firstString.toCharArray()) {
            if(firstStringMap.containsKey(c))
                firstStringMap.put(c, firstStringMap.get(c) + 1);
            else
                firstStringMap.put(c, 1);
        }

        for(char c : secondString.toCharArray()) {
            if(firstStringMap.containsKey(c))
                firstStringMap.put(c, firstStringMap.get(c) - 1);
            else
                return false;
        }

        for(char c : firstStringMap.keySet()) {
            if(firstStringMap.get(c) != 0)
                return false;
        }

        return true;
    }
}
