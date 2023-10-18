class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int i=0 ; i<n ; i++) {
            graph.put(i , new ArrayList<>());
        }

        // Represents the Prerequisite courrses
        int inDeg[] = new int[n];
        for(int relation[] : relations) {
            int x = relation[0]-1;
            int y = relation[1]-1;
            graph.get(x).add(y);
            inDeg[y]++;
        }

        Queue<Integer> que = new LinkedList<>();
        int maxTime[] = new int[n]; 

        for(int start=0 ; start<n ; start++) {
            if(inDeg[start] == 0) {
                que.add(start);
                maxTime[start] = time[start]; 
            }
        }

        while(!que.isEmpty()) {
            int curr = que.remove();
            for(int neigh : graph.get(curr)) {
                maxTime[neigh] = 
                    Math.max(maxTime[neigh] , maxTime[curr]+time[neigh]);

                // to confirm that the one prerequisite course is completed 
                inDeg[neigh]--;

                // if the indegree of the neighbour is 0 means that the 
                // neighbour course is ready to start as 
                // all previous courses are completed
                if(inDeg[neigh] == 0) {
                    que.add(neigh);
                }
            }
        }

        int minMonths = 0;
        for(int i=0 ; i<n ; i++){
            minMonths = Math.max(minMonths , maxTime[i]);
        }

        return minMonths;
    }
}