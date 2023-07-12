import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> xList = new ArrayList<>();
        List<Integer> yList = new ArrayList<>();
        int[] xCnt = new int[1001];
        int[] yCnt = new int[1001];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            xList.add(x);
            yList.add(y);
            xCnt[x]++;
            yCnt[y]++;
        }

        for (int i = 0; i < xList.size(); i++) {
            if (xCnt[xList.get(i)]==1){
                System.out.print(xList.get(i)+" ");
                break;
            }
        }

        for (int i = 0; i < yList.size(); i++) {
            if (yCnt[yList.get(i)]==1){
                System.out.print(yList.get(i)+" ");
                break;
            }
        }
    }
}