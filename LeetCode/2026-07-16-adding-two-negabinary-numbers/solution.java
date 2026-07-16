class Solution {
    // Time complexity: O(n), where n is the maximum length of arr1 and arr2
    // Space complexity: O(n), where n is the maximum length of arr1 and arr2
    public int[] addNegabinary(int[] arr1, int[] arr2) {
        int[] result = new int[Math.max(arr1.length, arr2.length) + 1];
        int carry = 0;
        int i = arr1.length - 1, j = arr2.length - 1, k = result.length - 1;
        
        while (i >= 0 || j >= 0 || carry > 0) {
            if (i >= 0) carry += arr1[i--];
            if (j >= 0) carry += arr2[j--];
            result[k--] = carry & 1;
            carry = -(carry >> 1);
        }
        
        // Remove leading zeros
        while (result.length > 1 && result[result.length - 1] == 0) {
            int[] temp = new int[result.length - 1];
            System.arraycopy(result, 0, temp, 0, result.length - 1);
            result = temp;
        }
        
        return result;
    }
}