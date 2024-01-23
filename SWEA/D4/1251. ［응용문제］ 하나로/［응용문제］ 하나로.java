import java.io.*;
import java.util.*;

public class Solution {
    public static class Node implements Comparable<Node>{
        int s;
        int e;
        long w;

        public Node(int s, int e, long w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.w, o.w);
        }
    }
    public static int n;
    public static int[] parent;
    public static int[][] map;
    public static List<Node> list;
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            n = Integer.parseInt(br.readLine());

            // 부모배열 자기자신으로 초기화
            parent = new int[n+1];
            for (int i = 1; i <= n; i++) parent[i] = i;

            map = new int[n][2];
            list = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                map[i][0] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                map[i][1] = Integer.parseInt(st.nextToken());
            }
            double E = Double.parseDouble(br.readLine());

            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    list.add(new Node(i+1, j+1, (long) (Math.pow(Math.abs(map[i][0]-map[j][0]), 2)+(long) (Math.pow(Math.abs(map[i][1]-map[j][1]), 2)))));
                }
            }

            // 거리 기준 오름차순 정렬
            Collections.sort(list);

            int size = list.size();
            int cnt = 0;
            double sum = 0;
            // 크루스칼
            for (int i = 0; i < size; i++) {
                Node cur = list.get(i);
                // 부모가 같지않다면 -> 사이클 생성X
                if(!isSame(cur.s, cur.e)){
                    union(cur.s, cur.e);
                    cnt++;
                    sum+=cur.w;
                }
                if (cnt>=n-1) break;
            }

            sb.append(Math.round(E*sum)).append("\n");
        }

        System.out.println(sb);
    }

    private static boolean all() {
        int tmp = 1;
        for (int i = 2; i <= n; i++) {
            if (!isSame(tmp, 2)) return false;
        }
        return true;
    }

    public static int find(int x){
        if (x==parent[x]) return x;
        return parent[x]=find(parent[x]);
    }

    public static void union(int x, int y){
        x = find(x);
        y = find(y);

        if(x != y){
            if(x < y) parent[y] = x;
            else parent[x] = y;
        }
    }

    public static boolean isSame(int x, int y){
        x = find(x);
        y = find(y);

        if(x==y){
            return true;
        }
        return false;
    }
}