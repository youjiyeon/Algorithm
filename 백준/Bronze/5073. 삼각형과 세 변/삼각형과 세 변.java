import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            int[] arr= new int[3];
            int max = 0;
            int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 3; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, arr[i]);
                sum+=arr[i];
            }

            if (arr[0]==0 && arr[1]==0 && arr[2]==0){
                break;
            }

            // 세 변의 길이가 모두 같은 경우
            if(arr[0]==max && arr[1]==max && arr[2]==max){
                sb.append("Equilateral\n");
            }
            else if ((sum-max)<=max) {
                sb.append("Invalid\n");
            }
            else {
                boolean flag = true;
                one: for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (i==j) continue;
                        if (arr[i]==arr[j]){
                            sb.append("Isosceles\n");
                            flag = false;
                            break one;
                        }
                    }
                }
                if (flag)
                    sb.append("Scalene\n");
            }
        }
        System.out.println(sb);
    }
}