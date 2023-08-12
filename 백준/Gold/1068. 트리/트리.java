import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, root, cnt = 0;
    public static boolean[] visit;
    public static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        parent = new int[N];
        visit = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(st.nextToken());
            if (val == -1){
                root=i;
            }

            parent[i]= val;
        }
        int remove = Integer.parseInt(br.readLine());
        deleteNode(remove);
        dfs(root);
        System.out.println(cnt);
    }

    private static void deleteNode(int remove) {
        parent[remove] = -2;
        for (int i = 0; i < N; i++) {
            if (parent[i]==remove){
                deleteNode(i);
            }
        }
    }

    private static void dfs(int v) {
        boolean isLeaf = true;
        visit[v] = true;

        if (parent[v] != -2) {
            for (int i = 0; i < N; i++) {
                if (!visit[i] && parent[i] == v) {
                    dfs(i);
                    isLeaf = false;
                }
            }
            if (isLeaf) cnt++;
        }
    }
}