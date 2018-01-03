package algorithm.leetcode;

import java.util.Stack;

/************************************************************************************
 * 功能描述：
 *
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 * Example:
 *
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> Returns -3.
 * minStack.pop();
 * minStack.top();      --> Returns 0.
 * minStack.getMin();   --> Returns -2.
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月03日 --  下午3:03 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class MinStack {

    private Stack<Integer> stack = new Stack<>();
    private int minValue = Integer.MAX_VALUE;

    public MinStack() {

    }

    /**
     * 入栈时，
     * 如果x比最小值小，则将最小值先入栈，再入栈x
     * 这样的效果就是：每次有更小的值出现，则将此时的最小值一块入栈
     *
     *
     * @param x
     */
    public void push(int x) {
        if (x <= minValue) {
            stack.push(minValue);
            minValue = x;
        }
        stack.push(x);
    }

    /**
     * 在出栈的时候，先判断栈顶元素是否与当前最小值相等，
     * 相等的话，则该元素的前一个元素一定是冗余的最小值的记录，则也要把它出栈
     */
    public void pop() {
        if (stack.peek() == minValue) {
            stack.pop();
            minValue = stack.pop();
        } else {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValue;
    }

}


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
