import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N;
    public static int[] edge;
    public static List<Integer>[] list;
    public static Queue<Integer> q = new LinkedList<>();
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        edge = new int[N+1];
        list = new List[N+1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int[] arr = new int[t];
            for (int j = 0; j < t; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0, k = j+1; k<t; j++, k++) {
                list[arr[j]].add(arr[j+1]);
                edge[arr[j+1]]++;
            }
        }

        // 진입 차수가 0인 노드 큐에 넣기
        for (int i = 1; i <= N; i++) {
            if (edge[i]==0){
                q.offer(i);
            }
        }

        // 상위정렬
        TopologicalSort();
        for (int i = 1; i <= N; i++) {
            if (edge[i]!=0){
                System.out.println(0);
                System.exit(0);
            }
        }
        System.out.println(sb);
    }

    private static void TopologicalSort() {
        while (!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur+"\n");

            for (int i = 0; i < list[cur].size(); i++) {
                edge[list[cur].get(i)]--;
                if (edge[list[cur].get(i)]==0){
                    q.offer(list[cur].get(i));
                }
            }
        }
    }
}