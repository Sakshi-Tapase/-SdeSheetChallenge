import java.util.*;
public class Solution {

	public static void sortStack(Stack<Integer> stack) {
        if(!stack.empty())
        {   
		// Write your code here.
         Stack<Integer> temp=new Stack<>();
        while(!stack.empty())
        {
            int greater;
            if(temp.empty() || stack.peek()<=temp.peek())
            {
                temp.push(stack.peek());
                stack.pop();
            }
            else
            {
                greater=stack.peek();
                stack.pop();
                while(!temp.empty())
                {
                    if(temp.peek()>=greater)
                    {
                        stack.push(greater);
                        while (!temp.empty())
                        {stack.push(temp.peek());
                        temp.pop();}
                    }
                    else
                    {
                        stack.push(temp.peek());
                        temp.pop();
                    }
                }
                if(greater>stack.peek())
                    stack.push(greater);
            }
        }
        while (!temp.empty())
        {
            stack.push(temp.peek());
            temp.pop();
        }
        }
	}

}
