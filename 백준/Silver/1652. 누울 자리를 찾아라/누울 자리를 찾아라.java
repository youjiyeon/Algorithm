import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int R = 0, C = 0;
        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '.') {
                    cnt++;
                    if (cnt>=2) {
                        R++;
                        while (map[i][j]!='X') {
                            j++;
                            if (j >= N) break;
                        }
                        cnt = 0;
                    }
                }
                else cnt = 0;
            }
        }

        for (int i = 0; i < N; i++) {
            int cnt = 0;
            for (int j = 0; j < N; j++) {
                if (map[j][i] == '.') {
                    cnt++;
                    if (cnt>=2) {
                        C++;
                        while (map[j][i]!='X') {
                            j++;
                            if (j >= N) break;
                        }
                        cnt = 0;
                    }
                }
                else cnt = 0;
            }
        }

        System.out.println(R+" "+C);
    }
}