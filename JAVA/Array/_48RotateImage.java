
public class _48RotateImage {

	public void rotate(int[][] matrix) {
		int n=matrix.length;
		if(n==0)
			return;
		int i,j;
		for(i=0;i<(n>>1);i++){
			for(j=0;j<n;j++){
				//swap
				int temp=matrix[i][j];
				matrix[i][j]=matrix[n-i-1][j];
				matrix[n-i-1][j]=temp;
			}
		}//for
		
		for(i=0;i<n;i++)
			for(j=i;j<n;j++){
				//swap
				int temp=matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=temp;
			}	
		/****** test ******/
//		for(i=0;i<n;i++){
//			for(j=0;j<n;j++){
//				System.out.print(matrix[i][j]+" ");
//	
//			}
//			System.out.println();
//		}
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]a={{1,2,3},{4,5,6},{7,8,9}};
		int [][]b={};
		int [][]c={{1}};
		_48RotateImage A=new _48RotateImage();
		A.rotate(c);
	}

}


//question:
		//You are given an n x n 2D matrix representing an image.
		//
		//Rotate the image by 90 degrees (clockwise).
		//
		//Follow up:
		//Could you do this in-place?