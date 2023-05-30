import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class BJ_19946_Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BigInteger val = new BigInteger(br.readLine());

		int cnt = 64;
		while(val.mod(BigInteger.valueOf(2))==BigInteger.valueOf(0)) {
			val = val.divide(BigInteger.valueOf(2));
			cnt--;
		}
		System.out.println(cnt);

	}
}
