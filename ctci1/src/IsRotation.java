/**
 * Created by griffin on 12/15/17.
 */
public class IsRotation {
    public boolean isRotation(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;

        char firstCharacterInS1 = s1.charAt(0);
        int locationOfFirstCharacterInS2 = s2.indexOf(firstCharacterInS1);

        int i = locationOfFirstCharacterInS2, j = 0;
        while(i < s2.length() && j < locationOfFirstCharacterInS2) {
            if(s2.charAt(i) != s1.charAt(j))
                return false;

            i++;
            j++;
        }

        String s2Substring = s2.substring(0, locationOfFirstCharacterInS2 - 1);

        return s1.contains(s2Substring);
    }
}