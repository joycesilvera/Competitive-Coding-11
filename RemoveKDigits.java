import java.util.LinkedList;

// Time Complexity: O(n), where n is the length of the input string num.
// Space Complexity: O(n), where n is the length of the input string num.

// Intuition: The problem is to remove k digits from the given number string num such that the resulting number is the smallest possible.
// We can achieve this by using a stack to maintain the digits of the resulting number.
// We will iterate through the digits of the number and for each digit, we will check if it can replace the last digit in the stack.
// If the current digit is smaller than the last digit in the stack and we still have k digits to remove, we will pop the 
// last digit from the stack.
// If the stack size is less than the length of the number minus k, we will push the current digit onto the stack.

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<Character>();

        for (char digit : num.toCharArray()) {
            while (stack.size() > 0 && k > 0 && stack.peekLast() > digit) {
                stack.removeLast();
                k -= 1;
            }
            stack.addLast(digit);
        }

        // remove the remaining digits from the tail
        for (int i = 0; i < k; ++i) {
            stack.removeLast();
        }

        // build the final string, while removing the leading zeros
        StringBuilder ret = new StringBuilder();
        boolean leadingZero = true;
        for (char digit : stack) {
            if (leadingZero && digit == '0')
                continue;
            leadingZero = false;
            ret.append(digit);
        }

        // return the final string
        if (ret.length() == 0)
            return "0";
        return ret.toString();
    }
}
