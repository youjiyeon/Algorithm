import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static class Node{
        int w;
        int h;
        public Node(int w, int h){
            this.w = w;
            this.h = h;
        }
    }
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[N];
        int[] rank = new int[N];
        Arrays.fill(rank, 1);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            nodes[i] = new Node(w, h);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i==j) continue;
                if (nodes[i].w<nodes[j].w){
                    if (nodes[i].h<nodes[j].h){
                        rank[i]++;
                    }
                }
            }
        }

        for (int i: rank) {
            System.out.print(i+" ");
        }
    }
}