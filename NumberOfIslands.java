//import java.util.*;

public class NumberOfIslands {

	//Given a 2-D Array, give the number of islands present in it.
	//0's represent water, 1 represent land
	
	public static int getIslands(int[][] input)
	{
		int result = 0;			
		int rows = input.length;
		int cols = input[0].length;
		boolean[][]  visited  = new boolean[rows][cols];	
		
		for(int r = 0; r<rows; r++)
		{
			for(int c=0; c<cols; c++)
			{
				if(visited[r][c] == false && input[r][c] == 1)
				{
					dfs(input,visited,r,c);
					result++;
				}
			}
		}
		return result;
	}
	
	public static void dfs(int[][] input, boolean[][] visited, int row, int col)
	{
		if(row<0 || row>=input.length || col<0 || col>= input[0].length)
			return;
		if(visited[row][col] == true)
			return;
		
		visited[row][col] = true;		
		
		if(input[row][col] == 1)
		{
			dfs(input,visited,row+1,col);
			dfs(input,visited,row,col+1);
			dfs(input,visited,row-1,col);
			dfs(input,visited,row,col-1);
		}
	}
	
	public static void main(String[] args)
	{
		/*
		0 1 1 0 0 
		0 0 1 0 0 
		0 0 1 0 0 
		1 0 0 0 0 
		1 0 0 0 0 */
		
		int[][] input = new int[5][5];
		input[0][1] = 1;
		input[0][2] = 1;
		input[1][2] = 1;
		input[2][2] = 1;
		input[3][0] = 1;
		input[4][0] = 1;
		input[2][4] = 1;
		
		System.out.println(getIslands(input));
	}

	
	//2. follow up question - surrounded by 1
	//3. new function - add land
}
