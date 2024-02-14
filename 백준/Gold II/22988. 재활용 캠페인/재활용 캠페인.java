import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());
        long min = 0;
        long ans = 0;

        if(x%2 == 0){
            min = x/2;
        }
        else{
            min = x/2 + 1;
        }
        st = new StringTokenizer(br.readLine());
        List<Long> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            long num = Long.parseLong(st.nextToken());
            if(num >= x){
                ans++;
                continue;
            }
            list.add(num);
        }
        Collections.sort(list);

        // 투 포인터
        int s = 0;
        int e = list.size()-1;
        int cnt = 0;
        while(s<=e){
            long sum = list.get(s) + list.get(e);
            if(s < e && sum >= min){
                ans++;
                s++;
                e--;
            }
            else{
                cnt++;
                s++;
            }
        }

        ans += cnt/3;
        System.out.println(ans);
    }
}