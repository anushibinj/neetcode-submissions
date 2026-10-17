class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];
        int sell = buy;
        Stack<Integer> s = new Stack<>();
        s.push(buy);
        for(int i = 1; i < prices.length; i++) {
            int curr = prices[i];
            sell = s.peek();
            // smaller?
            if(curr < sell) {
                maxProfit = Math.max(maxProfit, sell - buy);
                while(!s.isEmpty() && s.peek() > curr) {
                    s.pop();
                }
                s.push(curr);
                sell = s.peek();
                if(s.size() == 1) {
                    buy = s.peek();
                }
                continue;
            }
            // larger?
            if(curr > sell) {
                s.push(curr);
                sell = s.peek();
                continue;
            }
        }
        // over and not empty?
        if(!s.isEmpty()) {
            maxProfit = Math.max(maxProfit, sell - buy);
        }
        return maxProfit;
    }
}
