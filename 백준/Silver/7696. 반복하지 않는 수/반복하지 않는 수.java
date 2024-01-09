import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int[] ans = new int[30000001];
        int[] arr = new int[1000001];

        int i = 0;
        for (; i < 10; i++) {
            ans[i] = 1<<i;
            arr[i] = i;
        }
        int idx = 10;

        while (true){
            if (ans[i/10] == 0){
                i++;
                continue;
            }
            if ((ans[i/10] & ans[i%10]) == 0){
                ans[i] = ans[i/10] | ans[i%10];
                arr[idx] = i;
                idx++;
            }
            i++;
            if (idx > 1000000) break;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            int n = Integer.parseInt(br.readLine());
            if (n==0) break;

            sb.append(arr[n]).append("\n");
        }
        System.out.println(sb);
    }
}