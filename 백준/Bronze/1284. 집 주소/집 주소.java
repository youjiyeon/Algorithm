import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//무한루프
		while (true) {
			String N = br.readLine();
			int length = 1;
			//N이 0이면 반복분을 끝낸다.
			if(N.equals("0")) {
				break;
			}
			for (int i = 0; i < N.length(); i++) {
				if (N.charAt(i) == '1') {
					length += 3;
				}
                else if (N.charAt(i) == '0') {
					length += 5;
				}
                else {
					length += 4;
				}
			}
			System.out.println(length);
		}
	}
}