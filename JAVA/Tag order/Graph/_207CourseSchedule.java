import java.util.*;
public class _207CourseSchedule {

	public boolean canFinish(int numCourses, int[][] prerequisites) {
		if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0) return true;
		List<Integer> []graph = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++){
			graph[i] = new ArrayList<>();
		}//for
		int []degree = new int [numCourses];
 		for (int i = 0; i < prerequisites.length; i++){
			degree[prerequisites[i][1]]++;
			graph[prerequisites[i][0]].add(prerequisites[i][1]);
		}//for
 		int count = 0;
 		Queue<Integer> queue = new LinkedList<>();
 		for (int i = 0; i < numCourses; i++){
 			if (degree[i] == 0){
 				queue.offer(i);
 				count++;
 			}//if
 		}//for
 		
 		while(!queue.isEmpty()){
 			int course = queue.poll();
 			for (int i = 0; i < graph[course].size(); i++){
 				int prere = graph[course].get(i);
 				degree[prere]--;
 				if (degree[prere] == 0){
 					queue.offer(prere);
 					count++;
 				}//if
 			}//for
 		}//while
 		if (count == numCourses){
 			return true;
 		}else{
 			return false;
 		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//question:
	//There are a total of n courses you have to take, labeled from 0 to n - 1.
	//
	//Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
	//
	//Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
	//
	//For example:
	//
	//2, [[1,0]]
	//There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
	//
	//2, [[1,0],[0,1]]
	//There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
	//
	//Note:
	//The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
	//You may assume that there are no duplicate edges in the input prerequisites.