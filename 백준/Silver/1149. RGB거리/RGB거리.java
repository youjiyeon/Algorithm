
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] house;
	static int[] d;
	static int sum;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// house[3][0] 2번째 집의 빨강 가격
		house = new int[N+1][3];
		d = new int[N+1];
		sum = 0;
		
		// 집 페인트 가격 입력
		// 이전의 다른 색깔과의 합 중 적은 것 입력으로 넣기
		for (int i = 1; i <= N; i++) 
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) 
			{
				int input = Integer.parseInt(st.nextToken());
				if(i!=0)
				{
					switch (j) {
					case 0:
						house[i][j] = Math.min(input+house[i-1][1], input+house[i-1][2]);
						break;
					case 1:
						house[i][j] = Math.min(input+house[i-1][0], input+house[i-1][2]);
						break;
					case 2:
						house[i][j] = Math.min(input+house[i-1][0], input+house[i-1][1]);
						break;
					default:
						break;
					}
					
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		for (int j = 0; j < 3; j++) 
		{
			if (min > house[N][j]) {
				min = house[N][j];
			}
		}
		
		System.out.println(min);
	}

}
