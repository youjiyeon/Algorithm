import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int days;
        int money;
        public Node(int days, int money) {
            this.days = days;
            this.money = money;
        }
    }
    static int n, res = 0;
    static Node[] node;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        node = new Node[n+1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int days = Integer.parseInt(st.nextToken());
            int money = Integer.parseInt(st.nextToken());

            node[i] = new Node(days, money);
        }

        back(1, 0);
        System.out.println(res);
    }

    static void back(int d, int sum) {
        if (d > n+1) return;
        if (d == n+1) {
            res = Math.max(res, sum);
            return;
        }

        back(d+node[d].days, sum+node[d].money);
        back(d+1, sum);
    }
}