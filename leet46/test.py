def permutation(nums):
    if len(nums) == 1:
        yield nums[0:1]
    else:
        for perm in permutation(nums[1:]):
            for i in range(len(perm) + 1):
                yield perm[:i] + nums[0:1] + perm[i:]


print(list(permutation([1, 2, 3])))
