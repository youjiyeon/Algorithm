import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] house;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        house = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            house[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(house);

        if (N%2==0){
            System.out.println(house[N/2]);
        }
        else {
            System.out.println(house[N/2+1]);
        }
    }
}