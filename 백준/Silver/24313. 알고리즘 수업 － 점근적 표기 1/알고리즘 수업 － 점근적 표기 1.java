import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int f1 = scanner.nextInt();
        int f2 = scanner.nextInt();
        int c = scanner.nextInt();
        int n = scanner.nextInt();

        int a = f1 * n + f2;
        int b = c*n;

        if (a <= b && f1 <= c){
            System.out.println(1);
        }else
        {
            System.out.println(0);
        }
    }

}