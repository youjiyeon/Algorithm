import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();

        for (int i = 2; i <= N; i++) {
            if (isPrime(i)){
                list.add(i);
            }
        }

        int cnt = 0, sum = 2, r = 0, l = 0;

        while (r< list.size() && l<list.size()){
            if (sum==N){
                cnt++;
                sum-=list.get(l);
                l++;
            }
            else if(sum>N){
                sum-=list.get(l);
                l++;
            }
            else {
                r++;
                if(r>=list.size()){
                    break;
                }
                sum += list.get(r);
            }
        }

        System.out.println(cnt);
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i<=(int)Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}