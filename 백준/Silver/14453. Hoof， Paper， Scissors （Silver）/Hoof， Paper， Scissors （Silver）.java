import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        // 0가위, 1바위, 2보
        int[][] win = new int[3][n+1];
        char[] c = new char[n+1];
        for (int i = 1; i <= n; i++) {
            c[i] = br.readLine().charAt(0);
            win[0][i] = win[0][i-1];
            win[1][i] = win[1][i-1];
            win[2][i] = win[2][i-1];
            switch (c[i]){
                case 'S':
                    win[1][i]++;
                    break;
                case 'H':
                    win[2][i]++;
                    break;
                case 'P':
                    win[0][i]++;
                    break;
            }
        }

        max = Math.max(max, win[0][n]);
        max = Math.max(max, win[1][n]);
        max = Math.max(max, win[2][n]);
        for (int i = 2; i <= n; i++) {
            max = Math.max(max, win[0][i-1]+(win[1][n]-win[1][i-1]));
            max = Math.max(max, win[0][i-1]+(win[2][n]-win[2][i-1]));

            max = Math.max(max, win[1][i-1]+(win[0][n]-win[0][i-1]));
            max = Math.max(max, win[1][i-1]+(win[2][n]-win[2][i-1]));

            max = Math.max(max, win[2][i-1]+(win[0][n]-win[0][i-1]));
            max = Math.max(max, win[2][i-1]+(win[1][n]-win[1][i-1]));
        }
        System.out.println(max);
    }
}