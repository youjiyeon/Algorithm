import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N, M;
    public static long T;
    public static int[] numA, numB;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        
        N = Integer.parseInt(br.readLine());
        numA = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numA[i] = Integer.parseInt(st.nextToken());
        }

        M = Integer.parseInt(br.readLine());
        numB = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            numB[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<N; i++) {
            numA[i] += numA[i-1];
        }
        for(int i=1; i<M; i++) {
            numB[i] += numB[i-1];
        }

        int aSize = N*(N+1)/2;
        int bSize = M*(M+1)/2;
        long[] aSum = new long[aSize];
        int idx=0;
        for(int i=0; i<N; i++) {
            for(int j=i; j<N; j++) {
                int av = numA[j];
                if(i>0) av -= numA[i-1];
                aSum[idx++] = av;
            }
        }

        long[] bSum = new long[bSize];
        idx=0;
        for(int i=0; i<M; i++) {
            for(int j=i; j<M; j++) {
                int bv = numB[j];
                if(i>0) bv -= numB[i-1];
                bSum[idx++] = bv;
            }
        }

        Arrays.sort(aSum);
        Arrays.sort(bSum);
        int left =0;
        int right = bSize-1;
        long cnt=0;
        while(left<aSize&& right>-1) {
            long asv = aSum[left], bsv = bSum[right];
            long sum = asv + bsv;
            if(sum == T) {
                long ac =0, bc =0;
                while(left<aSize && asv == aSum[left]) {
                    left++;
                    ac++;
                }

                while(right>-1 && bsv == bSum[right]) {
                    right--;
                    bc++;
                }
                cnt += ac*bc;
            }
            if(sum>T) {
                right--;
            }else if(sum<T) {
                left++;
            }
        }
        System.out.println(cnt);
    }
}
