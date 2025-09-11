class Solution {
    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int steps = 0;
        
        while(sb.length() > 1){
            int lsb = sb.length() -1;
            if(sb.charAt(lsb) == '0'){
                sb.deleteCharAt(lsb);
            }
            else{
                int iter = sb.length()-1;
                while(iter >= 0 && sb.charAt(iter) == '1'){
                    sb.setCharAt(iter,'0');
                    iter--;
                }
                if(iter >= 0){
                    sb.setCharAt(iter,'1');
                }
                else{
                    sb.insert(0,'1');
                }

            }

            steps++;
        }

        return steps;

    }
}