/**
 * Created by Pranith on 1/3/17.
 */

import java.util.*;
public class Solution {

    public static int LIS(int[] nums) {
        int result = 0;
        int[] res = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            res[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    res[i] = Math.max(res[i], res[j] + 1);
                }
            }
        }

        for (int i = 0; i < res.length; i++) {
            if (res[i] > result) {
                result = res[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
//      int[] myarray = {10, 9, 2, 5, 3, 7, 101, 18};
//        System.out.println(LIS(myarray));*/
//        String string="Hi this is pranith mididoddi";
//        System.out.println(returnlist(string));

        System.out.println(uniquePaths(4,4));
    }


/** for interviewBit   int result=0;
    int[] res=new int[nums.size()];

        for(int i=0;i<nums.size();i++){
        res[i]=1;
        for(int j=0;j<i;j++){
            if(nums.get(i)>nums.get(j)){
                res[i]=Math.max(res[i],res[j]+1);
            }
        }
    }

        for(int i=0;i<res.length;i++){
        if(res[i]>result){
            result=res[i];
        }
    }
        return result;

}

    }

    **/

/**Longest distinct subsequence*/
public int numDistinct(String S, String T) {
    int[][] res=new int[S.length()+1][T.length()+1];

    for(int i=0;i<S.length();i++){
        res[i][0]=1;
    }
    for(int i=1;i<=S.length();i++){
        for(int j=1;j<=T.length();j++){
            if(S.charAt(i-1)==T.charAt(j-1)){
                res[i][j]+=res[i-1][j]+res[i-1][j-1];
            }
            else{
                res[i][j]+=res[i-1][j];
            }
        }
    }
    return res[S.length()][T.length()];
}

/**Unique paths/AKA robot grid*/
public static int uniquePaths(int m, int n) {

    int[][] robotgrid=new int[m][n];

    for(int i=0;i<m;i++){
        robotgrid[i][0]=1;
    }

    for(int j=0;j<n;j++){
        robotgrid[0][j]=1;
    }

    for(int i=1;i<m;i++){
        for(int j=1;j<n;j++){
            robotgrid[i][j]=robotgrid[i-1][j]+robotgrid[i][j-1]+robotgrid[i-1][j-1];
        }
    }
    return robotgrid[m-1][n-1];
}

}
/**Maximum Subarray*/

public int maxSubArray(int[] A) {
    int max = A[0];
    int[] sum = new int[A.length];
    sum[0] = A[0];

    for (int i = 1; i < A.length; i++) {
        sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
        max = Math.max(max, sum[i]);
    }

    return max;
}




