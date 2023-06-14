/*
* 문제 설명
* 28개의 입력을 받고
* 입력이 안들어온 두 수를 오른차순으로 출력
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_5597_Main {
    public static boolean[] visit;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        visit = new boolean[31];
        for (int i = 0; i < 28; i++) {
            int val = Integer.parseInt(br.readLine());
            visit[val] = true;
        }

        for (int i = 1; i < 31; i++) {
            if(!visit[i]){
                System.out.println(i);
            }
        }
    }

}
