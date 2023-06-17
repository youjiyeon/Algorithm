import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_1717_Main {
    public static int N;
    public static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        parents = new int[N+1];

        set();
        int M = Integer.parseInt(st.nextToken());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(type == 0){
                union(a, b);
            }
            else{
                if(find(a) == find(b)){
                    System.out.println("YES");
                }
                else System.out.println("NO");
            }
        }
//        각 root가 무엇인지 확인
//        for (int i = 1; i <= N; i++) {
//            System.out.println(find(i));
//        }
    }

    public static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot!=bRoot){
            parents[find(a)] = find(b);
        }
    }

    public static int find(int v){
        if(parents[v] == v) return v;
        else return parents[v] = find(parents[v]);
    }

    public static void set(){
        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }
    }
}
