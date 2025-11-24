class Solution {
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0;
        int count10 = 0;
        int count20 = 0;

        for(int i = 0 ; i < bills.length ; i++){
            if(bills[i] == 5){
                count5++;
            }
            if(bills[i] == 10){
                if(count5 > 0){
                    count5--;
                    
                    
                }
                
                else{
                    return false;
                }
                count10++;
                
            }

            if(bills[i] == 20){
                if(count10 > 0 && count5 > 0){ // agr ek 10 aur ek 5 ka dena ho
                    count10--;
                    count5--;
                }
                 else if(count5 >= 3){ //agr teeno 5 ke dene ho 
                    count5-=3;
                }
                
                else{
                    return false;
                }
                count20++;
            }

        } 
        return true;



        
    }
}