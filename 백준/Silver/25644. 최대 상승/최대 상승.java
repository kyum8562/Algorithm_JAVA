import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long buy = Integer.MAX_VALUE;
        long sell = Integer.MIN_VALUE;

        for (int i = 1; i <= N; i++) {
            int curr = Integer.parseInt(st.nextToken());
            sell = Math.max(sell, curr - buy);
            buy = Math.min(buy, curr);
        }
        System.out.println(sell > 0 ? sell : 0);
    }
}