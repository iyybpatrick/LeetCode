import java.util.*;
public class _383RansomNote {

	public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine==null ||magazine.length()<ransomNote.length()){
        	return false;
        }
        int len_note=ransomNote.length();
        int len_mag=magazine.length();
        Map<Character,Integer> map=new HashMap<Character,Integer>();
        //put all keys into map.
        for (int i=0;i<len_mag;i++){
        	char temp=magazine.charAt(i);
        	if(map.containsKey(temp)){
        		map.put(temp, map.get(temp)+1);
        	}//if
        	else{
        		map.put(temp, 1);
        	}
        }//for
        
        for (int i=0;i<len_note;i++){
        	char temp=ransomNote.charAt(i);
        	if (map.containsKey(temp)) {
        		// remove key from map
        		if (map.get(temp)==1){
        			map.remove(temp);
        		}//if
        		else {
        			map.put(temp, map.get(temp)-1);
        		}
        	}//if
        	else{
        		return false;
        	}//else
        }//for
        return true;
        	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_383RansomNote A=new _383RansomNote();
		String ransomNote ="asdfghjkl;'zxcv";
		String magazine="/.vcasdfgh;j'klzx";
		System.out.print(A.canConstruct(ransomNote, magazine));
	}

}

//question:
	//Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.
	//
	//Each letter in the magazine string can only be used once in your ransom note.
	//
	//Note:
	//You may assume that both strings contain only lowercase letters.
	//
	//canConstruct("a", "b") -> false
	//canConstruct("aa", "ab") -> false
	//canConstruct("aa", "aab") -> true