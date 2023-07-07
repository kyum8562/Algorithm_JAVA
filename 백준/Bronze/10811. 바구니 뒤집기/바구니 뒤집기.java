import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        for(int i = 1 ; i <= N ; i ++) arr[i] = i;

        for(int i = 1 ; i <= M ; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = b;

            int cnt = 0;
            int tgtCnt = (b-a+1)/2;
            for(int j = a ; j <= b; j ++){
                if(cnt++ == tgtCnt) break;
                int tmp = arr[j];
                arr[j] = arr[c];
                arr[c--] = tmp;
            }
        }

        for(int i = 1 ; i <= N ; i ++) System.out.print(arr[i] + " ");


    }
}