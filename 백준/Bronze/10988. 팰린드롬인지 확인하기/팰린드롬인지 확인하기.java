import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int right = s.length()-1;
        for(int i = 0 ; i < s.length()/2 ; i ++){
            if(s.charAt(i) != s.charAt(right--)){
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}