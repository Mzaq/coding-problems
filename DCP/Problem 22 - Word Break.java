/*This problem was asked by Microsoft, Google, Uber, Twitter.
Basic:

Given a dictionary of words and a string (no spaces), return whether the sentence can be built using words in the dictionary. 

Follow up:

Given a dictionary of words and a string made up of those words (no spaces), return the original sentence in a list. If there is more than one possible reconstruction, return all of them. If there is no possible reconstruction, then return null.

For example, given the set of words 'quick', 'brown', 'the', 'fox', and the string "thequickbrownfox", you should return ['the', 'quick', 'brown', 'fox'].

Given the set of words 'bed', 'bath', 'bedbath', 'and', 'beyond', and the string "bedbathandbeyond", return both ['bed', 'bath', 'and', 'beyond] and ['bedbath', 'and', 'beyond'].

On LeetCode:
https://leetcode.com/problems/word-break/description/
https://leetcode.com/problems/word-break-ii/description/
*/

//Word break: Recursion with memoization
public boolean wordBreak(String s, List<String> wordDict) {
	Set<String> wordSet = new HashSet<>(wordDict);
	Boolean[] contains = new Boolean[s.length() + 1];

	return wordBreak(s, wordSet, contains, 0);
}

private boolean wordBreak(String word, Set wordSet, Boolean[] contains, int start){
	if (start == word.length()){
		return true;
	}
	
	if (contains[start] != null){
		return contains[start];
	}
	
	for (int i = start + 1; i <= word.length(); i++){
		if (wordSet.contains(word.substring(start, i)) && wordBreak(word, wordSet, contains, i)){
			System.out.println("start:" + start + ", " + "end: "+ i);
			contains[start] = true;
			return contains[start];
		}
		System.out.println("start:" + start + ", " + "end: "+ i);

	}
			
	contains[start] = false;
	return contains[start];
}

//Word break: Dynamic programming

//Word break II:

