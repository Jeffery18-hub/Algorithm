/*
  brute force: space compelxity is not good. O(n) tc: O(n)
 */

class Solution {
    public int missingNumber(int[] nums) {
    int n = nums.length;
    // [0,n]
    //brute force

    // hashset to contain the nums array
    HashSet numSet = new HashSet<Integer>();


    for(int num: nums) numSet.add(num);

    
    int i;

    for(i= 0; i<= n && numSet.contains(i); ++i){}

    return i;
    }
}


/*
  very trick,use the bitwise operation, tc  O(n) sc O(1)
 */

class Solution {
    public int missingNumber(int[] nums) {
    
        // n xor the indices and values
        int n = nums.length;
        int res= n;
        
        for(int i=0;i<n; i++){
            res = res^i^nums[i];
        }
        
        return res;
        
    }
}

