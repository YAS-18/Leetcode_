class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        Set<Integer> set= new HashSet<>();

        for(int x : leftChild) 
            if(x != -1 ) 
                set.add(x);

        for(int x : rightChild) 
            if(x != -1 ) 
                set.add(x);

        int root = -1;
        for(int i=0 ; i<n ; i++)
            if(!set.contains(i))
                    root = i;

        if(root == -1)
            return false;

        Set<Integer> set2 = new HashSet<>();
        set2.add(root);

        Queue<Integer> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()) {
            int curr = que.poll();

            if(leftChild[curr] != -1) {
                if(set2.contains(leftChild[curr])) 
                    return false;
                set2.add(leftChild[curr]);
                que.add(leftChild[curr]);
            }

            if(rightChild[curr] != -1) {
                if(set2.contains(rightChild[curr]))
                    return false;
                
                set2.add(rightChild[curr]);
                que.add(rightChild[curr]);
            }
        }
        
        return set2.size() == n;
        
    }
}