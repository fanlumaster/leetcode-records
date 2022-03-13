from typing import List


class Solution:
    def permute(self, nums: List[int]) -> List[List[int]]:
        def permutation(nums):
            if len(nums) == 1:
                yield nums[0:1]
            else:
                for perm in permutation(nums[1:]):
                    for i in range(len(perm) + 1):
                        yield perm[:i] + nums[0:1] + perm[i:]
        return list(permutation(nums))


if __name__ == '__main__':
    s = Solution()
    print(s.permute([1, 2, 3]))
