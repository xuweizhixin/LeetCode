package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum 
{
	private ArrayList<ArrayList<Integer>> list;
    
    public ArrayList<ArrayList<Integer>> threeSum(int[] num) 
    {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        list = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(num);
        for(int i = 0; i <= num.length-3; i++)
        {
        	if(i!=0&&num[i]==num[i-1]) continue;//This one make sure that we do not check the same index num.
            check(num, i, num.length-1);
        }
        return list;
    }

	public void check(int[] num, int i, int end) 
	{	
		int front = i+1;
		while(front<end)
		{
			if(-num[i] < num[front]+ num[end])
			{
				end--;
			}
			else if(-num[i] > num[front]+ num[end])
			{
				front++;
			}
			else//when they are equal
			{
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(num[i]);
				temp.add(num[front]);
				temp.add(num[end]);
				list.add(temp);
				front++;
				end--;
				//The following make sure that the set never get duplicated//
				while(front<end&&num[front]==num[front-1])
				{
					front++;
				}
				while(front < end&&num[end] == num[end+1])
				{
					end--;
				}
			}
		}
	}
	public static void main(String[] agrs)
	{
		int num[] = {-1,0,1,2,-1,-4};
		System.out.println(new ThreeSum().threeSum(num));
	}
}
