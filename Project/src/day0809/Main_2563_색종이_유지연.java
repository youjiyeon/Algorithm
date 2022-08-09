package day0809;

import java.io.*;
import java.util.*;

public class Main_2563_색종이_유지연 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int paperNum = Integer.parseInt(br.readLine());
		int[][] papers = new int[100][100];
		int cnt = 0;
		
		for (int i = 0; i < paperNum; i++) 
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			int firstX = Integer.parseInt(st.nextToken());
			int firstY = Integer.parseInt(st.nextToken());
			
			for (int x = firstX; x < firstX+10; x++) 
			{
				for (int y = firstY; y < firstY+10; y++) 
				{
					if(papers[x][y] != 1)
					{
						papers[x][y] = 1;
						cnt++;
					}
				}	
			}
		}
		System.out.println(cnt);
		
	}

}
