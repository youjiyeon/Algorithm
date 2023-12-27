import java.io.*;
import java.util.*;

public class Main {
    public static int n;
    public static long[] min;
    public static int[][] checker;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        checker = new int[n][2];
        min = new long[n];
        Arrays.fill(min, Long.MAX_VALUE);

        Set<Integer> x = new LinkedHashSet<>();
        Set<Integer> y = new LinkedHashSet<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            checker[i][0] = Integer.parseInt(st.nextToken());
            checker[i][1] = Integer.parseInt(st.nextToken());
            x.add(checker[i][0]);
            y.add(checker[i][1]);
        }

        List<Integer> xx = new ArrayList<>();
        Iterator iterator = x.iterator();
        while (iterator.hasNext()) {
            xx.add((Integer) iterator.next());
        }
        List<Integer> yy = new ArrayList<>();
        Iterator iter = y.iterator();
        while (iter.hasNext()) {
            yy.add((Integer) iter.next());
        }
        // 각 기준점마다
        for (int i = 0; i < xx.size(); i++) {
            for (int j = 0; j < yy.size(); j++) {
                // 각 체커와의 거리
                long[] tmp = new long[n];
                for (int k = 0; k < n; k++) {
                    tmp[k] = Math.abs(xx.get(i)-checker[k][0])+Math.abs(yy.get(j)-checker[k][1]);
                }
                Arrays.sort(tmp);
                long sum = 0;
                for (int k = 0; k < n; k++) {
                    sum+=tmp[k];
                    min[k] = Math.min(min[k], sum);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(min[i]+" ");
        }
    }
}