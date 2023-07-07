import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] v = new boolean[31];

        int N = 28;
        while(N-- > 0){
            int a = Integer.parseInt(br.readLine());
            v[a] = true;
        }

        for(int i = 1 ; i <= 30 ; i ++){
            if(!v[i]) System.out.println(i);
        }
    }
}