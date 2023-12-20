import java.io.*;
import java.util.*;

public class Main {
    public static int n, m;
    public static char[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken())*3;
        m = Integer.parseInt(st.nextToken())*8;

        map = new char[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                // 숫자일 경우
                if (map[i][j]!='.' && map[i][j]!='/' && map[i][j]!='*'){
                    int a = map[i][j]-'0';
                    int b = map[i][j+2]-'0';
                    int c = map[i][j+4]-'0';
                    int plus = 4;
                    if (map[i][j+5]!='.' && map[i][j+5]!='/' && map[i][j+5]!='*'){
                        c*=10;
                        c+=(map[i][j+5]-'0');
                        plus = 5;
                    }

                    if (a+b==c){
                        // 맞음
                        for (int k = 0; k < plus+1; k++) {
                            map[i-1][j+k] = '*';
                        }
                        for (int k = 0; k < plus+1; k++) {
                            map[i+1][j+k] = '*';
                        }
                        map[i][j-1] = '*';
                        map[i][j+plus+1] = '*';
                    }
                    else {
                        // 틀림
                        map[i-1][j+2] = '/';
                        map[i][j+1] = '/';
                        map[i+1][j] = '/';
                    }
                    j+=plus;
                }
            }
        }

        // 프린트
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}