class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int total = 0;

        for (int num : nums) {
            total += num;
        }

        if (total % k != 0) {
            return false;
        }

        int target = total / k;

        boolean[] visited = new boolean[nums.length];

        // Larger numbers first helps with pruning
        Arrays.sort(nums);

        // Reverse the sorted array to get descending order
        for (int i = 0; i < nums.length / 2; i++) {
            int temp = nums[i];
            nums[i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = temp;
        }

        if (nums[0] > target) {
            return false;
        }

        return solve(nums, visited, k, 0, 0, target);
    }

    boolean solve(int[] nums, boolean[] visited, int k,
                  int currentSum, int start, int target) {

        // All subsets have been formed
        if (k == 1) {
            return true;
        }

        // Current subset is complete
        if (currentSum == target) {
            return solve(nums, visited, k - 1, 0, 0, target);
        }

        for (int i = start; i < nums.length; i++) {

            if (visited[i]) {
                continue;
            }

            if (currentSum + nums[i] > target) {
                continue;
            }

            // Choose
            visited[i] = true;

            // Explore
            if (solve(nums, visited, k, currentSum + nums[i],
                      i + 1, target)) {
                return true;
            }

            // Undo: backtracking
            visited[i] = false;
        }

        return false;
    }
}