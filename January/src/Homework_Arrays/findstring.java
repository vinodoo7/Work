package Homework_Arrays;
import java.util.*;
public class findstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		String s="ecmslsv";
		int k=4;
		perform(s,k);

	}

	private static void perform(String s,int k) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<=s.length()-k;i++)
		{
			for(int j=i+k-1;j<s.length();j++)
			{
				
				
				String str=s.substring(i,j+1);
				System.out.println(str);
				break;
				
				
			}
		}
		
		
	}

}
