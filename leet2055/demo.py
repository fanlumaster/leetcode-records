s = '**|**|***|'
sum = 0
leftValue = -1
left = [0] * len(s)
for i in range(len(s)):
    if s[i] == '*':
        sum += 1
    else:
        leftValue = i
    left[i] = leftValue
    print('第', i, '次')
    print('sum', sum)
    print('leftValue', leftValue)
    print('left 数组', left)
    print('=====================')
