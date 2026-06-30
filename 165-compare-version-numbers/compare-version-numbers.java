class Solution {
    public int compareVersion(String version1, String version2) {
        String str1[] = version1.split("\\.");
        String str2[] = version2.split("\\.");
        int len = Math.max(str1.length,str2.length);
        for(int i = 0 ; i < len ; i++){
            int a = (i<str1.length)?Integer.parseInt(str1[i]):0;
            int b = (i<str2.length)?Integer.parseInt(str2[i]):0;
            if(a > b){
                return 1;
            }
            else if(a < b){
                return -1;
            }
        }
        return 0;
    }
}