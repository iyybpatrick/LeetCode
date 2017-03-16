import java.util.*;
public class _187RepeatedDNASequences {

	public List<String> findRepeatedDnaSequences(String s) {
        //List<String> res = new LinkedList<>();
        if (s == null || s.length() <= 10) return null;
        Set<String> res = new HashSet<>() ,set = new HashSet<>();
        for (int i = 0; i < s.length() - 9; i++){
        	String sub = s.substring(i, i + 10);
        	if (set.contains(sub)){
        		res.add(sub);
        	}else{
        		set.add(sub);
        	}
        }
        return new ArrayList(res);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_187RepeatedDNASequences A =new _187RepeatedDNASequences();
		String s= "AAAAAAAAAAAAA";
		List<String> res = A.findRepeatedDnaSequences(s);
		System.out.println(res);
	}

}

//question:
	//All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
	//
	//Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
	//
	//For example,
	//
	//Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
	//
	//Return:
	//["AAAAACCCCC", "CCCCCAAAAA"].