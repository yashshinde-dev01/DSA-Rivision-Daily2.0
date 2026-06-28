class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = piles[0];
        for (int p : piles) {
            if (p > max) max = p;
        }

        int l = 1, r = max;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long hr = kokoeat(piles, mid);
            if (hr <= h) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    static long kokoeat(int[] nums, int k) {
        long speed = 0;
        for (int num : nums) {
            speed += ((long) num + k - 1) / k;
        }
        return speed;
    }
}