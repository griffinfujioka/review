/**
 * Created by griffin on 12/8/17.
 */
public class ReplaceSpacesInCharacterArray {

    public char[] replaceSpaces(char[] s, int length) {
        int spaceCount = 0, newLength, i;

        for(i = 0; i < length; i++) {
            if(s[i] == ' ')
                spaceCount++;
        }

        newLength = length + spaceCount * 2;
        for(i = length - 1; i >= 0; i--) {
            if(s[i] == ' ') {
                s[newLength - 1] = '0';
                s[newLength - 2] = '2';
                s[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                s[newLength - 1] = s[i];
                newLength = newLength - 1;
            }
        }

        return s;
    }

}
