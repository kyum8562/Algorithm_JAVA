function solution(cards1, cards2, goal) {
    let answer = 'Yes';
    let c1Idx = c2Idx = 0;
    for(let i = 0 ; i < goal.length ; i ++){
        let v = goal[i];
        
        if(cards1[c1Idx] === v){
            c1Idx++;
            continue;
        }
        if(cards2[c2Idx] === v){
            c2Idx++;
            continue;
        }
        answer = 'No';
        break;
    };
    
    return answer;
    
}