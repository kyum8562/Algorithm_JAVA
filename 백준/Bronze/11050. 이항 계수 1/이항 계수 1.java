import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int res = factorial(N) / (factorial(N-K) * factorial(K));
        System.out.println(res);
    }

    private static int factorial(int N) {
        if(N <= 1) return 1;
        return N * factorial(N-1);
    }
}