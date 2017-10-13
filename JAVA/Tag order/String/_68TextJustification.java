import java.util.*;
public class _68TextJustification {
	
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> res=new LinkedList<String>();
        if(words==null) return res;
        int index=0;
        while(index<words.length){
        	int last=index+1;
        	int count=words[index].length();
        	while(last<words.length){
        		if(words[last].length()+1+count>maxWidth) break;
        		count+=words[last].length()+1;
        		last++;
        	}//while
        	
        	StringBuilder str=new StringBuilder();
        	int interval=last-index-1;
        	if(last==words.length || count==maxWidth || interval==0){
        		for( int i=index; i<last; i++){
        			str.append(words[i]+" ");
        		}//for
        			str.deleteCharAt(str.length()-1);
        			for (int i=str.length(); i<maxWidth; i++){
        				str.append(" ");
        			}//for
        	}//if
        	else{
        		int ave_space=(( maxWidth - count)/interval) + 1;
        		int remain= ( maxWidth - count) %interval;
        		
        		//do not include last word of this line.
        		for( int i=index; i<last-1; i++){
        			str.append(words[i]);
        			for(int j=0; j< ave_space+ (( i-index)<remain ? 1:0) ;j++){
        				str.append(" ");
        			}//for
        		}//for
        		str.append(words[last-1]);
        	}//else if
        	res.add(str.toString());
        	index=last;
        }//while
	return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String [] words={"12","22","445","2442","asdfdfsd"};
		String [] words1={"this","is","an","example","of","text","justification"};
		
		_68TextJustification A=new _68TextJustification();
		List<String> res=A.fullJustify(words1, 16);
		System.out.println(res);
	}

}

//question:
	//Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.
	//
	//You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.
	//
	//Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
	//
	//For the last line of text, it should be left justified and no extra space is inserted between words.
	//
	//For example,
	//words: ["This", "is", "an", "example", "of", "text", "justification."]
	//L: 16.
	//
	//Return the formatted lines as:
	//[
	//   "This    is    an",
	//   "example  of text",
	//   "justification.  "
	//]
