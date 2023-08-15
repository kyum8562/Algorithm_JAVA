import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static List<ArrayList<Integer>> list;
    static Queue<Integer> q = new ArrayDeque<>();
    static boolean isVisited[];
    static int N, E, start = 1;
    static StringBuilder sb;
    static int cnt = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        StringTokenizer st;
        N = stoi(br.readLine()); // 노드
        E = stoi(br.readLine()); // 간선
        
        list = new ArrayList<>();
        isVisited = new boolean[N+1];
        
        for(int i = 0 ; i <= N ; i ++) {
            list.add(new ArrayList<>());
        }
        
        for(int i = 0 ; i < E ; i ++) {
            st = new StringTokenizer(br.readLine());
            int a = stoi(st.nextToken());
            int b = stoi(st.nextToken());
            
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        dfs(start);
        System.out.println(cnt);
        
    }

    private static void dfs(int start) {
        isVisited[start] = true;
        cnt++;
        
        for(int i = 0 , size = list.get(start).size(); i < size ; i ++) {
            int tmp = list.get(start).get(i);
            if(!isVisited[tmp])
                dfs(tmp);
        }
    }
    
    static int stoi(String a) {
        return Integer.parseInt(a);
    }
}