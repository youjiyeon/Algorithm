import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;

public class BJ_16472_Main_투포인터 {
    public static int cnt, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        cnt = Integer.parseInt(br.readLine());
        String str = br.readLine();

        result = Integer.MIN_VALUE;
        int[] check = new int[26]; // 알파벳 유무 확인
        int left = 0;
        int right = 0;
        int length = 0;

        check[str.charAt(0)-'a']++;
        length++;
        while (true){
            right++;
            if(right==str.length()) break;

            check[str.charAt(right)-'a']++;

            if(check[str.charAt(right)-'a'] == 1){
                length++;
            }

            while (length>cnt){
                check[str.charAt(left)-'a']--;

                if(check[str.charAt(left)-'a'] == 0){
                    length--;
                }
                left++;
            }

            result = Math.max(result, right-left+1);
        }
        
        System.out.println(result);
    }
}
