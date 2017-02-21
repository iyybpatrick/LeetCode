import java.util.*;
public class _30SubstringWithConcatenationOfAllWords {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> result=new ArrayList<Integer>();
		if(s==null||words==null||words.length==0){
        return null;
        }//if
		int len=words.length;
		int word_len=words[0].length();
		Map<String,Integer> map=new HashMap<String,Integer>();
		
		// add words string to map
		for (int i=0;i<len;i++){
			if(map.containsKey(words[i])){
				map.put(words[i], map.get(words[i])+1);
			}//if
			else{
				map.put(words[i], 1);
			}
		}//for
		
		// out layer for is the number of times for searching
		for(int i=0;i<s.length()-word_len*len+1;i++){
			Map<String,Integer> copy=new HashMap<String,Integer>(map);
			for(int j=0;j<words.length;j++){
				String sub=s.substring(i+j*word_len,i+j*word_len+word_len);
				if(copy.containsKey(sub)){
					int count=copy.get(sub);
					if(count==1){
						copy.remove(sub);
					}
					else{
						copy.put(sub, count-1);
					}//else
					if(copy.isEmpty()){
						result.add(i);
						break;
					}
				}//if
				else break;
			}//for
		}//for
		return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,Integer> map=new HashMap<String,Integer>();
		_30SubstringWithConcatenationOfAllWords A=new _30SubstringWithConcatenationOfAllWords();
		String s="qwezxcasdqwezxc";
		String words[]={"qwe","asd","zxc"};
		List<Integer> result=A.findSubstring(s, words);
		System.out.println(result);
	}

}
