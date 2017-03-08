import java.util.*;
public class _207CourseSchedule {

	// DFS method 
//	public boolean canFinish(int numCourses, int[][] prerequisites) {
//		if (prerequisites == null || prerequisites.length == 0 || prerequisites[0].length == 0){
//			return true;
//		}
//		boolean []visited = new boolean[numCourses];
//        List<Integer> []graph = new ArrayList[numCourses];
//
//        for(int i=0;i<numCourses;i++){
//            graph[i] = new ArrayList();
//        }//for
//        
//        for (int i = 0; i < prerequisites.length; i++){
//        	graph[prerequisites[i][0]].add(prerequisites[i][1]);
//        }//for
//        
//        for (int i = 0; i < numCourses; i++){
//        	if (!DFS(graph, visited, i)){
//        		return false;
//        	}//if
//        }//for
//        return true;  
//    }
//	private boolean DFS(List<Integer>[] graph, boolean[] visited, int course) {
//		// TODO Auto-generated method stub
//		if (visited[course] == true){
//			return false;
//		}else{
//			visited[course] = true;
//		}//else
//		
//		for (int i = 0; i < graph[course].size(); i++){
//			if (!DFS(graph, visited, (int)graph[course].get(i))){
//				return false;
//			}
//		}//for
//		visited[course] = false;
//		return true;
//	}
	
	//BFS
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
		_207CourseSchedule A = new _207CourseSchedule();
		int [][]prerequisites = {{0,1}, {0,4}, {1,3}, {1,4}, {2,0}};
		System.out.print(A.canFinish(5, prerequisites));
		
	}

}

//question:
	//There are a total of n courses you have to take, labeled from 0 to n - 1.
	//
	//Some courses may have prerequisites, for example to take course 0 you have
	//to first take course 1, which is expressed as a pair: [0,1]
	//
	//Given the total number of courses and a list of prerequisite pairs, 
	//is it possible for you to finish all courses?
	//
	//For example:
	//
	//2, [[1,0]]
	//There are a total of 2 courses to take. To take course 1 
	//you should have finished course 0. So it is possible.
	//
	//2, [[1,0],[0,1]]
	//There are a total of 2 courses to take. To take course 1 
	//you should have finished course 0, and to take course 0 you should also 
	//have finished course 1. So it is impossible.