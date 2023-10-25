import java.io.*;
import java.util.*;
public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N]; // n개의 값을 담을 배열
        long sum = 0; // n개의 입력값의 합을 담을 변수
        Map<Integer, Integer> map = new LinkedHashMap<>(); // 최빈 값을 찾기 위해, 해당 값이 몇 개있는지 저장하는 map 자료구조
        int maxVal = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for(int i = 0 ; i < N ; i ++){
            arr[i] = Integer.parseInt(br.readLine());

            sum += arr[i];
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1); // 값 넣어줌

            // 최댓값, 최솟값 파악
            maxVal = Math.max(maxVal, arr[i]);
            minVal = Math.min(minVal, arr[i]);
        }

        // 1. 산술 평균(소수점 이하 첫째 자리에서 반올림한 값을 출력한다.)
        double avg = (double) sum / N;
        System.out.println((int) Math.round(avg));

        // 2. 중앙값
        Arrays.sort(arr); // 중앙값을 찾기 위한 정렬
        // N이 짝수일 경우
        if(N % 2 == 0){
            // 중앙값: 정렬된 arr의 N/2의 값과, (N/2)+1 값의 합을 2로 나눈 값
            long localSum = arr[N/2] + arr[(N/2)-1];
            System.out.println(localSum/2);
        }
        // N이 홀수일 경우
        else System.out.println(arr[((N+1)/2) - 1]); // 정렬된 arr의 (N+1)/2의 값

        // 3. 최빈값(여러 개 있을 때에는 최빈값 중 두 번째로 작은 값을 출력한다.)
        int threeVal = Integer.MIN_VALUE; //  최빈값은 몇번 카운트 되었는지
        for(int i: map.keySet()){
            int curr = map.get(i);
            threeVal = Math.max(threeVal, curr);
        }
        // threeVal과 동일한 개수는?
        List<Integer> list = new ArrayList<>();
        for(int i: map.keySet()){
            if(threeVal == map.get(i)) list.add(i);
        }
        // 1개면 바로 출력
        if(list.size() == 1) System.out.println(list.get(0));
        // 2개 이상이면 두번째로 작은 수 출력
        else{
            Collections.sort(list);
            System.out.println(list.get(1));
        }

        // 4. 범위(최댓값 - 최솟값)
        System.out.println(maxVal - minVal);
    }
}