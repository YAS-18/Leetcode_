class Solution {
    class Node {
        int x;
        int y;
        int d;
        public Node(int x,int y,int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    int dir[][] = {{1,0},{0,-1},{-1,0},{0,1}};
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length-1;
        int n = heights[0].length-1;

        int dist[][] = new int[m+1][n+1];
        for(int x[] : dist) {
            Arrays.fill(x,Integer.MAX_VALUE);
        }

        PriorityQueue<Node>pQue = 
            new PriorityQueue<>((a,b)->(a.d - b.d));
        int minDist = 0;
        pQue.add(new Node(0,0,0));

        while(!pQue.isEmpty()) {
            Node curr = pQue.poll();
            int x = curr.x;
            int y = curr.y;
            int d = curr.d;

            if(d > dist[x][y]) 
                continue;
            if(x == m && y == n)
                return d;
            

            for(int i=0 ; i<4 ; i++){
                int newX = x + dir[i][0];
                int newY = y + dir[i][1];

                if(newX < 0 || newX > m || newY < 0 || newY > n) 
                    continue;
                else {
                    int newD = Math.max(d , 
                        Math.abs(heights[newX][newY] - heights[x][y]));
                    
                    if(newD < dist[newX][newY]) {
                        dist[newX][newY] = newD;
                        pQue.add(new Node(newX, newY, newD));
                    }
                }
            }
        }
        
        return 0; 
    }
}