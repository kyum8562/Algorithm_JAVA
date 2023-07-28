import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long sum = 0;
        if (N == 1 | N == 2 ) {
            System.out.println(1);
            return;
        }
        for (int i = 0; i < N; i++) {
            sum += i;
            if (sum > N) {
                System.out.println(i-1);
                break;
            } else if (sum==N) {
                System.out.println(i);
                break;
            }
        }
    }
}