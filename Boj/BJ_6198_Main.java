import java.io.*;
import java.util.*;

public class BJ_6198_Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Stack<Integer> building = new Stack<>();
		long cnt=0;
		int[] in = new int[N];
		
		// save input
		for (int i = 0; i < N; i++) 
		{
			in[i] = Integer.parseInt(br.readLine());
		}
		// ---
		
		// action
		for (int i = 0; i < N; i++) 
		{
			// 스택이 비어있지않고 최상단 값이 input보다 작거나 같으면 안에 값 꺼내기
			while(!building.isEmpty() && building.peek() <= in[i])
				building.pop();
			// 남아있는 갯수 저장
			cnt += (long)building.size();
			building.push(in[i]);
		}
		// ---
		
		// print
		System.out.println(cnt);
		// ---
	}

}
