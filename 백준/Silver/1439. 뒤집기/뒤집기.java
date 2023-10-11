import java.io.*;
import java.util.*;

public class Main {
    static int sLen;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        sLen = s.length();
        int[] arr = new int[sLen];
        for (int i = 0; i < sLen; i++) {
            arr[i] = s.charAt(i) - '0';
        }

        int cnt = 0;

        int idx = 0;
        while (idx < sLen) {
            if (arr[idx] == 0) {
                cnt ++;
                int tmp = 0;
                for (int i = idx; i < sLen; i++) {
                    if (arr[i] == 0) tmp ++;
                    else break;
                }
                idx += tmp;
            }
            else idx++;
        }

        int cnt2 = 0;
        idx = 0;
        while (idx < sLen) {
            if (arr[idx] == 1) {
                cnt2 ++;
                int tmp = 0;
                for (int i = idx; i < sLen; i++) {
                    if (arr[i] == 1) tmp ++;
                    else break;
                }
                idx += tmp;
            }
            else idx++;
        }

        System.out.println(Math.min(cnt, cnt2));
    }
}