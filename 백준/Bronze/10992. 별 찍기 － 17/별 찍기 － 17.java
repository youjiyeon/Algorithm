import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		// 첫 줄
		for (int i=1; i<n; i++) {
			System.out.print(" ");
		}
		System.out.println('*');
		
		// 중간 줄
		for (int i=2; i<n; i++) {
			// 앞 공백
			for (int j=n-i; j>0; j--) {
				System.out.print(" ");
			}
			System.out.print('*');
			
			// 가운데 공백
			for (int j=1; j<=2*(i-1)-1; j++) {
				System.out.print(" ");
			}
			System.out.println('*');
		}
		// 마지막 줄 (n == 1 일 경우 출력 안함)
		if (n != 1) {
			for (int i=1; i<=2*n-1; i++) {
				System.out.print('*');
			}
			System.out.println();
		}
	}
}