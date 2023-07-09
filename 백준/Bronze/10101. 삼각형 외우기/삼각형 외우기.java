import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int[] arr = new int[3];
        boolean flag1 = false;
        boolean flag2 = true;
        for(int i = 0 ; i < 3 ; i ++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp != 60) flag2 = false;
            for(int j = 0 ; j <= i ; j ++){
                if(arr[j] == tmp) flag1 = true;
            }
            arr[i] = tmp;
            sum += tmp;
        }
        if(flag2) System.out.println("Equilateral");
        else if(sum != 180) System.out.println("Error");
        else if(sum == 180){
            if(flag1) System.out.println("Isosceles");
            else System.out.println("Scalene");
        }
    }
}