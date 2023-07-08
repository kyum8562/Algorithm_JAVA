import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] map = {0, 1, 1, 2, 2, 2, 8};
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1 ; i <= 6 ; i ++){
            map[i] -= Integer.parseInt(st.nextToken());
            System.out.print(map[i] + " ");
        }
    }
}