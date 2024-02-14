import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int num;
    public static int[] point, val;
    public static boolean[] card;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        num = Integer.parseInt(br.readLine());

        point = new int[1000001];
        val = new int[num];
        card = new boolean[1000001];

        // 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < num; i++) {
            val[i] = Integer.parseInt(st.nextToken());
            card[val[i]] = true;
        }
        //

        // 게임
        play();
        //

        for (int i: val) {
            sb.append(point[i]+" ");
        }
        System.out.println(sb);
    }

    public static void play(){
        for (int i = 0; i < num; i++) {
            for (int j = val[i]; j < 1000001; j+=val[i]) {
                // 자기 자신 제외
                if(val[i]!=j){
                    // 나눠진다면?
                    if(card[j]){

                        point[val[i]]++;
                        point[j]--;

                    }
                }
            }
        }
    }
}