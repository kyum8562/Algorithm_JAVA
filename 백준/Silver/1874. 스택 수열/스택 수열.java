import java.io.*;
import java.util.*;

public class Main {
    static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // map에 입력을 넣어줌
        map = new int[N + 1];
        for (int i = 1; i <= N; i++)
            map[i] = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();

        int curIdx = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            stack.push(i);
            sb.append("+").append("\n");
            while (curIdx <= N && map[curIdx] == stack.peek()) {
                curIdx++;
                stack.pop();
                sb.append("-").append("\n");

                if (stack.size() == 0) break;
            }
            if (i == N && stack.size() > 0) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb);
    }
}