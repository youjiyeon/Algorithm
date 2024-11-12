import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int new_score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        if (n==0) {
            System.out.println(1);
            System.exit(0);
        }

        int[] score = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        if (n==p && new_score<=score[n-1]) {
            System.out.println(-1);
        }
        else {
            int rank = 1;
            for (int i = 0; i < n; i++) {
                if (new_score<score[i]) rank++;
                else break;
            }

            System.out.println(rank);
        }
    }
}