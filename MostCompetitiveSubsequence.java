import java.util.Stack;

// Time Complexity: O(n), where n is the length of the input array nums.
// Space Complexity: O(k), where k is the size of the most competitive subsequence we want to find.

// Intuition: The problem is to find the most competitive subsequence of size k from the given array nums.
// We can use a stack to maintain the most competitive subsequence while iterating through the array.
// The stack will help us keep track of the elements in the subsequence, ensuring that we always have the smallest elements at the top.
// We will iterate through the array and for each element, we will check if it can replace the top element of the stack.
// If the current element is smaller than the top element of the stack and we can still form a subsequence of size k,
// we will pop the top element from the stack. If the stack size is less than k, we will push the current element onto the stack.
// The final result will be the elements in the stack, which we will return as an array.
// Note: While popping, we also need to ensure that we have enough elements left in the array to fill the subsequence of size k.
public class MostCompetitiveSubsequence {
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> stack = new Stack();
        int n = nums.length;

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && nums[i] < stack.peek() && stack.size() + (n - i - 1) >= k) {
                stack.pop();
            }

            if (stack.size() < k) {
                stack.push(nums[i]);
            }

        }

        int[] result = new int[k];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop();

        }
        return result;

    }
}
