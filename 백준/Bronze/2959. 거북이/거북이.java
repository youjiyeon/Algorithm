import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		//숫자는 4개가 입력될 것이니 배열의 크기는 4이다.
		int[] arr = new int[4];
		
		for(int i = 0; i < 4; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//정렬
		Arrays.sort(arr);
		
		//제일 작은 수와 2번째로 큰 수이다.
		System.out.println(arr[0] * arr[2]);
	}
}