package day0801;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int size = sc.nextInt();
		int arr[] = new int[size+1]; //0번은 비움
		arr[0] = 0;		

		for(int i=1;i<=size;i++)
			arr[i] = sc.nextInt();

		
		int std_num = sc.nextInt();
		
		int sexArr[] = new int[size+1];
		int idxArr[] = new int[size+1];
		
		for(int i=1;i<=std_num;i++) {
			sexArr[i] = sc.nextInt();
			idxArr[i] = sc.nextInt();
		}

		for(int i=1;i<=std_num;i++) {
			boolean isMan = (sexArr[i] == 1)? true : false;
			int idx = idxArr[i];

			if(isMan)
			{			
				while(idx <= size)
				{		

					arr[idx] = ((arr[idx] == 1)? 0 : 1);
					idx += idxArr[i];

				}
			}
			if(!(isMan))
			{   
				int cnt = 0;
            	int leftIdx = idx-1;
            	int rightIdx = idx+1;

            	//System.out.println(idx);
	            while(leftIdx >=1 && rightIdx <= size && arr[leftIdx] == arr[rightIdx])
	            {
	                cnt++;
	                leftIdx--;
	                rightIdx++;
	            }
	
	            if(cnt == 0)
	                arr[idx] = ((arr[idx] == 1)? 0 : 1);
	            else {
	
	                for(int j=leftIdx;j<rightIdx;j++)
	                    arr[j] = ((arr[j] == 1)? 0 : 1);
	            }
	        }
			
		}
		
		for(int i=1;i<=size;i++)
		{
			System.out.print(arr[i]+" ");
			if(i%20==0)
				System.out.println();
		}
	}

}
