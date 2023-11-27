import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int stage = 0;
        int i = 0;
        int ans = 0;
        while(stage ++ < 8){
            String s = br.readLine();
            int j = i;
            while(j < 8){
                if(s.charAt(j) == 'F') ans ++;
                j += 2;
            }
            i = i == 0 ? 1 : 0;
        }
        System.out.println(ans);
    }
}