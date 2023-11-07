/**
 * @param {number[]} nums
 * @return {number}
 */
var lengthOfLIS = function (nums) {
    if (nums.length == 1) {
        return 1;
    }
    let dp = [];
    dp.length = nums.length;
    dp[0] = 1;
    for (let i = 1; i < nums.length; i++) {
        let temp = 0;
        for (let j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                temp = Math.max(temp, dp[j]);
            }
        }
        dp[i] = temp + 1;
    }
    let res = 0;
    for (let i = 0; i < dp.length; i++) {
        res = Math.max(res, dp[i]);
    }
    return res;
};

let data = [10, 9, 2, 5, 3, 7, 101, 18];
data = [0, 1, 0, 3, 2, 3];
data = [7, 7, 7, 7, 7, 7, 7];
let res = lengthOfLIS(data);
console.log(res);
