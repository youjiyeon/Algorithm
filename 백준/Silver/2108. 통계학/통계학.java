import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static Map<Integer, Integer> map = new HashMap<>();
    public static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE, sum = 0;
    public static int[] num;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = new int[N];

        for (int i = 0; i < N; i++) {
            sum += num[i] = Integer.parseInt(br.readLine());
            if (map.containsKey(num[i])){
                map.put(num[i], map.get(num[i])+1);
            }
            else map.put(num[i], 1);
        }

        avg();
        middle();
        most();
        diff();
        System.out.println(sb);
    }

    // 평균(첫째짜리에서 반올림)
    public static void avg(){
        double temp = (double) sum/N;
        String str = String.format("%.0f", temp);
        if (str.equals("-0")){
            str = "0";
        }
        sb.append(str+"\n");
    }

    // 오름차순 정렬 후 가운데값
    public static void middle(){
        Arrays.sort(num);
        sb.append(num[N/2]+"\n");
    }

    // 가장 많이 나타나는 값
    public static void most(){
        int maxCnt = Integer.MIN_VALUE;
        int minIdx = -1;
        for (int i = 0; i < N; i++) {
            if (map.get(num[i])>maxCnt){
                //System.out.println(i+" "+num[i]+" "+);
               maxCnt = map.get(num[i]);
               minIdx = i;
            }
        }

        for (int i = 0; i < N; i++) {
            if (i!=minIdx && num[i]!=num[minIdx] && map.get(num[i])==maxCnt){
                minIdx = i;
                break;
            }
        }

        sb.append(num[minIdx]+"\n");
    }

    // 최대 최소 차
    public static void diff(){
        sb.append(Math.abs(num[N-1]-num[0]));
    }
}