package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class threeSumClosest 
{
	
	private int cloest = Integer.MAX_VALUE;
	private boolean first = true;

    
    public int threeSumClosest(int[] num, int target) 
    {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        Arrays.sort(num);
        for(int i = 0; i <= num.length-3; i++)
        {
        	if(i!=0&&num[i]==num[i-1]) continue;//This one make sure that we do not check the same index num.
            check(num, i, num.length-1, target);
        }
        return cloest;
    }

	public void check(int[] num, int i, int end, int t) 
	{	
		int front = i+1;
		if(first)
		{
			cloest = num[i]+num[front]+num[end];
			first = false;
		}
		while(front<end)
		{
			int sum = num[i]+num[front]+num[end];
			if(Math.abs((sum-t))<Math.abs(cloest-t))
			{
				cloest = sum;
			}
			if(sum>t)
			{
				end--;
			}
			else if(sum<t)
			{
				front++;
			}
			else
			{
				cloest = sum;
				return;
			}

		}
	}
	public static void main(String[] agrs)
	{
		int num[] = {-3, -2, -5, 3, -4};
		int target = -1;
		System.out.println(new threeSumClosest().threeSumClosest(num,target));
	}
}
