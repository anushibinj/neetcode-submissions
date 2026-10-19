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
        if(intervals.size() <= 0) return 0;
        List<Instant> instants = new ArrayList<>();
        for(Interval interval : intervals) {
            instants.add(new Instant(interval.start, true));
            instants.add(new Instant(interval.end, false));
        }
        instants.sort((a, b) -> {
            if(a.time == b.time) {
                if((a.isStart && b.isStart) || (!a.isStart && !b.isStart)) return 0;
                return (a.isStart) ? 1 : -1;
            }
            return Integer.compare(a.time, b.time);
        });
        int maxRooms = Integer.MIN_VALUE;
        int roomCounter = 0;
        for(Instant instant : instants) {
            if(instant.isStart) roomCounter++;
            else roomCounter--;
            maxRooms = Math.max(maxRooms, roomCounter);
        }
        return maxRooms;
    }

    class Instant {
        public int time;
        public boolean isStart;

        public Instant(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
    }
}
