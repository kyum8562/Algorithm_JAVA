package prog;

import java.util.*;

public class lv0_정수찾기 {
    public int solution(int[] arr, int n) {
        int start = 0;
        int end = arr.length - 1;
        int mid;
        Arrays.sort(arr);

        while(start <= end){
            mid = (end + start) / 2;

            if(arr[mid] == n) return 1;

            else if(arr[mid] < n) start = mid + 1;

            else end = mid - 1;
        }

        return 0;
    }
}
