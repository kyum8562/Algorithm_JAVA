import java.io.*;
import java.util.*;

public class Main {
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        map = new int[N];
        int[] ans = new int[N];
        int idx = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            map[i] = Integer.parseInt(st.nextToken());
            if(map[i] < X) ans[idx++] = map[i];
        }

        for(int i = 0 ; i < idx ; i ++) System.out.print(ans[i] + " ");
    }
}