import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_14681_Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = Integer.parseInt(br.readLine());
		int j = Integer.parseInt(br.readLine());

		// x좌표가 양수
		if(i>0){
			// y좌표가 양수 -> 1
			if(j>0){
				System.out.println(1);
			}
			else
				System.out.println(4);
		}
		else {
			// y좌표가 양수 -> 2
			if(j>0){
				System.out.println(2);
			}
			else
				System.out.println(3);
		}

	}
}
