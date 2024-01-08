import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 123; i < 1000; i++) {
            q.offer(i);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int val = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int size = q.size();
            while (size-- > 0){
                int num = q.poll();
                if(isRight(val, num, s, b)){
                    q.offer(num);
                }
            }
        }

        System.out.println(q.size());
    }

    private static boolean isRight(int val, int num, int s, int b) {
        int ts = 0;
        int tb = 0;

        int[] v = new int[3];
        int[] n = new int[3];

        for (int i = 0; i < 3; i++) {
            v[i] = val%10;
            n[i] = num%10;

            if (v[i]==0 || n[i]==0)
                return false;
            val/=10;
            num/=10;
        }

        if (n[0] == n[1] || n[0] == n[2] || n[1] == n[2])
            return false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (v[i]==n[j]){
                    if (i==j)
                        ts++;
                    else
                        tb++;
                }
            }
        }

        if (ts==s && tb==b)
            return true;
        return false;
    }
}