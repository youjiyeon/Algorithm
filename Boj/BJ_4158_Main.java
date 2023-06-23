import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_4158_Main {
    public static int N, M, cnt;
    public static int[] arrA, arrB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            cnt = 0;
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            if(N==0 && M==0) break;
            arrA = new int[N];
            for (int i = 0; i < N; i++) {
                arrA[i] = Integer.parseInt(br.readLine());
            }
            arrB = new int[M];
            for (int i = 0; i < N; i++) {
                arrB[i] = Integer.parseInt(br.readLine());
            }

            if(N>=M) {
                for (int i = 0; i < N; i++) {
                    binarySearchA(arrA[i], 0, M - 1);
                }
            }
            else {
                for (int i = 0; i < M; i++) {
                    binarySearchB(arrB[i], 0, M - 1);
                }
            }
            //twoPoint();
            sb.append(cnt+" ");
        }
        System.out.println(sb);
    }

    public static void binarySearchA(int key, int low, int high) {
        int mid;

        if(low <= high) {
            mid = (low + high) / 2;

            if(key == arrB[mid]) { // 탐색 성공
                cnt++;
            } else if(key < arrB[mid]) {
                // 왼쪽 부분 arr[0]부터 arr[mid-1]에서의 탐색
                binarySearchA(key ,low, mid-1);
            } else {
                // 오른쪽 부분 - arr[mid+1]부터 arr[high]에서의 탐색
                binarySearchA(key, mid+1, high);
            }
        }
    }
    public static void binarySearchB(int key, int low, int high) {
        int mid;

        if(low <= high) {
            mid = (low + high) / 2;

            if(key == arrA[mid]) { // 탐색 성공
                cnt++;
            } else if(key < arrA[mid]) {
                // 왼쪽 부분 arr[0]부터 arr[mid-1]에서의 탐색
                binarySearchB(key ,low, mid-1);
            } else {
                // 오른쪽 부분 - arr[mid+1]부터 arr[high]에서의 탐색
                binarySearchB(key, mid+1, high);
            }
        }
    }

    public static void twoPoint() {
        int aPoint = 0;
        int bPoint = 0;

        while (aPoint<N && bPoint<M){
            if(arrA[aPoint] == arrB[bPoint]){
                cnt++;
                if(N>=M) aPoint++;
                else bPoint++;
            }
            else if(arrA[aPoint]>arrB[bPoint]){
                bPoint++;
            }
            else if(arrA[aPoint]<arrB[bPoint]){
                aPoint++;
            }
        }

    }
}
