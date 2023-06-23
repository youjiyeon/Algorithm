import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_17609_Main {
    public static String str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            str = br.readLine();
            int left = 0;
            int right = str.length()-1;
            if(twoPoint(left, right)){
                sb.append(0+" ");
                continue;
            }
            if(sub(left, right)){
                sb.append(1+" ");
            }
            else sb.append(2+" ");
        }
        System.out.println(sb);
    }

    private static boolean twoPoint(int left, int right) {

        while (left<=right){
            if(str.charAt(left) != str.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    private static boolean sub(int left, int right) {

        while (left<=right){
            if(str.charAt(left) != str.charAt(right)){
                return (twoPoint(left+1, right) || twoPoint(left, right-1));
            }
            left++;
            right--;
        }
        return true;
    }
}
