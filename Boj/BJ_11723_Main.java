import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ_11723_Main {
    public static boolean[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        arr = new boolean[20+1];
        StringBuilder sb = new StringBuilder();

        int val = 0;
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String order = st.nextToken();

            switch (order){
                case "add":
                    val = Integer.parseInt(st.nextToken());
                    add(val);
                    break;

                case "remove":
                    val = Integer.parseInt(st.nextToken());
                    remove(val);
                    break;

                case "check":
                    val = Integer.parseInt(st.nextToken());
                    sb.append(check(val)+"\n");
                    break;

                case "toggle":
                    val = Integer.parseInt(st.nextToken());
                    toggle(val);
                    break;

                case "all":
                    all();
                    break;

                case "empty":
                    empty();
                    break;
            }
        }
        System.out.println(sb);
    }

    public static void add(int val){
        arr[val] = true;
    }

    public static void remove(int val){
        arr[val] = false;
    }

    public static int check(int val){
        if(arr[val]) return 1;
        return 0;
    }

    public static void toggle(int val){
        if(arr[val]) arr[val] = false;
        else arr[val] = true;
    }

    public static void all(){
        Arrays.fill(arr, true);
    }

    public static void empty(){
        Arrays.fill(arr, false);
    }

}
