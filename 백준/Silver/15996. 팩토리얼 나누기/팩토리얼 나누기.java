import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		for(int i = A ; N/i>=1 ; i*=A) {
			ans += N/i;
		}
		System.out.println(ans);
		br.close();
		
	}
}