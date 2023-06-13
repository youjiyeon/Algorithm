/*
* 문제 설명
* 4마다 long 출력
* 마지막에 int 출력
*/

import java.io.*;
import java.util.*;

public class BJ_25314_Main {

	public static void main(String[] args) throws NumberFormatException, IOException {

		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int val = Integer.parseInt(br.readLine());
		//
		
		// 4의 몇배수인지 확인
		int n = val/4;
		
		// 해당 배수만큼 long 출력 반복
		for(int i=0;i<n;i++){
			System.out.print("long ");
		}
		System.out.print("int");
	}

}
