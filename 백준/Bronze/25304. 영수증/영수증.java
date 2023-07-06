import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tgt = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int i = 1 ; i <= N ; i ++){
            st = new StringTokenizer(br.readLine());
            tgt -= Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken());
        }

        System.out.println(tgt == 0 ? "Yes" : "No");
    }
}