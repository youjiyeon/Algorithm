/*
* 문제 설명
* K개 이상의 라이언 인형을 포함하는 가장 작은 연속된 인형들의 집합의 크기를 출력
* 1일때 저장해두고 저장한걸 돌면서 K개 인지 확인 & 최소 갱신
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ_15565_Main {
    public static int N, K, min;
    public static int[] arr;
    public static List<Integer> list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        min = Integer.MAX_VALUE;
        arr = new int[N];
        list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i]==1){
                list.add(i);
            }
        }
        if (list.size() < K) {
            System.out.println(-1);
            System.exit(0);
        }

        twoPoint();
        System.out.println(min);
    }

    private static void twoPoint() {
        int start=0,end=K-1;    // (슬라이딩)윈도우 사이즈 지정
        int cnt=0;
        while(true) {
            if(end==list.size()) break;
            cnt=list.get(end)-list.get(start)+1;
            min=Math.min(min, cnt);

            start++;
            end++;
        }
    }

    private static void find() {

        for (int i = 0; i < list.size(); i++) {
            if(i+(K-1)<list.size()){
                min = Math.min(min, (list.get(i+2)-list.get(i))+1);
            }
        }
    }
}
