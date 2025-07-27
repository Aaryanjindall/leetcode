import java.util.Arrays;

class Solution {
    public int minimumPushes(String word) {
        int result = 0;
        int arr[] = new int[26];

        for (char ch : word.toCharArray()) {
            arr[ch - 'a']++;
        }

        Arrays.sort(arr);  

        for (int i = 25; i >= 0; i--) {  
            if (arr[i] == 0) break;
            int press = ((25 - i) / 8) + 1; 
            result += arr[i] * press;
        }
        return result;
    }
}
