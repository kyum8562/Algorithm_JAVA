import java.io.*;
import java.util.*;

public class Main {
    static int A, P, ans;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        list.add(A);
        DFS(A,0);
        System.out.println(ans);
    }

    private static void DFS(int prev, int curr) {
        while(prev != 0){
            curr += (int) Math.pow(prev%10, (double)P);
            prev /= 10;
        }
        if (list.contains(curr)) {
            ans = list.indexOf(curr);
            return;
        }

        list.add(curr);
        DFS(curr, 0);
    }
}