/*
There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.

EXAMPLE
pale, ple -> true
pales. pale -> true
pale. bale -> true
pale. bake -> false
*/

public boolean oneEditDistance(String original, String updated) {
	if (Math.abs(original.length() - updated.length()) > 1) return false;

	if (original.length() > updated.length()){
		String temp = original;
		original = updated;
		updated = temp;
	}

	int a = 0;
	int b = 0;
	boolean edit = false;

	while (a < original.length()){
		if (original.charAt(a) != updated.charAt(b)){
			if(edit) return false;
			else edit = true;

			if(original.length() == updated.length()) a++;
		} else {
			a++;
		}
		b++;
	}

	return true;
}