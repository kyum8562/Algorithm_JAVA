import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] v = new int[26];
        Arrays.fill(v, -1);

        char[] s = br.readLine().toCharArray();
        for(int i = 0 ; i < s.length ; i ++){
            int idx = s[i]-'a';
            if(v[idx] == -1) v[idx] = i;
        }

        for(int i: v) sb.append(i).append(" ");
        System.out.print(sb);
    }
}