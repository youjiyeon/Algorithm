import java.io.*;
import java.util.*;

public class Main {
    public static int val, n = 10, min = Integer.MAX_VALUE;
    public static int[] mushroom = new int[n];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < n; i++) {
            mushroom[i] = Integer.parseInt(br.readLine());
        }

        // 부분집합
        power(0, 0, false);

        System.out.println(val);
    }
    public static void power(int cnt, int sum, boolean flag){

        if (cnt!=0 && flag){
            if (min>Math.abs(sum-100)){
                min = Math.abs(sum-100);
                val = sum;
            }
            return;
        }

        if (cnt==n){
            if (min>Math.abs(sum-100)){
                min = Math.abs(sum-100);
                val = sum;
            }
            return;
        }

        power(cnt+1, sum+mushroom[cnt], false);
        power(cnt+1, sum, true);
    }
}