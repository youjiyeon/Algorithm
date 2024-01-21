import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int[] arr = new int[9];
        for(int i=0; i<9; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        Arrays.sort(arr);
        int findNum = sum - 100;
        int left = 0;
        int right = 8;
        while(true) {
            if(arr[left] + arr[right] == findNum) {
                break;
            }
            if(findNum > arr[left] + arr[right]) {
                left++;
            }
            else {
                right--;
            }
        }

        for(int i = 0; i < 9; i++) {
            if(i==left || i==right) {
                continue;
            }
            sb.append(arr[i]).append("\n");
        }

        System.out.println(sb);
    }
}