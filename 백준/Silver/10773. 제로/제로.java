import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = new ArrayList<>();

        int pointer = -1;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            if (val==0){
                list.remove(pointer);
                pointer--;
            }
            else {
                list.add(val);
                pointer++;
            }
        }

        int sum = 0;
        for (int i: list) {
            sum += i;
        }
        System.out.println(sum);
    }
}