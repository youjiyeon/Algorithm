import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		char hangul = sc.nextLine().charAt(0);
		sc.close();

		System.out.println((int) hangul - 44031); // '가'라고 찍으면 44032가 나옴. '가'가 1이되려면 44031 빼주기

	}
}