import java.io.*;
import java.util.*;

public class Solution {
    public static int n, cnt;
    public static int[] rank, parent;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            rank = new int[n+1];
            parent = new int[n+1];
            // 부모를 자기 자신으로 초기화
            // rank 1로 초기화
            for (int i = 1; i <= n; i++) {
                rank[i] = 1;
                parent[i] = i;
            }
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                Union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            // 그룹 몇개인지 찾기 parent가 자기자신이면 ++
            cnt = 0;
            for (int i = 1; i <= n; i++) {
                if (parent[i]==i)
                    cnt++;
            }
            
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }

    public static int Find(int x){
        if (parent[x]==x) return x;
        return parent[x]=Find(parent[x]);
    }

    public static void Union(int a, int b){
        int A = Find(a);
        int B = Find(b);

        if (A==B)
            return;
        if (rank[A]<rank[B]){
            parent[A]=B;
        }
        else if (rank[A]>rank[B]){
            parent[B]=A;
        }
        else {
            parent[B]=A;
            rank[A]++;
        }
    }
}