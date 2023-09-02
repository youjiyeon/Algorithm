import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static int N, M, sx, sy;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(st.nextToken());
        sy = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(br.readLine());
        sx += t; sy += t;
        sx%=(2*N); sy%=(2*M);
        if(sx>N) sx = 2*N - sx;
        if(sy>M) sy = 2*M - sy;
        
        sb.append(sx).append(" ").append(sy);
        System.out.println(sb);
    }
}