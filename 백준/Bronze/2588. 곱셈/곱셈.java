import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = B;
        while(B > 0){

            int tmp = B%10;
            System.out.println(A * tmp);
            B /= 10;
        }
        System.out.println(A*C);
    }
}