import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_11966_Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int val = Integer.parseInt(br.readLine());
		int cnt = 0;
		for (int i = 0; i <= 30; i++) {
			if((val & (1<<i)) != 0){
				cnt++;
			}
			if(cnt>=2){
				System.out.println(0);
				return;
			}
		}

		System.out.println(1);

	}
}
