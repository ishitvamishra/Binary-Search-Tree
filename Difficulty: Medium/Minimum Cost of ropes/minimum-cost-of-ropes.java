class Solution {
    public static int minCost(int[] arr) {
        // code here
        PriorityQueue<Integer> p = new PriorityQueue<>();
        
        for(int i = 0;i<arr.length;i++){
            p.add(arr[i]);
        }
        
        int cost = 0;
        
        while(p.size() >1){
            int rope = p.remove();
            rope+= p.remove();
            cost+= rope;
            p.add(rope);
        }
        
        return cost;
    }
}