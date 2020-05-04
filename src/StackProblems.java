public class StackProblems {

	public static void main(String[] args) {

		// Do initial testing here.
		// For example, here is a basic test of the sum method:
		ArrayStack<Integer> stk = new ArrayStack<>();
		stk.push(5);
		stk.push(7);

		int[] data = { 4, 1, 2, 2, 7, 2, 8, 8, 8, 4 };
		ArrayStack<Integer> stack = new ArrayStack<>();
		for (int num : data) {
			
			stack.push(num);
		}
		ArrayStack<Integer> stack2 = StackProblems.copyStack(stack);
		
		//System.out.println("Palidrome "+ stack2.pop()+" , "+stack.pop());
		
		//System.out.println("Palidrome "+ isPalindrome("tattarrattat"));
		//System.out.println("No duplicants "+ sumSkipDuplicates(stack));

	}

	/*
	 * Computes the sum of all the numbers in the stack. It's ok to destroy the
	 * stack in the process.
	 */
	public static int sum(ArrayStack<Integer> data) {
		int sum = 0;
		while (!data.isEmpty()) {
			sum += data.pop();
		}
		return sum;
	}

	/*
	 * Puts an integer under the top item in a stack. If the stack is empty, just
	 * put the item on the top. For example: if stk starting at the top is: 7, 8, 5,
	 * 11, then pushUnder(stk, 20) would result in: 7, 20, 8, 5, 11 For example: if
	 * stk is empty, then pushUnder(stk, 20) would result in: 20
	 */
	public static void pushUnder(ArrayStack<Integer> data, int value) {
		if (!data.isEmpty()) {
			int top = data.pop();
			data.push(value);
			data.push(top);
		} else {
			data.push(value);
		}

	}

	/*
	 * Computes the sum of all the numbers in the stack. However, if two or more
	 * numbers in a row are equal, only add one of them. So, for example, if the
	 * stack contained 4, 1, 2, 2, 7, 2, 8, 8, 8, 4, then the numbers that would be
	 * added would be 4 + 1 + 2 + 7 + 2 + 8 + 4 = 28
	 */
	/**
	 * Same strategy as in linked list keep track of prev value.
	 * 
	 * @param data
	 * @return
	 */
	public static int sumSkipDuplicates(ArrayStack<Integer> data) {
		int curr = 0;
		int sum = 0;
		int prev = 0;
		while (!data.isEmpty()) {
			prev = curr;
			curr = data.pop();
			if (prev != curr) {
				
				sum += curr;
			}
		}
		return sum;
	}

	/*
	 * Puts all of the characters of a string into a stack, with the first character
	 * of the string at the bottom of the stack and the last character of the string
	 * at the top of the stack.
	 */
	public static ArrayStack<Character> stringToStack(String s) {
		ArrayStack<Character> res = new ArrayStack<Character>();
		for (int i = 0; i < s.length(); i++) {
			res.push(s.charAt(i));
		}
		return res;
	}

	/*
	 * Reverses a given stack, so that the top of the stack becomes the bottom and
	 * the bottom becomes the top. YOU MAY USE ADDITIONAL STACKS AS NEEDED BUT YOU
	 * MAY NOT USE ANY OTHER DATA STRUCTURES (no arrays, ArrayList, HashSet, etc.)
	 */
	/**
	 * Would be better use return, otherwise we need two temp stacks.....
	 * @param s
	 */
	public static void reverseStack(ArrayStack<Integer> s) {
		ArrayStack<Integer> temp = new ArrayStack<Integer>();
		ArrayStack<Integer> temp2 = new ArrayStack<Integer>();
		while (!s.isEmpty()) {
			temp.push(s.pop());
		}
		while (!temp.isEmpty()) {
			temp2.push(temp.pop());
		}
		s.clear();
		while (!temp2.isEmpty()) {
			s.push(temp2.pop());
		}
		
	}

	/*
	 * Returns an exact copy of the given stack. At the end of this method the
	 * original stack should be the same as when it started, and a new copy of that
	 * stack should be returned. YOU MAY USE ADDITIONAL STACKS AS NEEDED BUT YOU MAY
	 * NOT USE ANY OTHER DATA STRUCTURES (no arrays, ArrayList, HashSet, etc.)
	 */
	/**
	 * Copy to new stack and then call reverse, 
	 * The Method is static but it still modify the value of s ??
	 * @param s
	 * @return
	 */
	public static ArrayStack<Integer> copyStack(ArrayStack<Integer> s) {
		ArrayStack<Integer> temp = new ArrayStack<Integer>();
		ArrayStack<Integer> temp2 = new ArrayStack<Integer>();
		int val;
		while(!s.isEmpty()) {
			val=s.pop();
			temp.push(val);
			temp2.push(val);
		}
		while(!temp2.isEmpty()) {
			s.push(temp2.pop());
		}
		reverseStack(temp);
		return temp;
	}

	/*
	 * A palindrome reads the same forward and backward. Use a stack to determine if
	 * a given string is a palindrome. Challenge: try not to use any additional
	 * variables (except a counter for any loop). Just the given string and a stack
	 * of Characters.
	 */
	/**
	 * Create one stack and push elements in it, then compare the half in stack with left of the word
	 * Compare stacks when poping. hannah, stach will have 'nah' and the other part of word 'nah' so pop and compare. 
	 * Edge cases  if odd length, 
	 * 
	 * We can use two stacks, first half in one another in second and reverse it, then pop and compare values, 
	 * 
	 * @param s
	 * @return
	 */
	public static boolean isPalindrome(String s) {
		ArrayStack<Character> stack= new ArrayStack<Character>();
		int count=0;
		int halfWord=s.length()/2;
		if(s.length()%2==0) {
			while(count<halfWord) {
				stack.push(s.charAt(count));
				count++;
			}
			
			while(!stack.isEmpty()&&count<s.length()) {
				if(!stack.pop().equals(s.charAt(count))) {
					return false;
				}
				count++;
			}
		}
		return true;
	}
}
