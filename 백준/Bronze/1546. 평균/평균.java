import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N+1];

        double max = Integer.MIN_VALUE;
        st = new StringTokenizer(br.readLine());;
        for(int i = 1 ; i <= N ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(arr[i], max);
        }

        double sum = 0;
        for(int i = 1 ; i <= N ; i ++){
            arr[i] = (arr[i]/max)*100;
            sum += arr[i];
        }

        System.out.println(sum/N);
    }
}