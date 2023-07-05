import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int ans = (A%4 == 0 && (A%100 != 0 || A%400 == 0)) ? 1 : 0;
        System.out.println(ans);
    }
}