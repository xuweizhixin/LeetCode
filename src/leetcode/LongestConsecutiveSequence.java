package leetcode;

import java.util.HashMap;

public class LongestConsecutiveSequence 
{
	public static int longestConsecutive(int[] num) 
    {
		int max = 1;
		int count = 0;
		HashMap<Integer, Integer>cache = new HashMap<Integer, Integer>();
	
		for(int i = 0; i <num.length; i++)
		{
			cache.put(num[i], 1);
		}
		for(int i = -10000; i <10000;i++)
		{
			if(cache.containsKey(i)) count++;
			else
			{
				if(count > max)
				{
					max = count;
					count = 0;
				}
				else count = 0;
			}
		}
		return max;
    }
	public static void main(String[] args)
	{
		int[] a = {1,3,5,2,4};
		System.out.print(longestConsecutive(a));
	}
}
