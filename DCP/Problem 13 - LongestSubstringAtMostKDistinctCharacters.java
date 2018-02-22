/*
This problem was asked by Amazon and Google.

Given an integer k and a string s, find the length of the longest substring that contains at most k distinct characters.

For example, given s = "abcba" and k = 2, the longest substring with k distinct characters is "bcb", so your function should return 3.
*/


//Initial O(n) time/space solution w/ HashMap
public int lengthOfLongestSubstringKDistinct(String s, int k) {
	if (s.equals("") || k == 0) return 0;
	
	int longestSubstring = 0;
	char[] string = s.toCharArray();
	Map<Character, Integer> charCount = new HashMap<>();
	int left = 0;
	int right = 0;
	
	while (right < string.length){
		int count = charCount.getOrDefault(string[right], 0);
		charCount.put(string[right], ++count);
		longestSubstring = Math.max(longestSubstring, right - left + 1);

		if (charCount.size() == k && right < s.length() - 1 && !charCount.containsKey(string[right + 1])){
			while (charCount.size() == k){
				charCount.put(string[left], charCount.get(string[left]) - 1);
				if (charCount.get(string[left]) == 0){
					charCount.remove(string[left]);
				}
				left++;
			}
		}
		right++;
	}
	
	return longestSubstring;
}