class Solution {
    public boolean check(int[] nums) {
        int drops = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > nums[(i+1) % nums.length]){
                drops++ ;
            }
            if(drops > 1){
            return false;
        }
        }
        return true ;
    }
}

/* i = 0: Check nums[0] > nums[(0 + 1) % 5]

Index math: 1 % 5 = 1

Check values: nums[0] > nums[1] ➔ 4 > 5 ➔ No drop

i = 1: Check nums[1] > nums[(1 + 1) % 5]

Index math: 2 % 5 = 2

Check values: nums[1] > nums[2] ➔ 5 > 1 ➔ Drop 1!

i = 2: Check nums[2] > nums[(2 + 1) % 5]

Index math: 3 % 5 = 3

Check values: nums[2] > nums[3] ➔ 1 > 2 ➔ No drop

i = 3: Check nums[3] > nums[(3 + 1) % 5]

Index math: 4 % 5 = 4

Check values: nums[3] > nums[4] ➔ 2 > 6 ➔ No drop

i = 4 (The Wrap-Around): Check nums[4] > nums[(4 + 1) % 5]

Index math: 5 % 5 = 0 (This loops back to the start!)

Check values: nums[4] > nums[0] ➔ 6 > 4 ➔ Drop 2!    If Drop > 1 then it will return false as it is not properly sorted .*/
