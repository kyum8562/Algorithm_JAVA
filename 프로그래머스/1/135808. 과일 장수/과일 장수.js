function solution(k, m, score) {
    if(m > score.length) return 0;
    
    score.sort((a, b) => a - b); 
    
    let total = 0;
    while(score.length >= m){
    
        const box = score.splice(score.length - m, m);
        const price = m * Math.min(... box);
        
        total += price;
    }
    
    return total;
}