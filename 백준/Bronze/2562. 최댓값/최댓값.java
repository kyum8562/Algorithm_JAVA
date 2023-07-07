import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = Integer.MIN_VALUE;
        int idx = 0;
        for(int i = 1 ; i <= 9 ; i ++){
            int N = Integer.parseInt(br.readLine());
            if(N > max){
                max = N;
                idx = i;
            }
        }

        System.out.println(max);
        System.out.println(idx);
    }
}