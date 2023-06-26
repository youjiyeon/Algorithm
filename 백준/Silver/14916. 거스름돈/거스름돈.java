import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int temp;
        int result;
        int i = 1;

        while (true){
            temp = num -(2*i);

            if(temp<0){
                result = -1;
                break;
            }

            if(temp%5==0){
                result = i + (temp/5);
                break;
            }
            else {
                if(num%5==0){
                    result = num/5;
                    break;
                }
            }
            i++;
        }

        System.out.println(result);
    }
}