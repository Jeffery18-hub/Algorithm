# Algorithm
Record self learning process

## bubblesort -> stable
There are doubel loops in this algo. The outside loop is used to keep the rounds that we need to "bubble" the biggest number to the rightmost. The inner loop is to do the swap if array[i] > array[i+1].
A little trick: if in any round, the boolean variable which is used to keep track of whether the swap happens in the inner loop, is not set to true, it means that the array is already sorted.


### time complexity
1. when a flag is used here and the array is already sorted
O(n)

2. when the array is reversely sorted, O(n^2) 

3. average: O(n^2)

### space complexity
temparary variable when swap, so O(1)

## selection sort
two loops just as bubble sort

bubble sort-> compare adjacent elements and do swap
selection sort -> compare each element with the element on the min location

选择排序与冒泡排序区别 diff between these two sort algo：

冒泡排序是左右两个数相比较，而选择排序是用后面的数和每一轮的第一个数相比较；
冒泡排序每轮交换的次数比较多，而选择排序每轮只交换一次；bubblesort has more swaps, selectionsort at most one swap in each round.
冒泡排序是通过数去找位置，选择排序是给定位置去找数；
当一个数组遇到相同的数时，冒泡排序相对而言是稳定的，而选择排序便不稳定；
在时间效率上，选择排序优于冒泡排序。

### time complexity
always O(n^2) under best,worst and average cases

### space complexity
O(1)


## insertion sort -> stable
直接插入排序(Straight Insertion Sort)的基本思想是：把n个待排序的元素看成为一个有序表和一个无序表。开始时有序表中只包含1个元素，无序表中包含有n-1个元素，排序过程中每次从无序表中取出第一个元素，将它插入到有序表中的适当位置，使之成为新的有序表，重复n-1次可完成排序过程。
divide the whole array into sorted array and unsorted array.
in every round, pick the first element from the usorted array and insert it into the sorted array

### time complexity
best case: sorted array O(n)
worst and average: O(n^2)

** Note：尽管插入排序的时间复杂度也是O(n²)，但一般情况下，插入排序会比冒泡排序快一倍，要比选择排序还要快一点。**
*** which is better between selection\bubble\insertion sort? ***
*** all these three sort algos are based on "comparison" and "swap" after comparison. ***

## merge sort
pros and cons
### pros
1. large size list
2. linked list
3. external sort
4. stable
### cons
1. extra space (not inpalce sort)
2. small size is slower because of recursion, for small problem use insertion sort(n <=15)
3. recursive -> use stack, logn stack space

## quick sort
我看到网上解法有要求left或者right先走，我觉得这么做太麻烦了，没有必要
我这里的解法没有这个要求和强调。我觉得这样更简单，更容易理解。

## xor
xor is really tricky and mindful in some leetcode questions,like missing number and single number.
One of the application:
exchange the values of two variables:
assume x =a and y =b
x=x^y
y=x^y
x=x^y
all you need is three xor operations and finnaly x =b and y=a

two links as references:
chinese -> https://www.ruanyifeng.com/blog/2021/01/_xor.html
english-> https://florian.github.io/xor-trick/

appendix: single number

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
You must implement a solution with a linear runtime complexity and use only constant extra space.

Example 1:

Input: nums = [2,2,1]
Output: 1
Example 2:

Input: nums = [4,1,2,1,2]
Output: 4
Example 3:

Input: nums = [1]
Output: 1

```
class Solution {
    public int singleNumber(int[] nums) {
        int ret= 0;
        for(int num: nums){
            ret^= num;
        }
        return ret;
    }
}

```









