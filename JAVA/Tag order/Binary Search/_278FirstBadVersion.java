/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class _278FirstBadVersion {

	public int firstBadVersion(int n) {
        int start = 0;
        int end= n;
        while (start +1 < n){
        	int mid =start + (end -start)/2;
        	if (isBadVersion(mid)){
        		end = mid;
        	}else{
        		start = mid;
        	}
        }//while
        if (isBadVersion(start)){
        	return end;
        }else{
        	return start;
        }
    }
	private boolean isBadVersion(int mid) {
		// TODO Auto-generated method stub
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//question:
	//You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.
	//
	//Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.
	//
	//You are given an API bool isBadVersion(version) which will return whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.
	//
	//Credits:
	//Special thanks to @jianchao.li.fighter for adding this problem and creating all test cases.
	//
