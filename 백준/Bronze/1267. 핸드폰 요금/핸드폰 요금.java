import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main {
 
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m=0, y=0;
		int calling;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++) {
			calling=Integer.parseInt(st.nextToken());
			y+=(calling/30)*10;
			if(calling-calling/30!=0)
				y+=10;
			m+=(calling/60)*15;
			if(calling-calling/60!=0)
				m+=15;
		}
		if(m<y)
			System.out.println("M " + m);
		else if(m>y)
			System.out.println("Y " + y);
		else
			System.out.println("Y M "+m);
	}
}