import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] LIS = new int[N+1];
        for(int i = 1 ; i <= N ; i ++)
            LIS[i] = i;

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++)
            arr[i] = LIS[Integer.parseInt(st.nextToken())];

        int j = 0;
        LIS[j++] = arr[0];
        for(int i = 1 ; i < N ; i ++){
            int idx = Arrays.binarySearch(LIS, 0, j, arr[i]);
            if(idx == -(j + 1)) LIS[j++] = arr[i];
            else LIS[-(idx + 1)] = arr[i];
        }

        System.out.println(j);

    }
    private static int binarySearch(int left, int right, int target){
        int mid;
        while(left < right){
            mid = (left + right) / 2;

            if(left < target) left = mid + 1;

            else right = mid;
        }
        return right;
    }
}