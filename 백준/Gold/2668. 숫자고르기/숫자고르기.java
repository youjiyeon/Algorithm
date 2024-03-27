import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static int[] arr;
    public static boolean[] v;
    public static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        v = new boolean[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        for (int i = 1; i <= n; i++) {
            v[i] = true;
            dfs(i, i);
            v[i] = false;
        }

        System.out.println(list.size());
        Collections.sort(list);
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }

    public static void dfs(int node, int target) {
        if (!v[arr[node]]) {
            v[arr[node]] = true;
            dfs(arr[node], target);
            v[arr[node]] = false;
        }

        if (target==arr[node]) {
            list.add(node);
        }

    }
}