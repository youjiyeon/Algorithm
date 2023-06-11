

import java.io.*;
import java.util.*;

public class BJ_11000_Main {

	static int cnt = 0;
	static boolean visit[];
	static class Meeting implements Comparable<Meeting>{
		int start, end; // 회의 시작, 종료 시간
		
		public Meeting(int start, int end)
		{
			super();
			this.start = start;
			this.end = end;
		}
		
		// 종료 시간 기준 오름차순
		// 종료 시간이 같다면 시작 시간 기준 오름차순
		@Override
		public int compareTo(Meeting o)
		{
			return this.end != o.end ? this.end - o.end : this.start - o.start;
		}
	}
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		
		Meeting[] meetings = new Meeting[N];
		visit = new boolean[N];
		
		for (int i = 0; i < N; i++) 
		{
			st = new StringTokenizer(br.readLine());
			meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		
		for (int i = 0; i < N; i++) 
		{
			if(!visit[i])
			{
				getSchedule(meetings,i);
				cnt++;
			}
		}
		bw.write(String.valueOf(cnt));
		
		bw.flush();
		bw.close();
		//System.out.println(cnt);
	}


	private static void getSchedule(Meeting[] meetings, int start) {
		// 모든 회의를 종료 시간 기준 오름차순
		// 종료 시간이 같다면 시작 시간 기준 오름차순
		
		List<Meeting> result = new ArrayList<>();
		Arrays.sort(meetings);
		//  첫 회의 스케줄에 추가
		result.add(meetings[start]);
		visit[start] = true;
		
		for (int i = 1, size = meetings.length; i < size; i++) 
		{
			// 마지막 회의의 종료 시간이 비교할? 대상의 회의 시작 시간보다 작거나 같다면
			if(result.get(result.size()-1).end <= meetings[i].start)
			{
				result.add(meetings[i]);
				visit[i] = true;
			}
		}
		
		
		
	}

}
