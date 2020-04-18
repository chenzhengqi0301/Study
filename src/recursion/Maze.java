package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Maze {
    public int[][]a=new int[8][8];
    public static int count;
    public Stack stack=new Stack();

    public Maze() {
        for(int i=0;i<8;i++){
            a[0][i]=1;
            a[7][i]=1;
            a[i][0]=1;
            a[i][7]=1;
        }
        a[3][1]=1;
        a[3][2]=1;
//        a[3][4]=1;
//        a[3][5]=1;
//        a[2][5]=1;
//        a[4][5]=1;
//        a[5][3]=1;
//        a[6][5]=1;
//        版本测试
    }

    public boolean go(int m,int n){
        if(a[6][6]==2){
            count++;
            a[6][6]=0;
            System.out.println(stack);
            return true;
        }else if(a[m][n]==0){
            a[m][n]=2;
            stack.add("("+m+","+n+")");
            go(m+1,n);
            go(m,n+1);
            go(m-1,n);
            go(m,n-1);
            a[m][n]=0;
            stack.pop();
            return false;
        }else{
            return false;
        }
    }

    public void print(){
        for (int i=0;i<8;i++){
            for(int t=0;t<8;t++){
                System.out.print(a[i][t]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Maze maze=new Maze();
        maze.go(1,1);
        maze.print();
        System.out.println("count="+Maze.count);
    }


}
