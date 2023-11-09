import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//첫번째 값과 두번째 값을 저장할 문자열 변수
        String S = "";
        //최종 값을 저장할 정수형 변수 
		long N = 0;
		
		for(int i = 0; i < 3; i++) {
			String A = br.readLine();
			
            //입력값을 판단 후 해당 값을 연산.
            //첫번째, 두번째 값과 세번째 값의 연산 방식이 다르기 때문에 조건문으로 분리
			switch(A) {
			case "black":
				if(i == 2) {
					N *= 1;
				}else {
					S += "0";
				}
			break;
			case "brown":
				if(i == 2) {
					N *= 10;
				}else {
					S += "1";
				}
			break;
			case "red":
				if(i == 2) {
					N *= 100;
				}else {
					S += "2";
				}
			break;
			case "orange":
				if(i == 2) {
					N *= 1000;
				}else {
					S += "3";
				}
			break;
			case "yellow":
				if(i == 2) {
					N *= 10000;
				}else {
					S += "4";
				}
			break;
			case "green":
				if(i == 2) {
					N *= 100000;
				}else {
					S += "5";
				}
			break;
			case "blue":
				if(i == 2) {
					N *= 1000000;
				}else {
					S += "6";
				}
			break;
			case "violet":
				if(i == 2) {
					N *= 10000000;
				}else {
					S += "7";
				}
			break;
			case "grey":
				if(i == 2) {
					N *= 100000000;
				}else {
					S += "8";
				}
			break;
			case "white":
				if(i == 2) {
					N *= 1000000000;
				}else {
					S += "9";
				}
			break;
			}
            //두번째 값까지 연산이 되었다면 정수형에 형변환해서 저장
			if(i == 1) {
				N = Long.parseLong(S);
			}
		}
		System.out.println(N);
	}

}