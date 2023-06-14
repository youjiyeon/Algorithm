/*
* 문제 설명
* 28개의 입력을 받고
* 입력이 안들어온 두 수를 오른차순으로 출력
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_5597_Main {
    // 30개의 숫자의 입력 유무를 나타내기 위한 boolean 배열
    public static boolean[] visit;
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        visit = new boolean[31];
        for (int i = 0; i < 28; i++) {
            int val = Integer.parseInt(br.readLine());
            // 입력이 들어온다면 true로 변환
            visit[val] = true;
        }
        //
        
        // 결과 출력
        // 오름차순으로 검사
        for (int i = 1; i < 31; i++) {
            if(!visit[i]){
                System.out.println(i);
            }
        }
        //
    }

}
