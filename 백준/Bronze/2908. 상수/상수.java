import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        char[] s = st.nextToken().toCharArray();
        String a = "";
        for(int i = s.length-1 ; i >= 0 ; i --) a += s[i];

        s = st.nextToken().toCharArray();
        String b = "";
        for(int i = s.length-1 ; i >= 0 ; i --) b += s[i];

        System.out.println(Integer.parseInt(a) > Integer.parseInt(b) ? a : b);
    }
}