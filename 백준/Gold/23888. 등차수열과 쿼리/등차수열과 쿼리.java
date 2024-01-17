import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static long a;
    static long d;
    static long ans_2;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        long a1 = Math.max(a, d);
        long d1 = Math.min(a, d);
        ans_2 = gcd(a1, d1);//2번쿼리 답이 연속된 두항이상이면 무조건 답이 이거.

        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            long l = Integer.parseInt(st.nextToken());
            long r = Integer.parseInt(st.nextToken());

            // 합
            if(type==1) {
                String s = String.valueOf(((a+(l-1)*d)+(a+(r-1)*d))*(r-l+1)/2);
                sb.append(s).append("\n");
            }
            // 최대공약수
            else {
                if(l==r) {
                    String s = String.valueOf((a+(l-1)*d));
                    sb.append(s).append("\n");
                }
                else {
                    String s = String.valueOf(ans_2);
                    sb.append(s).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
    public static long gcd(long A, long B){//A가 큰거, B가 작은거.
        if(B==0) return A;
        while (true){
            if(A%B==0) break;
            long tmp = B;
            B=A%B;
            A=tmp;
        }
        return B;
    }

}