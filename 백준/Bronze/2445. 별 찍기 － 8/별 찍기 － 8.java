import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int idx = 2*N -2;
		for(int i = 0 ; i < N ; i ++) {
			for(int j = 0 ; j < i+1 ; j++) {
				System.out.print("*");
			}
			for(int j = idx; j > 0 ; j--) {
				System.out.print(" ");
			}
			for(int j = 0 ; j < i+1 ; j++) {
				System.out.print("*");
			}
			idx-= 2;
			System.out.println();
		}
		idx = 2;
		for(int i = 1 ; i < N ; i ++) {
			for(int j = 0 ; j < N-i ; j++) {
				System.out.print("*");
			}
			for(int j = 0; j < idx ; j++) {
				System.out.print(" ");
			}
			for(int j = 0 ; j < N-i ; j++) {
				System.out.print("*");
			}
			idx+=2;
			System.out.println();
		}
	}
}