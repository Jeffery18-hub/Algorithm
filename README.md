# Algorithm
Record self learning process

## bubblesort
There are doubel loops in this algo. The outside loop is used to keep the rounds that we need to "bubble" the biggest number to the rightmost. The inner loop is to do the swap if array[i] > array[i+1].
A little trick: if in any round, the boolean variable which is used to keep track of whether the swap happens in the inner loop, is not set to true, it means that the array is already sorted.


### time complexity
1. when a flag is used here and the array is already sorted
O(n)

2. when the array is reversely sorted, O(n^2) 

3. average: O(n^2)

### space complexity
temparary variable when swap, so O(1)





