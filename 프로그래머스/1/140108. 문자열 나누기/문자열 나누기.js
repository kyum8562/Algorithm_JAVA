function solution(s) {
    let sLen = s.length;
    let left = right = cnt = same = different = ans = 0;
    let tgt = s.charAt(0);
    let flag = true;
    while(cnt < sLen){
        if(tgt == s.charAt(cnt)){
            same ++;
        }
        else different ++;
        
        if(same == different){
            left = right;
            same = different = 0;
            ans ++;
            
            if(cnt+1 < sLen) tgt = s.charAt(cnt + 1);
            else{
                flag = false;
                break;
            }
        }
        cnt++;
    }
    return flag ? ans+1: ans;
}