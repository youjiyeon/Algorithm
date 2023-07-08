import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static int T;
    public static boolean[] visit;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        visit = new boolean[4];
        visit[1] = true;

        for (int i = 0; i < T; i++) {
            StringTokenizer st =  new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(visit[a]){
                visit[b] = true;
                visit[a] = false;
            }
            else if(visit[b]){
                visit[a] = true;
                visit[b] = false;
            }
        }

        for (int i = 1; i < 4; i++) {
            if(visit[i]){
                System.out.println(i);
            }
        }
    }
}