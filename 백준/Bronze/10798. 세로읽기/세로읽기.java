import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[][] strs = new String[5][];
        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            strs[i]=str.split("");
        }


        for (int i = 0; i<15; i++) {
            for (int j = 0; j < 5; j++) {
                if (i < strs[j].length) {
                    System.out.print(strs[j][i]);
                }
            }
        }
    }
}