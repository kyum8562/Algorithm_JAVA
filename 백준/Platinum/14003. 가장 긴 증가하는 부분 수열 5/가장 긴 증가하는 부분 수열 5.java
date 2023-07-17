import java.io.*;
import java.util.*;

/**
 * LIS(가장 긴 증가하는 부분 수열 5) - [이분탐색]
 * 해당 문제는 기본 LIS만 사용해서 풀 경우, 입력값이 최대 1,000,000의 큰 값이기 때문에 시간초과가 발생하는 문제이다.
 * 또한 [가장 긴 증가하는 부분 수열 2]에서 수열 A를 이루고 있는 Ai의 범위가 100만 이었지만 10억으로 증가했다. (-1,000,000,000 ≤ Ai ≤ 1,000,000,000)
 * https://www.acmicpc.net/problem/14003
 */
public class Main {
    static int N;
    static int[] arr, saveIdxArr;
    static List<Integer> list = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        saveIdxArr = new int[N];
        list.add(Integer.MIN_VALUE);

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N ; i ++){
            arr[i] = Integer.parseInt(st.nextToken());
            binarySearch(i, arr[i]);
        }

        sb.append(list.size()-1).append("\n");

        reverseTracking();

        System.out.println(sb);
    }

    private static void reverseTracking() {
        int listSize = list.size() -1;
        Stack<Integer> stack = new Stack<>();
        for(int i = N -1 ; i >= 0 ; i --){
            if(saveIdxArr[i] == listSize){
                listSize --;
                stack.push(arr[i]);
            }
        }

        while(!stack.isEmpty())
            sb.append(stack.pop()).append(" ");
    }

    private static void binarySearch(int n, int target){
        if(target > list.get(list.size()-1)){
            list.add(target);
            saveIdxArr[n] = list.size()-1;
        }
        else{
            int left = 0;
            int right = list.size()-1;

            while(left < right){
                int mid = (left + right) / 2;

                if(list.get(mid) < target) left = mid + 1;
                else right = mid;
            }
            list.set(right, target);
            saveIdxArr[n] = right;
        }
    }
}