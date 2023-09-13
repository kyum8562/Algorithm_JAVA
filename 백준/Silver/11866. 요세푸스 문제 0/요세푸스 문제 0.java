import java.util.Scanner;
import java.util.LinkedList;
 
public class Main {
 
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);	
		LinkedList<Integer> list = new LinkedList<Integer>();
 
		int N = in.nextInt();
		int K = in.nextInt();
		
		for(int i = 1; i <= N; i++) {
			list.add(i);
		}
		
		
		StringBuilder sb = new StringBuilder();
		sb.append('<');
		
		int index = 0;	// 리스트에서 삭제할 요소를 참조할 인덱스 변수
		
		while(list.size() > 1) {
			index = (index + (K - 1)) % list.size();
			
			// index위치에 있는 요소를 삭제함과 동시에 출력 
			sb.append(list.remove(index)).append(", ");
		}
		
		// 마지막으로 남은 요소 삭제함과 동시에 출력
		sb.append(list.remove()).append('>');
		System.out.println(sb);
	}
}