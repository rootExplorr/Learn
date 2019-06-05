package practise.leetcode;

public class LongestIncreasingPath {
    int directions[][]=new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
    int maxLength;
    public static void main(String[] args) {
		int matrix[][]=new int[][]{{9,9,4},{6,6,8},{2,1,1}} ;
		new LongestIncreasingPath().longestIncreasingPath(matrix);
	}
    public int longestIncreasingPath(int[][] matrix) {
        return longestIncreasingPathHelper(matrix,-1,-1,0,0);
    }
    public int longestIncreasingPathHelper(int[][] matrix,int pR,int pC,int cR,int cC) {
        int length=-1,tmp;
        boolean flag=false;
        for(int i=0;i<directions.length;i++){
            int r=cR+directions[i][0];
            int c=cC+directions[i][1];
            
            /*if(r==pR && c==pC)
                continue;*/
            if(r>=0 && c>=0 && r<matrix.length && c<matrix.length){
                if(matrix[r][c]<=matrix[cR][cC])
                    continue;
                flag=true;
                //System.out.println(cR+","+cC);
            tmp = 1+longestIncreasingPathHelper(matrix,cR,cC,r,c);
            if(length<tmp)
               length=tmp;
            }
        }
        int r=cR,c=cC;
        if(!flag){
            if(cC==matrix.length-1)
                cC=0;
            else cC++;
            // if(cC==matrix.length-1)
            //     cR=;
            return longestIncreasingPathHelper(matrix,r,c,cR,cC);            
        }
        return length;
    }
}