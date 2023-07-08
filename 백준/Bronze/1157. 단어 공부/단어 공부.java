import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().toUpperCase();
        int[] map = new int[26];
        for(int i = 0 ; i < s.length() ; i ++){
            map[s.charAt(i)-'A'] ++;
        }

        int maxVal = Integer.MIN_VALUE;
        int ans = 0;
        for(int i = 0 ; i < map.length ; i ++){
            if(map[i] > maxVal){
                maxVal = map[i];
                ans = i+'A';
            }
            else if(map[i] == maxVal) ans = 1000001;
        }
        System.out.println(ans == 1000001 ? "?" : (char)ans);
    }
}