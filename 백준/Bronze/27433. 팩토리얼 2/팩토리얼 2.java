import java.io.*;
public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        long ans = 1;
        while(N > 0){
            ans *= N;
            N--;
        }

        System.out.println(ans);
    }
}