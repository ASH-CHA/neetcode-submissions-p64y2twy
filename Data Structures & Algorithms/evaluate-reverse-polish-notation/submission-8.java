class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Stack<Long> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            if(tokens[i].length() == 1 && tokens[i].charAt(0) < 48){
                long int2 = stack.pop();
                long int1 = stack.pop();
                char operator = tokens[i].charAt(0);

                long resolvedAns = resolve(int1, int2, operator);
                stack.push(resolvedAns);
            }
            else stack.push(Long.parseLong(tokens[i]));
        }
        return stack.pop().intValue();
    }

    private long resolve(long a, long b, char operator){
        if(operator == '+') return a + b;
        else if(operator == '-') return a - b;
        else if(operator == '*') return a * b;
        return a / b;
    }
}
