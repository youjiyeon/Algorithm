import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int result = 0;
    public static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        result = str.length();

        for (int i = 0; i < str.length(); i++) {
            if (isPalindrome(str.substring(i))){
                break;
            }
            result++;
        }

        System.out.println(result);
    }

    public static boolean isPalindrome(String diff) {
        int s = 0;
        int e = diff.length()-1;
        while (s <= e) {
            if (diff.charAt(s++) != diff.charAt(e--)) {
                return false;
            }
        }
        return true;
    }
}