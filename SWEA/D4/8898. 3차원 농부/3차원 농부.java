import java.io.*;
import java.util.*;

public class Solution {
    public static int n;
    public static int[] cow;
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");

            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int tmp = Math.abs(Integer.parseInt(st.nextToken())-Integer.parseInt(st.nextToken()));

            int min = Integer.MAX_VALUE;
            int cnt = 0;
            cow = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                cow[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(cow);

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                int horse = Integer.parseInt(st.nextToken());
                int dist = bs(horse);
                if (0 <= dist && dist < n) {
                    int cPos = cow[dist];
                    int dz = Math.abs(cPos - horse);
                    if (min > dz) {
                        min = dz;
                        cnt = 1;
                    } else if (min == dz) {
                        cnt++;
                    }
                }

                if (0 < dist && dist < n && cow[dist] != horse) {
                    int cPos = cow[dist - 1];
                    int dz = Math.abs(cPos - horse);
                    if (min > dz) {
                        min = dz;
                        cnt = 1;
                    } else if (min == dz) {
                        cnt++;
                    }

                }
            }

            sb.append(min+tmp).append(" ").append(cnt).append("\n");
        }
        System.out.print(sb);
    }

    private static int bs(int horse) {
        int s = 0;
        int e = n-1;
        int mid = 0;

        if (horse<cow[s])
            return 0;
        if (cow[e]<horse)
            return n-1;

        while (s<=e) {
            mid = (s+e)/2;
            if (cow[mid]==horse)
                return mid;
            else if (cow[mid]<horse) {
                s=mid+1;
            }
            else {
                e = mid-1;
            }
        }

        if (cow[mid]<horse) mid++;

        return mid;
    }
}