package quicksort;

import java.util.PriorityQueue;

public class KthLargestElementInAnArray {

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num: nums) {
            pq.offer(num);

            if(pq.size()>k) {
                pq.poll();
            }
        }

        return pq.peek();
    }


    public int findKthLargestByQuickSelect(int[] nums, int k) {

        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }


    // invariant is that to the right of the array, everything will be bigger than pivot
    public int partition(int[] nums, int l, int r) {
        int pivot = nums[l];
        int left = l+1;
        int right = r;

        // For quick-select, this must be <= not <
        while(left<=right) {

            if(nums[left]<pivot) {
                left++;
            } else if(nums[right]>=pivot) {
                right--;
            } else {
                swap(nums, left, right);
            }

        }

        //必须要和右边换，和左边换有可能导致大的数被换到最左边
        swap(nums, l, right);

        return right;

    }


    private void swap(int[] nums, int i, int j) {

        int tmp = nums[j];
        nums[j] = nums[i];
        nums[i] = tmp;

    }



}
