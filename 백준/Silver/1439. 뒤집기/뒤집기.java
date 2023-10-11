import java.io.*;
import java.util.*;

public class Main {
    static int sLen;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        sLen = s.length();
        arr = new int[sLen];
        for (int i = 0; i < sLen; i++)
            arr[i] = s.charAt(i) - '0';

        int cnt = play(0, 0);
        int cnt2 = play(0, 1);

        System.out.println(Math.min(cnt, cnt2));
    }

    private static int play(int idx, int type) {
        int res = 0;

        while (idx < sLen) {
            if (arr[idx] == type) {
                res ++;
                int tmp = 0;
                for (int i = idx; i < sLen; i++) {
                    if (arr[i] == type) tmp ++;
                    else break;
                }
                idx += tmp;
            }
            else idx++;
        }
        return res;
    }
}