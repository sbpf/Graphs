import java.util.*;

public class KnightTour
{
	static class Cell
    {
        int row;
        int col;
        Cell(int r, int c)
        {
            this.row = r;
            this.col = c;
        }
    }
	
    static int find_minimum_number_of_moves(int rows, int cols, int start_row, int start_col, int end_row, int end_col) 
    {
        Queue<Cell> queue = new LinkedList<Cell>();
        HashMap<Cell,Integer> distance = new HashMap<Cell,Integer>();
        boolean[][] visited = new boolean[rows][cols];
        
        Cell start = new Cell(start_row,start_col);
        queue.add(start);
        distance.put(start,0);
       
        while(!queue.isEmpty())
        { 
            Cell temp = queue.remove();
            
            //If the target has been reached, return it's distance
            if(temp.row == end_row && temp.col == end_col)
                return distance.get(temp);
            
            if(visited[temp.row][temp.col])
                continue;
                 
            //add to visited set
            visited[temp.row][temp.col]= true; 
            
            int dist = distance.get(temp);
            
            //add all neighbors to the queue
            for(Cell n : getNeighbors(temp,rows,cols,visited))
            {
               if(visited[n.row][n.col])
                    continue;               
                queue.add(n);
                distance.put(n,dist+1);
            }
        }
        return -1;
    }
    
    static boolean isValidCell(int row, int col, int totalRows, int totalCols, boolean[][] visited)
    {
        if((row<0 || row>=totalRows || col<0 || col >= totalCols) || visited[row][col] == true)
            return false;
        return true;
    }
    
    static ArrayList<Cell> getNeighbors(Cell cell, int totalRows, int totalCols, boolean[][] visited)
    {
    	int r = cell.row;
        int c = cell.col;
        
        int rows[] = {1,2,2,1,-1,-2,-2,-1};
        int cols[] = {-2,-1,1,2,2,1,-1,-2};
        
        ArrayList<Cell> neighbors = new ArrayList<Cell>();
        
        for(int i=0; i<8; i++)
        {
        	if(isValidCell(r+rows[i],c+cols[i],totalRows,totalCols,visited))
        	{
        		neighbors.add(new Cell(r+rows[i],c+cols[i]));
        	}        	
        }              
        return neighbors;
    }
    
	public static void main(String[] args) 
	{	
		System.out.println(find_minimum_number_of_moves(2,7,0,5,1,1));
	}
}
