class Solution {
    public int calculate(String s) {
         int result = 0;   // current result
        int sign = 1;     // +1 or -1
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {
                int num = 0;
                // build full number (handle multi-digit)
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + (s.charAt(i) - '0');
                    i++;
                }
                i--; // adjust index
                result += sign * num;
            } 
            else if (ch == '+') {
                sign = 1;
            } 
            else if (ch == '-') {
                sign = -1;
            } 
            else if (ch == '(') {
                // save current state
                stack.push(result);
                stack.push(sign);
                // reset for new expression
                result = 0;
                sign = 1;
            } 
            else if (ch == ')') {
                // resolve expression inside ()
                int prevSign = stack.pop();
                int prevResult = stack.pop();
                result = prevResult + (prevSign * result);
            }
        }

        return result;
    }
}