import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] map = new int[26];
        for(int i = 0 ; i < s.length() ; i ++){
            int curr =s.charAt(i);
            map[curr-97] ++;
        }
        for(int i = 0 ; i< 26 ; i ++)
            System.out.print(map[i]+" ");
    }
}