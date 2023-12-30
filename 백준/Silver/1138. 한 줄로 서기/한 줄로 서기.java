import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] order, ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        ans = new int[n];
        order = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            order[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= n; i++) {
            int o = order[i];
            for (int j = 0; j < n; j++) {
                if (o==0){
                    if (ans[j]!=0){
                        while (true){
                            j++;
                            if (ans[j]==0){
                                break;
                            }
                        }
                    }
                    ans[j] = i;
                    break;
                }
                if (ans[j]==0 || ans[j]>i){
                    o--;
                }
            }
        }

        for (int i:ans) {
            System.out.print(i+" ");
        }
    }
}