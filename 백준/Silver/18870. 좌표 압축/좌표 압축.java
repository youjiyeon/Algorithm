import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] num, temp;
    public static StringBuilder sb = new StringBuilder();
    public static List<Integer> list = new ArrayList<>();
    public static Set<Integer> set = new LinkedHashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];
        temp = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
            temp[i] = num[i];
        }

        Arrays.sort(temp);
        for (int i = 0; i < N; i++) {
            if (i==0 || temp[i-1]!=temp[i]){
                list.add(temp[i]);
            }
        }
        
        for (int i = 0; i < N; i++) {
            bs(num[i]);
        }
        System.out.println(sb);
    }

    public static void bs(int target){
        int l = 0;
        int r = list.size()-1;
        int mid = 0;
        while (l<=r){
            mid = (l+r)/2;
            if (list.get(mid)<target){
                l = mid+1;
            }
            else if (list.get(mid)>target) {
                r = mid-1;
            }
            else {
                sb.append(mid+" ");
                return;
            }
        }
    }
}
