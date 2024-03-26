

import java.io.*;
import java.util.*;

public class Main {

    static int N, E, startPoint, endPoint;
    static int[][] graph;
    static int pos;
    static boolean[] visitied;

    //static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	
    	N = Integer.parseInt(br.readLine());
    	
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	startPoint = Integer.parseInt(st.nextToken());
    	endPoint = Integer.parseInt(st.nextToken());
    	
        E = Integer.parseInt(br.readLine());

        graph = new int[101][101];
        visitied = new boolean[N+1];


        //인접행렬을 완성
        int v1, v2;
        for(int i=1; i<=E; i++)
        {
        	st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());

            graph[v1][v2] = 1;
            graph[v2][v1] = 1;
        }
        System.out.println(bfs(startPoint));
    }

    static int bfs(int startPoint){

        Queue<Integer> queue = new LinkedList<>();

        //시작지점 처리
        visitied[startPoint] = true;
        queue.offer(startPoint);

        int level = 0; //시작지점으로부터의 거리


        while ( !queue.isEmpty() ){ //큐가 빌때까지 돈다

            //System.out.println("========== level: " + level + " ==========");

            int qSize = queue.size();
            for(int i=1; i<=qSize; i++){
                pos = queue.poll();
                if(pos == endPoint)
                	return level;
                //System.out.println(pos + " ");

                //인접영역 탐색
                for(int j=1; j<graph[pos].length; j++){
                    if( graph[pos][j]==1 && visitied[j]==false ){ //연결되어 있고 방문하지 않은 경우
                        queue.offer(j);
                        visitied[j] = true;
                    }
                }//for(j)
            }//for(i)

            level++;

        }//while
        return -1;
    }
}