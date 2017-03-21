import java.util.*;
public class _210CourseScheduleII {

	public int[] findOrder(int numCourses, int[][] prerequisites) {
        int []degree = new int[numCourses];
        ArrayList<Integer>[] linkedCourse = new ArrayList[numCourses];
        for (int i =0; i < numCourses; i++){
        	linkedCourse[i] = new ArrayList<>();
        }
        for (int course[] : prerequisites){
        	degree[course[0]]++;
        	linkedCourse[course[1]].add(course[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        int [] res = new int[numCourses];
        int visit = 0;
        int count = 0;
        for (int i = 0; i < numCourses; i++){
        	if (degree[i] == 0){
        		count++;
        		queue.offer(i);
        		res[visit++] = i;
        	}
        }
        while (!queue.isEmpty()){
        	int take = queue.poll();
        	for (int i = 0; i < linkedCourse[take].size(); i++){
        		--degree[linkedCourse[take].get(i)];
        		if (degree[linkedCourse[take].get(i)] == 0){
        			count++;
        			queue.offer(linkedCourse[take].get(i));
        			res[visit++] = linkedCourse[take].get(i);
        		}
        	}//for i
        }//while
        return count == numCourses ? res : new int [0]; 
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_210CourseScheduleII A = new _210CourseScheduleII();
		int [][]prerequisites = {{1,0},{2,0},{3,1},{3,2}};
		int [] res= A.findOrder(4, prerequisites);
		for (int take : res){
			System.out.println(take + " ");
		}
	}

}

//question:
	//There are a total of n courses you have to take, labeled from 0 to n - 1.
	//
	//Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
	//
	//Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
	//
	//There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
	//
	//For example:
	//
	//2, [[1,0]]
	//There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]
	//
	//4, [[1,0],[2,0],[3,1],[3,2]]
	//There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
	//
	//Note:
	//The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
	//You may assume that there are no duplicate edges in the input prerequisites.
