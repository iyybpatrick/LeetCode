import java.util.*;
public class _126WordLadderII {

	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> res = new LinkedList<>();
        if (wordList == null) return res;
        Map<String, List<String>> map = new HashMap<>();
        Queue<String> queue= new LinkedList<>();
        Map<String, Integer> ladder = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (String str : wordList){
        	ladder.put(str, Integer.MAX_VALUE);
        }
        ladder.put(beginWord, 0);
        queue.offer(beginWord);
        if (wordList.contains(endWord)){
        	wordList.add(endWord);
        }
        while (!queue.isEmpty()){
        	String cur = queue.poll();
        	int step = ladder.get(cur) + 1;
        	if (step > min) break;
        	
        	for (int i = 0; i < cur.length(); i++){
        		StringBuilder temp = new StringBuilder(cur);
        		for (char ch = 'a'; ch <= 'z'; ch++){
        			temp.setCharAt(i, ch);
        			String newWord = temp.toString();
        			if (ladder.containsKey(newWord)){
        				if (step > ladder.get(newWord)){
        					continue;
        				}else if (step < ladder.get(newWord)){
        					queue.offer(newWord);
        					ladder.put(newWord, step);
        				}else;
        			}//if
        			
        			if (map.containsKey(newWord)){
        				map.get(newWord).add(cur);
        			}else{
        				List<String> list = new LinkedList<>();
        				list.add(cur);
        				map.put(newWord, list);
        			}
        			
        			if (newWord == endWord){
        				min = step;
        			}
        		}//for ch
        	}//for i 
        }//while
        List<String> path = new ArrayList<>();
        backTracking(res, map, path, beginWord, endWord);
        return res;
        
    }
	private void backTracking(List<List<String>> res, Map<String, List<String>> map, List<String> path, String beginWord, String endWord) {
		// TODO Auto-generated method stub
		if (endWord.equals(beginWord)){
			path.add(0, beginWord);
			res.add(new LinkedList<>(path));
			path.remove(0);
			return;
		}
		path.add(0, endWord);
		if (map.containsKey(endWord)){
			for (String str : map.get(endWord)){
				backTracking(res, map, path, beginWord, str);
			}
		}//of
		path.remove(0);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_126WordLadderII A = new _126WordLadderII();
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = new LinkedList<>();
		wordList.add("hot");
		wordList.add("dot");
		wordList.add("dog");
		wordList.add("lot");
		wordList.add("log");
		wordList.add("cog");
		 List<List<String>>  res = A.findLadders(beginWord, endWord, wordList);
		 System.out.println(res);
	}

}

//question:
	//Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
	//
	//Only one letter can be changed at a time
	//Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
	//For example,
	//
	//Given:
	//beginWord = "hit"
	//endWord = "cog"
	//wordList = ["hot","dot","dog","lot","log","cog"]
	//Return
	//  [
	//    ["hit","hot","dot","dog","cog"],
	//    ["hit","hot","lot","log","cog"]
	//  ]
	//Note:
	//Return an empty list if there is no such transformation sequence.
	//All words have the same length.
	//All words contain only lowercase alphabetic characters.
	//You may assume no duplicates in the word list.
	//You may assume beginWord and endWord are non-empty and are not the same.
	//UPDATE (2017/1/20):
	//The wordList parameter had been changed to a list of strings (instead of a set of strings). Please reload the code definition to get the latest changes.