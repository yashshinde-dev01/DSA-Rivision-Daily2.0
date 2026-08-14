class Solution {
    public int maxSubarraySumCircular(int[] nums) {
       int n = nums.length;

        int total = 0;
        int maxSum = nums[0], currMax = 0;

        // Normal Kadane (max subarray)
        for (int num : nums) {
            currMax = Math.max(num, currMax + num);
            maxSum = Math.max(maxSum, currMax);
            total += num;
        }

        // Invert array
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = -nums[i];
        }

        // Kadane on inverted → gives max of inverted = -min of original
        int curr = 0, max = arr[0];
        for (int num : arr) {
            curr = Math.max(num, curr + num);
            max = Math.max(max, curr);
        }

        int circular = total + max; // since max = -min

        // Handle all negative case
        if (maxSum < 0) return maxSum;

        return Math.max(maxSum, circular);

    }
}