
public class ContainerWithMostWater {

	public int maxArea(int[] height) {
       int len=height.length;
       if(len==1)
    	   return height[0];
       int cur_max=0;
       int max=0;
       int i=0,j=len-1;
       for(;i<j;){
    	   // left pointer move right
    	   if(height[i]<height[j]){
    		   cur_max=(j-i)*height[i];
    		   i++;
    	   }//if
    	   
    	   // right pointer move left
    	   else{
    		   cur_max=(j-i)*height[j];
    		   j--;
    	   }//else
    	   if(cur_max>max){
			   max=cur_max;
		   }//if
       }//for
       return max;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContainerWithMostWater A=new ContainerWithMostWater();
		int []a={2,3,1,4,2};
		int max=A.maxArea(a);
		System.out.println(max);
	}

}
