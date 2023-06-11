import java.util.*;
import java.io.*;

public class BJ_1406_Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = br.readLine();
		LinkedList<Character> list = new LinkedList<>();
		ListIterator<Character> listiter = list.listIterator();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < str.length(); i++) 
		{
			listiter.add(str.charAt(i));
		}
		
		int orderNum = Integer.parseInt(br.readLine());
		//int cursor = list.size();
		
		while(listiter.hasNext())
			listiter.next();
		
		while(orderNum-- > 0)//for (int o = 0; o < orderNum; o++) 
		{
			StringTokenizer st = new StringTokenizer(br.readLine());
			String order = null;
			String alphabet = null;
			
			
			if(st.countTokens() == 2)
			{
				order = st.nextToken();
				alphabet = st.nextToken();
			}
			else
				order = st.nextToken();
			
			switch (order) {
			case "L": // 커서 왼쪽으로 이동
				
				if(listiter.hasPrevious())
					listiter.previous();
				
				break;
			
			case "D": // 커서 오른쪽으로 이동
				
				if(listiter.hasNext())
					listiter.next();
				
				break;
			
			case "P": // 커서 왼쪽에 추가
				
				listiter.add(alphabet.charAt(0));
				
				break;
				
			case "B": // 커서 왼쪽에 삭제
				
				if(listiter.hasPrevious())
				{
					listiter.previous();
					listiter.remove();
				}
				
				break;
			default:
				break;
			}
			
		}
		
		
		for (char c : list) 
		{
			bw.write(c);
		}
		
		bw.flush();
		bw.close();

// sb로는 시간초과 남
/*		for (int i = 0; i < list.size(); i++) 
		{
			sb.append(list.get(i));
		}

		System.out.println(sb);*/
	}

}
