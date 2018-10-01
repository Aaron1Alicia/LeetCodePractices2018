package stack;



public class TrappingRainWater {

    public int trap(int[] height) {

        if(height==null || height.length<3) {
            return 0;
        }

        int leftMax = height[0];
        int rightMax = height[height.length-1];

        int ans = 0;

        int left = 0;
        int right = height.length-1;

        // left will never be equal to right, because when left=right,
        // it will be the point that is biggest in this array
        while (left<right) {
            leftMax = Math.max(height[left], leftMax);
            rightMax = Math.max(height[right], rightMax);

            if(leftMax>=rightMax) {
                ans+=(rightMax - height[right]);
                right--;

            } else {
                ans+=(leftMax - height[left]);
                left++;

            }


        }

        return ans;

    }
}
