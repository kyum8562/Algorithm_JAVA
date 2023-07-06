import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.parseInt(st.nextToken());
        int sec = Integer.parseInt(st.nextToken()) + Integer.parseInt(br.readLine());

        int cnt = 0;
        while(sec >= 60){
            cnt ++;
            sec -= 60;
        }
        min += cnt;


        System.out.println((min >= 24 ? min-24 : min) + " " + sec);
    }
}