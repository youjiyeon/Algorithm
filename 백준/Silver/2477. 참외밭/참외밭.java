import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node{
        int w;
        int v;

        public Node(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxR = Integer.MIN_VALUE;
        int maxC = Integer.MIN_VALUE;
        int d = 0;
        int k = Integer.parseInt(br.readLine());
        Node[] map = new Node[6];
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            if (w==1 || w==2){
                maxR = Math.max(maxR, len);
            }
            else {
                maxC = Math.max(maxC, len);
            }
            map[i] = new Node(w,len);
        }

        T: for (int i = 0; i < 6; i++) {
            int diff = i-1;
            if (i==0){
                diff = 5;
            }

            switch (map[i].w){
                case 1:
                    if (map[diff].w!=3){
                        d = map[diff].v*map[i].v;
                        break T;
                    }
                    break;
                case 2:
                    if (map[diff].w!=4){
                        d = map[diff].v*map[i].v;
                        break T;
                    }
                    break;
                case 3:
                    if (map[diff].w!=2){
                        d = map[diff].v*map[i].v;
                        break T;
                    }
                    break;
                case 4:
                    if (map[diff].w!=1){
                        d = map[diff].v*map[i].v;
                        break T;
                    }
                    break;
            }
        }
        System.out.println(k*((maxR*maxC)-d));
    }
}