import java.io.*;
import java.util.*;
public class Main {
    static int res = Integer.MAX_VALUE, v1, v2, v3;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 300, 60, 10
        play(N, 0, 0, 0, 0);
        System.out.println(res == Integer.MAX_VALUE ? -1 : v1 + " " + v2 + " " + v3);
    }

    private static void play(int n, int cnt, int a, int b, int c) {
        if(n <= 0){
            if(n == 0 && res > cnt){
                res = Math.min(res, cnt);
                v1 = a;
                v2 = b;
                v3 = c;
            }
            return;
        }

        if(n/300 >= 1){
            int tmp = n/300;
            play(n%300, cnt + tmp, a+ tmp, b, c);
        }
        if(n/60 >= 1){
            int tmp = n/60;
            play(n%60, cnt + tmp, a, b + tmp, c);
        }
        if(n/10 >= 1){
            int tmp = n/10;
            play(n%10, cnt + tmp, a, b, c + tmp);
        }
    }
}