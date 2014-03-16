package leetcode;

import java.util.Stack;

public class Evaluate_Reverse_Polish_Notation 
{
	public static int evalRPN(String[] tokens) 
    {
		Stack<Integer> s = new Stack<Integer>();
		String ans = "";
		for(int i = 0; i <tokens.length; i++)
		{
			
			if(tokens[i] == "+")
			{
				int op1 = s.pop();
				int op2 = s.pop();
				int res = op2+op1;
				s.push(res);
			}
			else if(tokens[i] == "-")
			{
				int op1 = s.pop();
				int op2 = s.pop();
				int res = op2-op1;
				s.push(res);
				
			}
			else if(tokens[i] == "*")
			{
				int op1 = s.pop();
				int op2 = s.pop();
				int res = op2*op1;
				s.push(res);
				
			}
			else if(tokens[i] == "/")
			{
				int op1 = s.pop();
				int op2 = s.pop();
				int res = op2/op1;
				s.push(res);
			}
			else
			{
				s.push(Integer.parseInt(tokens[i]));
			}
		}		
		return s.pop();
    }
	public static void main(String[] args)
	{
		String[] test = {"4", "13", "5", "/", "+"};
		System.out.print(evalRPN(test));
	}
	
}
