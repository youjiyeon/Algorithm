import java.io.*;
public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//총 합을 넣을 변수를 선언
		int sum = 0;
		//최솟값을 넣을 변수를 100으로 선언
		int min = 100;
		
		//앞 4과목 총 합을 구하고 4과목 중 최솟값을 구하는 반복문
		for(int i = 0; i < 4; i++) {
			int N = Integer.parseInt(br.readLine());
			sum += N;
			if(min > N) {
				min = N;
			}
		}
		//구한 최솟값을 합에서 뻄
		sum -= min;
		//남은 두과목 중 최솟 값을 다시 구해야하니 100으로 초기화
		min = 100;
		//남은 두과목의 합과 최솟 값을 다시 구하는 반복문
		for(int i = 0; i < 2; i++) {
			int N = Integer.parseInt(br.readLine());
			sum += N;
			if(min > N) {
				min = N;
			}
		}
		sum -= min;
		/*이 공식은 숫자 두개는 굳이 반복문 사용하지 않고 두수를 Math 함수로
		최대값을 구해서 최대값만 sum에 합하는 방식이다.
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		sum += Math.max(A, B);*/
		
		System.out.println(sum);
	}

}