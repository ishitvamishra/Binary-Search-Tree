class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> p = new PriorityQueue<>(Collections.reverseOrder());

        for(int i = 0;i<stones.length;i++){
            p.add(stones[i]);
        }

        while(p.size() > 1){
            int weight =  p.remove();
            weight-= p.remove();

            if(weight > 0)
            p.add(weight);
        }

        return p.isEmpty() ? 0: p.peek();
    }
}