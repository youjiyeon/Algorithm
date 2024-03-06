import java.io.*;
import java.util.*;

public class Main {
    public static int ans = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        List<Integer> list = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }

        choice(list, 0);
        System.out.println(ans);
    }

    public static void choice(List<Integer> list, int sum) {
        if (list.size() == 2) {
            ans = Math.max(ans, sum);
            return;
        }

        for (int i = 1; i < list.size()-1; i++) {
            int tmp = list.get(i);
            int val = list.get(i-1)* list.get(i+1);

            list.remove(i);
            choice(list, sum+val);
            list.add(i, tmp);
        }
    }
}