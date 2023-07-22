import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int min = Integer.MAX_VALUE;
    public static String[] arr;
    public static List<Character> cal = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        arr = br.readLine().split("-");

        for (int i = 0; i < arr.length; i++) {
            int temp = 0;

            String[] add = arr[i].split("\\+");

            for (int j = 0; j < add.length; j++) {
                temp += Integer.parseInt(add[j]);
            }

            if (min == Integer.MAX_VALUE){
                min = temp;
            }
            else min -= temp;
        }

        System.out.println(min);
    }
}