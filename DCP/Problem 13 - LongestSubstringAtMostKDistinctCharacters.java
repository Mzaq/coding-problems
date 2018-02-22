/*
This problem was asked by Amazon and Google.

Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb", so your function should return 3.

Also on LeetCode: 
- https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters
- https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters
*/


//O(n) time, O(k) space solution w/ HashMap
public int lengthOfLongestSubstringKDistinct(String s, int k) {
	if (s.equals("") || k == 0) return 0;

	Map<Character, Integer> charCount = new HashMap<>();
	int left = 0; int right = 0; int longestSubstring = 0;

	while (right < s.length()){
		char current = s.charAt(right++);
		charCount.put(current, charCount.getOrDefault(current, 0) + 1);

		while (charCount.size() > k){
			char leftChar = s.charAt(left++);
			charCount.put(leftChar, charCount.get(leftChar) - 1);
			if (charCount.get(leftChar) == 0){
				charCount.remove(leftChar);
			}
		}

		longestSubstring = Math.max(longestSubstring, right - left);
	}
	
	return longestSubstring;
}