/**
 * 3.1 - Three in One
 *
 * Describe how you could use a single array to implement three stacks
**/

Fixed size solution:
Split the array into three equal sections. e.g. array1 goes from index 0 to n/3, array2 goes from index n/3 to n/2, array 3 goes from index n/2 to 1.
Keep an index counter for each array and increment them as a new element is added to the stack and decrement when an element is removed. Stop growing once next stack is reached.
