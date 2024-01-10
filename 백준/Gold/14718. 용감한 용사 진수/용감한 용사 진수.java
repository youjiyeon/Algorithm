import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int n, k, min = Integer.MAX_VALUE;
    public static int[][] arr;
    public static int[] peek;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n][3];
        peek = new int[3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        com(0);
        System.out.println(min);
    }

    public static void com(int cnt){

        if (cnt==3){
            int tmp = 0;
            for (int i = 0; i < n; i++) {
                if (peek[0]>=arr[i][0] && peek[1]>=arr[i][1] && peek[2]>=arr[i][2]){
                    tmp++;
                }
            }

            if (tmp>=k){
                min = Math.min(min, peek[0]+peek[1]+peek[2]);
            }
            return;
        }

        for (int i = 0; i < n; i++) {
            peek[cnt] = arr[i][cnt];
            com(cnt+1);
        }
    }
}