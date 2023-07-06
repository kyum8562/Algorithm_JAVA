import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dice = new int[7];
        for(int i = 1 ; i <= 3 ; i ++) dice[Integer.parseInt(st.nextToken())] += 1;

        int maxIdx = 0;
        boolean flag = true;
        for(int i = 1 ; i <= 6 ; i ++){
            if(dice[i] == 3){
                System.out.println(10000 + i * 1000);
                flag = false;
                break;
            }
            else if(dice[i] == 2){
                System.out.println(1000 + i * 100);
                flag = false;
                break;
            }
            else
                if(dice[i] == 1) maxIdx = Math.max(maxIdx, i);
        }

        if(flag) System.out.println(maxIdx*100);
    }
}