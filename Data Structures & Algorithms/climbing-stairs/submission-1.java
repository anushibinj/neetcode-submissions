class Solution {
    public int climbStairs(int n) {
        int[] cache = new int[n];
        return climbRecursive(0, n, cache);
    }

    private int climbRecursive(int i, int n, int[] cache) {
        if(i == n) {
            return 1;
        }
        if(i > n) {
            return 0;
        }
        if(cache[i] != 0) {
            return cache[i];
        }
        cache[i] = climbRecursive(i + 1, n, cache) + climbRecursive(i + 2, n, cache);
        return cache[i];
    }
}
