import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] map = new int[N];
        for(int i = 0 ; i < N ; i ++)
            map[i] = Integer.parseInt(br.readLine());

        int max = map[N-1];
        int idx = 1;
        for(int i = N-2 ; i >= 0 ; i --){
            if(map[i] > max){
                max = map[i];
                idx++;
            }
        }
        System.out.println(idx);
    }
}