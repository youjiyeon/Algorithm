/*
* 문제 설명?
* 각 edge도 저장하고
* list도 저장(인접)
* 시간도 저장
*
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static class Node{
        int edge;
        int time;

        int max;
        public Node(int edge, int time, int max) {
            this.edge = edge;
            this.time = time;
            this.max = max;
        }

        public int getEdge() {
            return edge;
        }

        public void setEdge(int edge) {
            this.edge = edge;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getMax() {
            return max;
        }

        public void setMax(int max) {
            this.max = max;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "edge=" + edge +
                    ", time=" + time +
                    '}';
        }
    }
    public static int N;
    public static Node[] nodes;
    public static List<Integer>[] lists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            nodes = new Node[N+1];
            lists = new List[N+1];
            int total = 0;
            for (int i = 1; i <= N; i++) {
                lists[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                int time = Integer.parseInt(st.nextToken());
                nodes[i] = new Node(0, time, time);
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                lists[from].add(to);
                nodes[to].setEdge(nodes[to].getEdge()+1);
            }
            int must = Integer.parseInt(br.readLine());

            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                //System.out.println(nodes[i]);
                if(nodes[i].getEdge()==0){
                    //System.out.println(i);
                    q.offer(i);
                }
            }

            loop:while (!q.isEmpty()){

                int max = 0;

                int cur = q.poll();
                for (int i = 0; i < lists[cur].size(); i++) {
                    nodes[lists[cur].get(i)].setMax(Math.max(nodes[lists[cur].get(i)].getMax(), nodes[cur].getMax()+nodes[lists[cur].get(i)].getTime()));
                    nodes[lists[cur].get(i)].setEdge(nodes[lists[cur].get(i)].getEdge()-1);
                    // 갱신된 노드의 진입차수가 0이면 큐에 노드 넣기
                    if (nodes[lists[cur].get(i)].getEdge() == 0) {
                        q.offer(lists[cur].get(i));
                    }
                }
            }

            sb.append(nodes[must].getMax()+"\n");
        }
        System.out.println(sb);
    }
}