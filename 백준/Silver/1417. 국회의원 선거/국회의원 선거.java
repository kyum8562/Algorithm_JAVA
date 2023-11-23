import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static List<Node> list;
    static int[] map;
    static class Node{
        int cur;
        int R;
        int G;
        public Node(int cur, int R, int G){
            this.cur = cur;
            this.R = R;
            this.G = G;
        }
    }
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N-1];
        int my = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < N-1 ; i ++){
            map[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(map);
        int ans = 0;
        int idx = N-2;
        if(N >= 2){
            while(true){
                if(my > map[idx]) break;
                if(map[idx] >= my){
                    map[idx]--;
                    my++;
                    ans++;
                }
                Arrays.sort(map);
            }
        }

        System.out.println(ans);
    }
}