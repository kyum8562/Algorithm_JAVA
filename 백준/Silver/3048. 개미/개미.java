import java.io.*;
import java.util.*;
public class Main {
    static int N, M;
    static char[] map;
    static Map<Character, Boolean> m;
    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N+M];
        m = new LinkedHashMap<>();
        String s = br.readLine();
        int idx = 0;
        for(int i = N-1 ; i >= 0 ; i --){
            map[idx] = s.charAt(i);
            m.put(s.charAt(idx++), true);
        }
        s = br.readLine();
        idx = 0;
        for(int i = 0 ; i < M ; i ++){
            map[idx + N] = s.charAt(i);
            m.put(s.charAt(idx++), false);
        }
        int T = Integer.parseInt(br.readLine());
        while(T -- > 0){
            for(int i = 0 ; i < N+M-1 ; i ++){
                if(m.get(map[i]) && !m.get(map[i+1])){
                    char tmp = map[i];
                    map[i] = map[i+1];
                    map[i+1] = tmp;
                    i++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < N+M ; i ++)
            sb.append(map[i]);

        System.out.println(sb);

    }
}