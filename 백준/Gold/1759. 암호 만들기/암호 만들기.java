
import java.io.*;
import java.util.*;

public class Main {

	static int pick; //조합할 원소 수
	static int num;
	static String[] v; //조합을 구해야 할 주어진 원소
	static String[] result; //완성된 조합이 저장되고 갱신되는 공간

	static String[] vowel = { "a","e","i","o","u" };

	static void dfs(int idx, int d) 
	{


		if (d == pick) 
		{
			int flag = 0;
			int cnt_v = 0;
			int cnt_c = 0;

			for (int i = 0; i < pick; i++)
			{
				flag = 0;
				for (int j = 0; j < 5; j++)
				{
					if (result[i].equals(vowel[j]))//하나의 모음
					{
						flag = 1;
					}

				}
				if (flag == 0)
				{
					cnt_v++;
				}
				else
				{
					cnt_c++;
				}
			}

			if (cnt_c>=1 && cnt_v >= 2)
			{
				for (int i = 0; i < pick; i++)
				{
					System.out.print(result[i]);
				}
				System.out.println();
			}

			return;
		}


		for (int i = idx; i < num; i++)
		{
			result[d] = v[i];
			dfs(i + 1, d + 1);
		}
	}


	public static void main(String[] args) throws NumberFormatException, IOException 
	{

			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			pick = Integer.parseInt(st.nextToken());
			num = Integer.parseInt(st.nextToken());
			//cin >> pick;
			//cin >> num;

			v = new String[num];
			result = new String[num]; 
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < num; i++)
			{
				v[i] = st.nextToken();
				//cin >> v[i];
			}


			Arrays.sort(v);
			//sort(v, v + num);

/*			for (int i = 0; i < num; i++)
			{
				System.out.print(v[i]+" ");;
			}*/
			dfs(0, 0);
	}

}
