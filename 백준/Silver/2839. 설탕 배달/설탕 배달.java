

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		
		
		int temp;
		int result;
		int i = 1;
		
		while(true)
		{
			temp = input - (3*i);
			
			if(temp<0)
			{
				result = -1;
				break;
			}
			
			if((temp%5)==0)
			{
				result = i + (temp / 5);
				break;
			}
			else 
			{
				if((input%5)==0)
				{
					result = input/5;
					break;
				}
			}
			
			i++;
		}
		System.out.print(result);

	}

}
