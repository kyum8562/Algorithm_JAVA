import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] map = new int[2*N];
        int[] sumMap = new int[2*N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++){
            int tmp = Integer.parseInt(st.nextToken());
            map[i] = tmp;
            map[i+N] = tmp;

        }

        for(int i = 0 ; i < 2*N ; i ++){
            if(i ==0) sumMap[i] = map[i];
            else sumMap[i] = sumMap[i-1] + map[i];
        }

        int l = 0;
        int r = M;
        int ans = Integer.MIN_VALUE;
        while(r < 2*N){
            int tmp = sumMap[r++] - sumMap[l++];
            if(l == r) tmp /= 2;
            ans = Math.max(ans, tmp);
        }

        System.out.println(ans);
    }
}