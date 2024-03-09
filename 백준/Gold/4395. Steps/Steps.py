import sys
import math

T = int(input())

for i in range(0,T):
    x, y = map(int, sys.stdin.readline().split())

    n = y - x
    key = int(math.sqrt(n))
    ans = key * 2 -1
    if n != 0:
        if n - key**2 != 0:
            ans = ans + 1
            if key + 0.5 < math.sqrt(n):
                ans = ans + 1
        print(ans)
        
    elif n == 0:
        print(0)