import java.io.*;
import java.util.*;

class Main {
    static int[][] arr;
    static int[] alp = new int[26];
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        arr = new int[26][s.length()+1];
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
                System.out.println(arr[c-'a'][end]);
            }
            else {
                System.out.println(arr[c - 'a'][end] - arr[c - 'a'][start - 1]);
            }
        }
    }
}