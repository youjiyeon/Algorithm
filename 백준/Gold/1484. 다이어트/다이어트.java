/*
    while문 조건은 s<=n
    s와 e를 처음엔 1로 하고
    짝수가 아닌게 K를 넘어가면 or 끝에 도달하면
    s++, e=s 초기화
 */
import java.io.*;
import java.util.*;

public class Main {
    public static int G;
    public static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        G = Integer.parseInt(br.readLine());

        int s = 1;
        int e = 2;
        while (s<e){
            // G랑 일치하다면
            if (Math.pow(e,2)-Math.pow(s,2)==G){
                list.add(e);
                s++;
                e++;
            }
            // G보다 작다면
            else if (Math.pow(e,2)-Math.pow(s,2)<G){
                e++;
            }
            // G보다 크다면
            else if (Math.pow(e,2)-Math.pow(s,2)>G){
                s++;
            }
        }

        if (list.isEmpty()){
            System.out.println(-1);
            System.exit(0);
        }
        for (int i:list) {
            System.out.println(i);
        }
    }
}