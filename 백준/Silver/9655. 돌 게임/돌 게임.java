import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int val = Integer.parseInt(br.readLine());

        int temp;
        int result;
        int i = 1;

        while (true){
            temp = val - (1*i);

            if(temp%3==0){
                result = i+(temp/3);
                break;
            }
            else {
                if(val%3==0){
                    result = val/3;
                    break;
                }
            }
            i++;
        }

        if(result%2!=0){
            System.out.println("SK");
        }
        else System.out.println("CY");
    }
}