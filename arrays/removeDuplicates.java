import java.util.Arrays;

class Solution {
    public int removeDuplicates(int[] nums) {
        int newpos=0;
        for(int j=1; j<nums.length; j++){
            if(nums[j]!=nums[newpos]){
                newpos++;
                nums[newpos]=nums[j];
                }
            }
        return newpos+1;      

         }
public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] testArray = {1, 1, 2, 2, 3, 4, 4};
        
        System.out.println("Original: " + Arrays.toString(testArray));
        
        int k = sol.removeDuplicates(testArray);
        
        System.out.println("New length: " + k);
        System.out.print("Modified array: ");
        for (int i = 0; i < k; i++) {
            System.out.print(testArray[i] + " ");
        }
    }
}