import java.util.*;

class Solution {
    public int[] asteroidCollision(int[] ast) {

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < ast.length; i++) {

            while (!st.isEmpty() && ast[i] < 0 && st.peek() > 0) {

                int sum = st.peek() + ast[i];

                if (sum > 0) {
                    ast[i] = 0;
                }
                else if (sum < 0) {
                    st.pop();
                }
                else {
                    st.pop();
                    ast[i] = 0;
                }
            }

            if (ast[i] != 0) {
                st.push(ast[i]);
            }
        }

        int[] res = new int[st.size()];

        for (int i = st.size() - 1; i >= 0; i--) {
            res[i] = st.pop();
        }

        return res;
    }
}