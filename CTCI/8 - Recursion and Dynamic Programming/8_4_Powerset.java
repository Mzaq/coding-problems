/*
8.4 - Powerset

Write a method to return all subsets of a set.
*/

//No duplicates

List<List<Integer>> subsets = new ArrayList<>();

public List<List<Integer>> subsets(int[] nums) {
	subsets.add(new ArrayList<Integer>());
	subsetHelper(new ArrayList<Integer>(), nums, 0);
	return subsets;
}

private void subsetHelper(List<Integer> subset, int[] nums, int index) {
	for (int i = index; i < nums.length; i++) {
		subset.add(nums[i]);
		subsets.add(new ArrayList<Integer>(subset));
		subsetHelper(subset, nums, i + 1);
		subset.remove(subset.size() - 1);
	}
}

//With duplicates
List<List<Integer>> subsets = new ArrayList<>();

public List<List<Integer>> subsetsWithDup(int[] nums) {
	Arrays.sort(nums);
	subsets.add(new ArrayList<Integer>());
	subsetHelper(new ArrayList<Integer>(), nums, 0);
	return subsets;
}

private void subsetHelper(List<Integer> subset, int[] nums, int index) {
	for (int i = index; i < nums.length; i++) {
		if (i > index && nums[i] == nums[i - 1]) continue;
		subset.add(nums[i]);
		subsets.add(new ArrayList<Integer>(subset));
		subsetHelper(subset, nums, i + 1);
		subset.remove(subset.size() - 1);
	}
}