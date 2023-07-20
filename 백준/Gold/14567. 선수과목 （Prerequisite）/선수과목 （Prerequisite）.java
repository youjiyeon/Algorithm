import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N;
    public static int[] edge, result;
    public static List<Integer>[] list;
    public static Queue<Integer> q = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        edge = new int[N+1];
        result = new int[N+1];
        list = new List[N+1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            edge[to]++;
        }

        // 진입 차수가 없을 시 큐에 넣기
        for (int i = 1; i <= N; i++) {
            if (edge[i]==0){
                q.offer(i);
            }
        }

        // 위상 정렬
        sort();
        for (int i = 1; i <= N; i++) {
            System.out.print(result[i]+" ");
        }
    }
    public static void sort(){
        int cnt = 1;
        while (!q.isEmpty()){
            int size = q.size();

            for (int s = 0; s < size; s++) {
                int cur = q.poll();
                result[cur] = cnt;
                for (int i = 0; i < list[cur].size(); i++) {
                    edge[list[cur].get(i)]--;

                    if (edge[list[cur].get(i)] == 0) {
                        q.offer(list[cur].get(i));
                    }
                }
            }
            cnt++;
        }
    }
}