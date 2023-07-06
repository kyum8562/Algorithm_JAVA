import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        if(N > 0 && M > 0) System.out.println(1);
        else if(N < 0 && M > 0) System.out.println(2);
        else if(N < 0 && M < 0) System.out.println(3);
        else System.out.println(4);
    }
}