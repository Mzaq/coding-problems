/*This problem was asked by Snapchat, Google, Facebook.

Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required.

For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.

Definition for an interval:

public class Interval {
 int start;
 int end;
 Interval() { start = 0; end = 0; }
 Interval(int s, int e) { start = s; end = e; }
}
 
Also on Leetcode: https://leetcode.com/problems/meeting-rooms-ii/description/
*/

//Naive solution
public int minMeetingRooms(Interval[] intervals) {
	if (intervals == null || intervals.length == 0){
		return 0;
	}
	
	int rooms = 1;
	Arrays.sort(intervals, new Comparator<Interval>(){
		public int compare(Interval interval1, Interval interval2){
			return Integer.valueOf(interval1.start).compareTo(Integer.valueOf(interval2.start));
		}
	});
	
	for (int i = 0; i < intervals.length; i++){
		int temp = 1;
		for (int j = i - 1; j >= 0; j--){
			if (intervals[i].start < intervals[j].end){
				temp++;
			}
		}
		rooms = Math.max(rooms, temp);
	}
	return rooms;
}

