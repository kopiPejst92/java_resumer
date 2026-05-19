public static class Solution {
    public int myAtoi(String s) {
        long value = 0;
        int index = 0;
        int sign;

        s = s.trim();
        if(s.isEmpty()) return 0;

        if (s.charAt(0)=='-' || s.charAt(0)=='+') {
            sign = s.charAt(0) == '-' ? -1 : 1;
            index++;
        }else{
            sign=1;
        }

        while(index<s.length()) {
            char current=s.charAt(index);
            if (!Character.isDigit(current)) break;
            else{

                value=value*10+(current-'0');
                if(sign > 0 && value>(long) Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
                }else if(sign<0 && sign* value < (long) Integer.MIN_VALUE){
                    return Integer.MIN_VALUE;
                }
                index++;
            }
        }
        return (int) (sign*value);
    }
}

void main(String[] args) {
    String[] cases={"42","   -042","1337c0d3","0-1","words and 987", " 0", " ", " -0"};

    Solution solution = new Solution();
    System.out.println(solution.myAtoi(cases[6]));
}