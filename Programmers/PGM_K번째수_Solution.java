import java.util.Arrays;

public class PGM_K번째수_Solution {
	public int[] solution(int[] array, int[][] commands) {
		System.out.println(commands.length);
		int[] answer = new int[commands.length];
		for(int i=0;i<commands.length;i++){
			int[] copy = new int[array.length];
			copy = array.clone();
			if(commands[i][0]!=commands[i][1]){
				Arrays.sort(copy,commands[i][0]-1,commands[i][1]);
				answer[i] = copy[(commands[i][0]-1)+(commands[i][2]-1)];
			}
			else{
				answer[i] = copy[commands[i][0]-1];
				System.out.println(Arrays.toString(copy));
			}
		}
		return answer;
	}
}
