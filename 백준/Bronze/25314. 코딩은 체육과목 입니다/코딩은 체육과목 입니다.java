import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine())/4;

        for(int i = 1 ; i <= N ; i ++) sb.append("long ");
        sb.append("int");
        System.out.println(sb);
    }
}