import java.util.*;
import java.util.Stack;

// Time Complexity: O(n) where n is the number of tokens
// Space Complexity: O(n) for the stack used to store the operands

// Intuition: The problem is to evaluate a Reverse Polish Notation (RPN) expression.
// We can achieve this by using a stack to store the operands.
// When we encounter an operator, we pop the top two operands from the stack,
// perform the operation, and push the result back onto the stack.

public class ReversePolishNotation {
    Stack<Integer> stack = new Stack<>();
    Set<String> operations = new HashSet<>(Set.of("/", "+", "-", "*"));

    public int evalRPN(String[] tokens) {
        for (String s : tokens) {
            if (operations.contains(s)) {
                int num2 = stack.pop();
                int num1 = stack.pop();
                int result = 0;
                switch (s) {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1 * num2;
                        break;
                    case "/":
                        result = num1 / num2;
                        break;
                }
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }
}
