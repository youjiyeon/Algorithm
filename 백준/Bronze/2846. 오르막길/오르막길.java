import java.util.Scanner;

public class Main {
	static int answer;
	static int n;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		int prev=0;//이전수
		int cur=0;//현재수 
		int min=0;//오르막길 최솟값
		boolean isAscending=false;
		for (int i = 0; i < n; i++) {
			cur=sc.nextInt();
			// 첫 수가 아니고 이전보다 더 큰 수가 나왔다면 오르막길 처리해준다.
			//오르막길 시작 크기도 min에 넣어준다
			if(prev!=0 && cur>prev && isAscending==false) {
				isAscending=true;
				min=prev;
			}
			if(cur<=prev) {//만약 작거나 같은 구간이면 오르막길 false 처리해준다
				isAscending=false;
			}
			
			if(isAscending) {//오르막길이라면 크기 갱신해준다.
				answer=Math.max(answer, cur-min);
			}
			
			
			prev=cur;
		}
		System.out.println(answer);
	}
}