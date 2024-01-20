import java.io.*;
import java.util.*;

public class Solution {
    public static class Node{
        int data;
        int parent, left, right;

        public Node(int data){
            this.data = data;
            this.parent = 0;
            this.left = 0;
            this.right = 0;
        }
    }
    public static int V, size;
    public static Node[] nodes;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int t = 1;
        while (t<=T) {
            // 테스트 케이스마다 초기 출력 형식
            sb.append("#").append(t).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            size = 0;
            visit = new boolean[V+1];
            nodes = new Node[V+1];
            for (int i = 1; i <= V; i++) {
                nodes[i] = new Node(i);
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < E; i++) {
                int parent = Integer.parseInt(st.nextToken());
                int child = Integer.parseInt(st.nextToken());

                if (nodes[parent].left==0) nodes[parent].left = child;
                else nodes[parent].right = child;
                nodes[child].parent = parent;
            }

            int common = 1;
            while (true){
                if (a!=1){
                    int p = nodes[a].parent;
                    if (visit[p]){
                        common = p;
                        break;
                    }
                    visit[p] = true;
                    a = p;
                }

                if (b!=1){
                    int p = nodes[b].parent;
                    if (visit[p]){
                        common = p;
                        break;
                    }
                    visit[p] = true;
                    b = p;
                }
            }

            cal(nodes[common]);
            sb.append(common).append(" ").append(size).append("\n");
            t++;
        }
        System.out.println(sb);
    }

    private static void cal(Node node) {
        size++;
        if (node.left != 0) cal(nodes[node.left]);
        if (node.right != 0) cal(nodes[node.right]);
    }
}