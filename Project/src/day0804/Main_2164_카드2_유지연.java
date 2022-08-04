package day0804;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Main_2164_카드2_유지연 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		Deque<Integer> dq = new ArrayDeque<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for(int i=1;i<=N;i++)
			dq.add(i);

		while(true)
		{
			// 하나만 남아있을 때까지
			if(dq.size()==1)
			{
				System.out.println(dq.removeFirst());
				break;
			}
			// 맨위의 카드는 버리고 그 다음 카드는 마지막으로 넣기
			else
			{
				dq.removeFirst();
				int loop = dq.removeFirst();
				dq.addLast(loop);
			}
		}
		
	}

}
