/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) return 0;
        PriorityQueue<Integer>pq = new PriorityQueue<>();
        Collections.sort(intervals, (a, b) -> a.start - b.start);
        for(Interval it:intervals){
            if(!pq.isEmpty() && pq.peek()<=it.start){
                pq.poll();
            }
            pq.add(it.end);
        }
        return pq.size();
    }
}
