import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int cnt = 0;
        while (T-- > 0) {
            String s = br.readLine();
            boolean[] v = new boolean[26];
            boolean flag = true;
            for (int i = 0; i < s.length(); i++) {
                int curr = s.charAt(i) - 'a';

                if(v[curr]){
                    flag = false;
                    break;
                }
                v[curr] = true;

                int j = i;
                int tmp = 0;
                while(++j < s.length()){
                    if(s.charAt(j) == s.charAt(i)) tmp ++;
                    else break;
                }
                i += tmp;
            }
            if(flag) cnt++;
        }

        System.out.println(cnt);
    }
}