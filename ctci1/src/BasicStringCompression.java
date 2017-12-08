/**
 * Created by griffin on 12/8/17.
 */
public class BasicStringCompression {
    public String compress(String s) {
        char[] sArray = s.toCharArray();
        StringBuilder compressedStringBuilder = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            int characterCounter = 0;
            int c = sArray[i];
            for(int j = i; j < s.length(); j++) {
                if(sArray[j] != c)
                    break;

                characterCounter++;
            }

            i += characterCounter - 1;
            compressedStringBuilder.append(String.format("%c%d", c, characterCounter));
        }

        return compressedStringBuilder.toString().length() > s.length() ? s : compressedStringBuilder.toString();
    }
}
