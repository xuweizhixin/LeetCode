package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class fourSum 
{
	private ArrayList<ArrayList<Integer>> list;
	
	public ArrayList<ArrayList<Integer>> fourSum(int[] num, int target) 
    {
		list = new ArrayList<ArrayList<Integer>>();
		Arrays.sort(num);
		
		for(int i = 0; i <=num.length-4; i++)
		{
			if(i!=0&&num[i]==num[i-1]) continue;
			for(int j = i+1; j<=num.length-3; j++)
			{
				if(j!=i+1&&num[j]==num[j-1]) continue;
				check(num,i,j,num.length-1,target);
			}
		}
		return list;
    }

	private void check(int[] num, int i, int j, int end, int target) 
	{
		int front=j+1;
		while(front<end)
		{
			int sum = num[i]+num[j]+num[front]+num[end];
			if(sum<target)
			{
				front++;
			}
			else if(sum>target)
			{
				end--;
			}
			else
			{
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(num[i]);
				temp.add(num[j]);
				temp.add(num[front]);
				temp.add(num[end]);
				list.add(temp);
				front++;
				end--;
				while(front<end&&num[front]== num[front-1]) front++;
				while(front<end&&num[end]==num[end+1])end--;
			}
		}
	}
	
	public static void main(String[] agrs)
	{
		int num[] = {0,0,0,0};
		int target = 0;
		System.out.println(new fourSum().fourSum(num,target));
	}
	
}
