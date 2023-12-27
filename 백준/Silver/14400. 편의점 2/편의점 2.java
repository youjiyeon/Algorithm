import java.io.*;
import java.util.*;

public class Main {
    public static int n, x, y;
    public static int[][] customer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        customer = new int[n][2];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            customer[i][0] = Integer.parseInt(st.nextToken());
            customer[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(customer, (o1, o2)->o1[0]-o2[0]);
        if (n%2==0){
            x = customer[n/2-1][0];
        }
        else {
            x = customer[n/2][0];
        }

        Arrays.sort(customer, (o1, o2)->o1[1]-o2[1]);
        if (n%2==0){
            y = customer[n/2-1][1];
        }
        else {
            y = customer[n/2][1];
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(x-customer[i][0]) + Math.abs(y-customer[i][1]);
        }
        System.out.println(ans);
    }
}