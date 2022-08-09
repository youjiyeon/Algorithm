package day0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2563_색종이_유지연_연습 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int paperNum = Integer.parseInt(br.readLine());
		int[][] papers = new int[paperNum][2];
		int sum = 0;
		for (int i = 0; i < paperNum; i++) 
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			papers[i][0] = Integer.parseInt(st.nextToken()); // x
			papers[i][1] = Integer.parseInt(st.nextToken()); // y
			
			if(i==0)
				sum += 100; // 색종이하나의 넓이
			for (int j = 0; j < i; j++) 
			{
				int firstX=0;
				int endX=0;
				
				int firstY=0;
				int endY=0;
				
				// x 조건안에 포함돼???
				if(papers[i][0] <= papers[j][0] && papers[j][0] <= papers[i][0]+10)
				{
					firstX = papers[j][0];
					if(papers[i][0] == papers[j][0])
						endX = papers[j][0]+10;
					else
						endX = papers[i][0]+10;
				}
				
				// x 조건안에 포함돼???
				if(papers[i][0] <= papers[j][0]+10 && papers[j][0]+10 <= papers[i][0]+10)
				{
					firstX = papers[j][0]+10;
					if(papers[i][0] == papers[j][0]+10)
						endX = papers[j][0];
					else
						endX = papers[i][0];
				}
				
				// y 조건안에 포함돼???
				if(papers[i][1] <= papers[j][1] && papers[j][1] <= papers[i][1]+10)
				{
					firstY = papers[j][1];
					if(papers[i][1] == papers[j][1])
						endY = papers[j][1]+10;
					else
						endY = papers[i][1]+10;
				}
				
				// y 조건안에 포함돼???
				if(papers[i][1] <= papers[j][1]+10 && papers[j][1]+10 <= papers[i][1]+10)
				{
					firstY = papers[j][1]+10;
					if(papers[i][1] == papers[j][1]+10)
						endY = papers[j][1];
					else
						endY = papers[i][1];
				}
				
				sum += 100 - Math.abs(firstX-endX) * Math.abs(firstY-endY);
			}
			
		}

		System.out.println(sum);
	}

}
