let ans = cnt = 0;
let map = new Map();
function solution(s) {
    let sLen = s.length;
    ans = new Array(sLen);
    
    // console.log();
    while(cnt < sLen){
        let curr = s.charAt(cnt);
        if(map[curr] >= 0) ans[cnt] = cnt - map[curr];
        else ans[cnt] = -1;
        
        map[curr] = cnt;
        cnt++;
    }
    
    return ans;
}