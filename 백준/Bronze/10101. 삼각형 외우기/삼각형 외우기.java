import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] val = new int[3];
        val[0] = Integer.parseInt(br.readLine());
        val[1] = Integer.parseInt(br.readLine());
        val[2] = Integer.parseInt(br.readLine());

        if (val[0]== 60 && val[1]==60 && val[2]==60){
            System.out.println("Equilateral");
        }
        // 세 각의 합 180
        else if (val[0]+val[1]+val[2]==180) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(i==j) continue;
                    if(val[i]==val[j]){
                        System.out.println("Isosceles");
                        System.exit(0);
                    }
                }
            }
            System.out.println("Scalene");
        }

        else {
            System.out.println("Error");
        }
    }
}