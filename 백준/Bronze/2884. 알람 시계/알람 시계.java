import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int min = Integer.parseInt(st.nextToken());
        int sec = Integer.parseInt(st.nextToken()) - 45;

        if(sec < 0){
            sec = 60 + sec;
            if(--min < 0) min = 23;
        }

        System.out.println(min + " " + sec);
    }
}