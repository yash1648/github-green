class Solution {
    // Time complexity: O(n log n) due to sorting
    // Space complexity: O(n) for storing merged meetings
    public int countDays(int days, int[][] meetings) {
        // Sort meetings by start time
        Arrays.sort(meetings, (a, b) -> a[0] - b[0]);
        
        // Initialize variables to track merged meetings and count of available days
        int[] mergedMeetings = new int[] {meetings[0][0], meetings[0][1]};
        int availableDays = 0;
        
        // Iterate through meetings to merge overlapping meetings
        for (int i = 1; i < meetings.length; i++) {
            // Check if current meeting overlaps with the last merged meeting
            if (meetings[i][0] <= mergedMeetings[mergedMeetings.length - 1]) {
                // Merge current meeting with the last merged meeting
                mergedMeetings[mergedMeetings.length - 1] = Math.max(mergedMeetings[mergedMeetings.length - 1], meetings[i][1]);
            } else {
                // Add current meeting to merged meetings
                mergedMeetings = Arrays.copyOf(mergedMeetings, mergedMeetings.length + 2);
                mergedMeetings[mergedMeetings.length - 2] = meetings[i][0];
                mergedMeetings[mergedMeetings.length - 1] = meetings[i][1];
            }
        }
        
        // Calculate available days by summing gaps between merged meetings
        availableDays += mergedMeetings[0] - 1;
        for (int i = 1; i < mergedMeetings.length; i += 2) {
            availableDays += mergedMeetings[i] - mergedMeetings[i - 1] - 1;
        }
        availableDays += days - mergedMeetings[mergedMeetings.length - 1];
        
        // Return available days
        return availableDays;
    }
}