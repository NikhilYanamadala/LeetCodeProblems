package RecursionAndDynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;

public class RobotInAGrid {
    class Point{
        int r,c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
    public ArrayList<Point> getPath(boolean[][] maze){
        if(maze==null||maze.length==0){
            return null;
        }
        ArrayList<Point> path = new ArrayList<>();
        HashSet<Point> hashSet = new HashSet<>();
//        if(getPath((maze),maze.length-1,maze[0].length-1,path)){
//            return path;
//        }
        if(getPath((maze),maze.length-1,maze[0].length-1,path,hashSet)){
            return path;
        }
       return null;
    }
//    approach 1 RT= (2^r+c)
    public boolean getPath(boolean[][] maze,int row,int column,ArrayList<Point> path){
        if(row <0||column<0||!maze[row][column]){
            return false;
        }
        boolean isAtOrigin = (row==0 && column==0);
        if(isAtOrigin || getPath(maze,row,column-1,path)||getPath(maze,row-1,column,path)){
            Point p = new Point(row,column);
            path.add(p);
            return true;
        }
        return false;
    }
//    Approach2 dynamic programming RT= (rc)
    public boolean getPath(boolean[][] maze, int row, int column, ArrayList<Point> path, HashSet<Point> hashSet){
        if(row <0||column<0||!maze[row][column]){
            return false;
        }
        Point p = new Point(row,column);
        if(hashSet.contains(p)){
            return false;
        }
        boolean isAtOrigin = (row==0 && column==0);
        if(isAtOrigin || getPath(maze,row,column-1,path)||getPath(maze,row-1,column,path)){
            path.add(p);
            return true;
        }
        hashSet.add(p);
        return false;
    }
    public static void main(String[] args) {
        RobotInAGrid robotInAGrid = new RobotInAGrid();
        boolean[][] maze = {{true,true,true},{true,true,true},{true,true,true}};
//        System.out.println(robotInAGrid.getPath(maze));
        long startTime = System.nanoTime();
        for (Point p : robotInAGrid.getPath(maze)){
            System.out.println("("+p.r+","+p.c+")");
        }
        long endTime = System.nanoTime();
        System.out.println("It took " + (endTime - startTime) + " nanoSecs");
    }
}
