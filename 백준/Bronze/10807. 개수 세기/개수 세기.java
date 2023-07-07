import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        map = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) map[i] = Integer.parseInt(st.nextToken());

        int tgt = Integer.parseInt(br.readLine());

        int cnt = 0;
        for (int i = 0; i < N; i++) if(map[i] == tgt) cnt ++;

        System.out.println(cnt);
    }
}