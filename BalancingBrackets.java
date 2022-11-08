package dsa.com.gl;
import java.util.ArrayDeque;
import java.util.Deque;

public class BalancingBrackets 
{
	static boolean areBracketsBalanced(String bracket)
		{
			Deque<Character> stack = new ArrayDeque<Character>();

			// Traversing the Expression
			for (int i = 0; i < bracket.length(); i++)
			{
				char x = bracket.charAt(i);

				if (x == '(' || x == '[' || x == '{')
				{
					// Push the element in the stack
					stack.push(x);
					continue;
				}
				if (stack.isEmpty())
					return false;
				char check;
				switch (x) {
				case ')':
					check = stack.pop();
					if (check == '{' || check == '[')
					{
						return false;
					}
					break;

				case '}':
					check = stack.pop();
					if (check == '(' || check == '[')
					{	
						return false;
					}
					break;

				case ']':
					check = stack.pop();
					if (check == '(' || check == '{')
					{
						return false;
					}
					break;
				}
			}
			// Check if Stack is empty
			return (stack.isEmpty());
		}
		public static void main(String[] args)
		{
			String bracket = "([[{}]])";
			System.out.println(bracket);
			if (areBracketsBalanced(bracket))
				System.out.println("The entered Strings has Balanced Brackets ");
			else
				System.out.println("The entered Strings do not contain Balanced Brackets ");
		}
}



