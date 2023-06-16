/*
* 문제 설명
* 들어온 N개의 인자값에서
* 타겟 val와 일치하는 값의 개수를 출력
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_10807_Main {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // N개의 인자값을 StringTokenizer에 저장
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 타켓 값 val
        int val = Integer.parseInt(br.readLine());
        //
        
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            // 값이 일치한다면 cnt++
            if(num == val) cnt++;
        }

        System.out.println(cnt);
    }
}
