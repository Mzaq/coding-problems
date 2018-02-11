/*
This problem was asked by Facebook, Microsoft, Uber.

Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa, 'ka', and 'ak'.

Also on LeetCode: https://leetcode.com/problems/decode-ways/description/ 

*/

//O(n) DP solution
public int numDecodings(String s) {
	if (s == null || s.length() == 0 || s.charAt(0) == '0'){
		return 0;
	}
	
	int[] numWays = new int[s.length() + 1];
	numWays[0] = 1;
	numWays[1] = 1;
	
	for (int i = 1; i < s.length(); i++){
		int oneNum = Integer.parseInt(s.charAt(i) + "");
		int twoNum = Integer.parseInt(s.substring(i-1, i+1));
		
		if (oneNum != 0){
			numWays[i + 1] = numWays[i];
		} 
		
		if (twoNum >= 10 && twoNum <= 26){
			numWays[i + 1] += numWays[i - 1];
		}
	}
	
	return numWays[numWays.length - 1];
}