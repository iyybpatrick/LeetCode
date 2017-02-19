
public class _73SetMatrixZeroes {

	public void setZeroes(int[][] matrix) {
		if(matrix[0].length==0)
			return;
        boolean row_zero=false;
        boolean rol_zero=false;
        int i,j;
        for (i=0;i<matrix.length;i++){
        	if (matrix[i][0]==0){
        		rol_zero=true; break;
        		}
        }
        for(i=0;i<matrix[0].length;i++){
        	if(matrix[0][i]==0){
        		row_zero=true;break;
        	}//if
        }//for
        
        // find rows and cols that should be set to zero.
        for(i=1;i<matrix.length;i++)
        	for(j=1;j<matrix[0].length;j++){
        		if(matrix[i][j]==0){
        			matrix[i][0]=matrix[0][j]=0;
        		}//if
        	}//for
       
        // set zero
        for(i=1;i<matrix.length;i++)
        	for(j=1;j<matrix[0].length;j++){
        		if(matrix[i][0]==0||matrix[0][j]==0)
        			matrix[i][j]=0;
        	}//for
        
        //set first row and first col to zero if needed.
        if(row_zero==true) for(i=0;i<matrix[0].length;i++) matrix[0][i]=0;
        if(rol_zero==true) for (i=0;i<matrix.length;i++) matrix[i][0]=0;  	
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_73SetMatrixZeroes A=new _73SetMatrixZeroes();
		int [][]a={{1,2,3},{4,0,5},{0,1,2}};
		int [][]a1={{}};
		int [][]a2={{1,4,6,0},{0,2,3,4},{1,3,2,3},{2,3,4,5}};
		A.setZeroes(a2);
		for(int i=0;i<a2.length;i++){
			for(int j=0;j<a2[0].length;j++)
				System.out.print(a2[i][j]+" ");
			System.out.println();
		}
	}

}

//question:
	//Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place.
