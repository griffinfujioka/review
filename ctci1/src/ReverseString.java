/**
 * Created by griffin on 12/5/17.
 */
public class ReverseString {
    public char[] reverse(char[] s) {
        if(s == null)
            throw new IllegalArgumentException("Input is null");

        int i = 0, j = s.length - 1;
        while(i < j) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
            i++;
            j--;
        }

        return s;
    }
}
