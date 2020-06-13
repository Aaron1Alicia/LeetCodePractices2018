package advanced.chapterthree;

import java.util.Stack;


//考点：
//单调栈
//题解：
//用九章算法强化班中讲过的单调栈(stack)。维护一个单调递增栈，逐个将元素 push 到栈里。push 进去之前先把 >= 自己的元素 pop 出来。
//每次从栈中 pop 出一个数的时候，就找到了往左数比它小的第一个数（当前栈顶）和往右数比它小的第一个数（即将入栈的数），
//从而可以计算出这两个数中间的部分宽度 * 被pop出的数，就是以这个被pop出来的数为最低的那个直方向两边展开的最大矩阵面积。
//因为要计算两个数中间的宽度，因此放在 stack 里的是每个数的下标。
public class LargestRectangleInHistogram {

    // TC: O(N)
    public int largestRectangleArea(int[] height) {
        if(height==null || height.length==0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int ans = 0;

        for(int i=0; i<=height.length; i++) {
            int cur = i==height.length? 0: height[i];

            while(!stack.isEmpty() && cur<=height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty()? i: i-1-stack.peek();
                ans = Math.max(h*w, ans);
            }

            stack.push(i);
        }

        return ans;
    }
}
