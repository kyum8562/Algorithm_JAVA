

let map = {};
function solution(X, Y) {
    let s = "";
    // 1. x의 값을 분해해서 map에 저장해둠
    for(let i = 0 ; i <X.length ; i ++){
        if(map[X[i]] === undefined) map[X[i]] = 1;
        else map[X[i]]++;
    }
    // 2. y를 순회하며, 해당 값이 존재할 경우 String에 넣어줌
    for(let i = 0 ; i <Y.length ; i ++){
        if(map[Y[i]] >= 1){
            map[Y[i]]--;
            s += Y[i];
        }
    }
    // 3-1. 공통 값이 없다면 "-1" 리턴
    if(s.length == 0) return "-1";
    else if(s - 0 == 0) return "0";
    // 3-2. 해당 스트링을 내림차순으로 정렬 후 리턴
    else{
        return (s.split("").sort((a,b) => b-a).join(""));
    }
    return answer;
}