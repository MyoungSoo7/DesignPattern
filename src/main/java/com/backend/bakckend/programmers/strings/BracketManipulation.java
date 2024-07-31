tpackage com.backend.bakckend.programmers.strings;

public class BracketManipulation {
    boolean solution(String s) {

        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                count++;
            } else if (c == ')') {
                count--;
            }

            if (count < 0) {
                return false;
            }
        }

        return count == 0;
    }



    public static void main(String[] args) {
        BracketManipulation bracketManipulation = new BracketManipulation();
        boolean result = bracketManipulation.solution("()()");
        System.out.println(result);
    }
}
