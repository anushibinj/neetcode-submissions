class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        Integer[] numsInt = Arrays.stream(nums).boxed().toArray(Integer[] ::new);
        Arrays.sort(numsInt, (a, b) -> {
            int countA = map.get(a);
            int countB = map.get(b);
            if (countA != countB) {
                return Integer.compare(countA, countB);
            }
            return Integer.compare(b, a);
        });
        return Arrays.stream(numsInt).mapToInt(n -> n).toArray();
    }
}