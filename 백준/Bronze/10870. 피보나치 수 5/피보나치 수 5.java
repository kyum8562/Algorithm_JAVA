import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] fibo = new long[21];
        fibo[0] = 0;
        fibo[1] = 1;
        fibo[2] = 1;

        if (N>=3) {
            for (int i = 3; i <= N; i++) {
                fibo[i] = fibo[i - 1] + fibo[i - 2];
            }
        }
        System.out.println(fibo[N]);
    }
}