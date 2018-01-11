package algorithm.leetcode;

import java.util.*;

/************************************************************************************
 * 功能描述：
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 *
 *
 *
 * 创建人：岳增存  yuezc@seentao.com
 * 创建时间： 2018年01月11日 --  下午3:32 
 * 其他说明：
 * 修改时间：
 * 修改人：
 *************************************************************************************/
public class MergeIntervals {

    //Definition for an interval.
    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    /**
     * 先按照start的值按从小到大排序
     *
     * 再逐一合并
     *
     *
     * 来自leetcode的solutions：https://leetcode.com/problems/merge-intervals/solution/
     *
     * @param intervals
     * @return
     */
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start > o2.start){
                    return 1;
                }else if(o1.start < o2.start){
                    return -1;
                }else {
                    return 0;
                }
            }
        });

        LinkedList<Interval> res = new LinkedList<>();
        for (Interval interval : intervals) {
            if(res.isEmpty() || interval.start > res.getLast().end){
                res.add(interval);
            }else {
                res.getLast().end = Math.max(res.getLast().end, interval.end);
            }
        }

        return res;
    }

}
