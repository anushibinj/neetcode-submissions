class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Create map number -> count
        Map<Integer, Long> ctMap = Arrays.stream(nums).boxed().collect(
            Collectors.groupingBy(java.util.function.Function.identity(), Collectors.counting()));

        // Create array count -> number
        List<Integer>[] cntNumArr = new List[nums.length + 1];
        for (Map.Entry<Integer, Long> entry : ctMap.entrySet()) {
            int num = entry.getKey();
            int cnt = entry.getValue().intValue();
            if (cntNumArr[cnt] == null)
                cntNumArr[cnt] = new ArrayList<Integer>();
            cntNumArr[cnt].add(num);
        }
        // Find top k nums
        int[] res = new int[k];
        for (int i = cntNumArr.length - 1; i >= 0 && k > 0; i--) {
            List<Integer> cnt = cntNumArr[i];
            if (cnt != null) {
                for (int j = 0; j < cnt.size() && k > 0; j++) {
                    res[k - 1] = cnt.get(j);
                    k--;
                }
            }
        }
        // Return res
        return res;
    }
}
