import java.io.*;
import java.util.*;

class Main {
    static int[][] arr;
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();

        arr = new int[27][200002];
        for (int i = 0; i < s.length(); i++) {
            if (i!=0) {
                for (int j = 0; j < 26; j++) {
                    arr[j][i] += arr[j][i-1];
                }
            }
            char a = s.charAt(i);
            arr[a-'a'][i]++;
        }

        int q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if (start==0) {
                sb.append(arr[c-'a'][end]).append("\n");
            }
            else {
                sb.append(arr[c - 'a'][end] - arr[c - 'a'][start - 1]).append("\n");
            }
        }
        System.out.print(sb);
    }
}