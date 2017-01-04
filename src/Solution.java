/**
 * Created by Pranith on 1/3/17.
 */
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
        int[] myarray = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(LIS(myarray));
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
}