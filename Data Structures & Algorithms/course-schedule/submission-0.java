class Solution {
    public boolean canFinish(int courses, int[][] prereqs) {
        if(courses<=1)
            return true;

        List<List<Integer>> graph = new ArrayList<>(courses);
        for (int i = 0; i < courses; i++) 
            graph.add(new ArrayList<>());
        
        int[] indegree = new int[courses];
        for(int[] pre: prereqs){
            int course = pre[0];
            int prereq = pre[1];
            graph.get(prereq).add(course);
            indegree[course]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < courses; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        int processed = 0;
        while(!q.isEmpty()){
            int node = q.remove();
            processed++;
            for(int nei : graph.get(node)){
                indegree[nei]--;
                if(indegree[nei]==0){
                    q.push(nei);
                }
            }
        }
        return processed==courses;
    }
}
