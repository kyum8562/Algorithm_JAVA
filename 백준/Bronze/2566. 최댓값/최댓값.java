import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int max = Integer.MIN_VALUE;
        int r = 0, c = 0;
        int[][] map = new int[10][10];
        for(int i = 1 ; i <= 9 ; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1 ; j <= 9 ; j ++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] > max){
                    max = map[i][j];
                    r = i;
                    c = j;
                }
            }
        }

        System.out.println(max);
        System.out.println(r + " " + c);

    }
}