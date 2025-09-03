class Solution {
    public String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();

        for (char ch : order.toCharArray()) {
            for (char sc : s.toCharArray()) {
                if (ch == sc) {
                    sb.append(sc);
                }
            }
        }
        
        
        for (char sc : s.toCharArray()) {
            if (order.indexOf(sc) == -1) {
                sb.append(sc);
            }
        }
        
        return sb.toString();
    }
}
