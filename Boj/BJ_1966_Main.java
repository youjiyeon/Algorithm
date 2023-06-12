import java.io.*;
import java.util.*;

public class BJ_1966_Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) 
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 문서의 갯수
			int M = Integer.parseInt(st.nextToken()); // 궁금한 문서의 위치
			Queue<Integer> queue = new LinkedList<Integer>();
			PriorityQueue<Integer> priqueue = new PriorityQueue<Integer>(Collections.reverseOrder());
			
			int cnt = 0; // 몇번째로 인쇄되는 지
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) 
			{
				int in = Integer.parseInt(st.nextToken());
				priqueue.add(in);
				queue.add(in);
			}
			
			while(true)
			{
				
				int out = queue.poll();
				
				// 인쇄하는 경우
				if(out == priqueue.peek()) 
				{
					priqueue.poll();
					cnt++;
					if(M==0)
						break;
					M--;
					if(M<0)
						M=queue.size()-1;
				}
				// 인쇄 안하는 경우 -> 다시 queue로 add
				else
				{
					queue.add(out);
					M--;
					if(M<0)
						M=queue.size()-1;
				}

			}
			
			System.out.println(cnt);
		}

	}

}
