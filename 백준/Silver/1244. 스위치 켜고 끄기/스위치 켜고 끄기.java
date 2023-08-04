import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		// 스위치 개수 입력
		int num = Integer.parseInt(br.readLine());
		// 스위치 받을 배열 -> 0번째 인덱스 사용x num+1 크기의 배열 생성
		int[] arr = new int[num+1];
		// 각 스위치 입력
		String s = br.readLine();
		// 입력받은 line 잘라서 배열에 넣기
		st = new StringTokenizer(s, " ");
		for(int i = 1 ; i < arr.length; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 학생 수 입력
		int personNum = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < personNum ; i ++) {
			// 해당 학생의 성별, 숫자 입력
			st = new StringTokenizer(br.readLine(), " ");
			// 성별 확인
			int sex = Integer.parseInt(st.nextToken());
			// 학생이 받은 숫자
			int target = Integer.parseInt(st.nextToken());
			
			// 남자, target의 배수 스위치에 해당하는 값을 변경함
			if(sex == 1) {
				for(int j = 1 ; j < arr.length ; j ++) {
					if(j%target == 0)
						arr[j] = (arr[j] == 0) ? 1 : 0;
				}
			}
			// 여자
			else {
				// 포인터 생성해서 옆의 값 비교
				int p = 1;
				arr[target] = (arr[target] == 0) ? 1 : 0;
				while(true) {
					if(target - p > 0 && target + p < arr.length && arr[target-p] == arr[target+p]) {
						arr[target-p] = (arr[target-p] == 0) ? 1 : 0;
						arr[target+p] = (arr[target+p] == 0) ? 1 : 0;
						p++;
					}
					else 
						break;
				}
			}
		}
		for(int j = 1 ; j < arr.length; j++) {
			System.out.print(arr[j] + " ");
			if(j % 20 == 0)
				System.out.println();
		}
	}
}