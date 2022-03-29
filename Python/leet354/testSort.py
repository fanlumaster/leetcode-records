from functools import cmp_to_key
from typing import List

envelopes = [[5, 4], [6, 4], [6, 7], [2, 3]]


def cmp(x: List[int], y: List[int]):
    if x[0] < y[0]:
        return -1
    if x[0] > y[0]:
        return 1
    if x[0] == y[0]:
        if x[1] > y[1]:
            return -1
        else:
            return 1


envelopes.sort(key=cmp_to_key(cmp))
print(envelopes)
