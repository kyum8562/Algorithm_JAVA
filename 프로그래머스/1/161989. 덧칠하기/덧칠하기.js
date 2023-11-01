function solution(n, m, section) {
    let answer = 0;
    let painting = 0;
    section.forEach((v) => {
        
        if(v > painting){
            painting = v + m -1;
            console.log(painting);
            answer++;
        }
    })
    return answer;
}