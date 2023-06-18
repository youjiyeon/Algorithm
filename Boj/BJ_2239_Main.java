import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class BJ_2239_Main {
    public static int[][] map;
    public static List<int[]> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[9][9];
        list = new LinkedList<>();

        for (int i = 0; i < 9; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
                if(map[i][j] == 0){
                    list.add(new int[] {i, j});
                }
            }
        }

        sdoku(0);

    }

    public static void sdoku(int cnt){

        if(list.size() == cnt){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }
            System.exit(0);
        }

        int x = list.get(cnt)[0];
        int y = list.get(cnt)[1];

        boolean[] check = new boolean[10];

        // 가로
        for (int i = 0; i < 9; i++) {
            if(map[x][i] != 0){
                check[map[x][i]] = true;
            }
        }
        // 세로
        for (int i = 0; i < 9; i++) {
            if(map[i][y] != 0){
                check[map[i][y]] = true;
            }
        }
        // 9개 칸
        int sx = (x/3)*3;
        int sy = (y/3)*3;
        for (int i = sx; i < sx+3; i++) {
            for (int j = sy; j < sy+3; j++) {
                if(map[i][j] != 0){
                    check[map[i][j]] = true;
                }
            }
        }

        for (int i = 1; i < 10; i++) {
            if(!check[i]){
                map[x][y] = i;
                sdoku(cnt+1);
                map[x][y] = 0;
            }
        }
    }
}
