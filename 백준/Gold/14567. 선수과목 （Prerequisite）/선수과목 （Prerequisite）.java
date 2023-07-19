import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N;
    public static int[] edge, result;
    public static List<Integer>[] lists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        edge = new int[N+1];
        result = new int[N+1];
        lists = new List[N+1];

        for (int i = 0; i <= N; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            lists[from].add(to);
            edge[to]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (edge[i] == 0) {
                q.offer(i);
            }
        }

        int cnt = 1;
        while (!q.isEmpty()) {
            int size = q.size();

            for (int s = 0; s < size; s++) {
                // 큐에서 노드번호 꺼내기
                int nodeNo = q.poll();
                result[nodeNo] = cnt;

                // 꺼낸 노드의 인접한 노드들 찾기
                //List<Integer> list = lists[nodeNo];

                // 인접한 노드의 개수만큼 반복문 실행
                for (int i = 0; i < lists[nodeNo].size(); i++) {
                    // 인접한 노드 진입차수 갱신
                    edge[lists[nodeNo].get(i)] -- ;
                    // 갱신된 노드의 진입차수가 0이면 큐에 노드 넣기
                    if (edge[lists[nodeNo].get(i)] == 0) {
                        q.offer(lists[nodeNo].get(i));
                    }
                }
            }
            cnt++;
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(result[i]+" ");
        }
    }
}