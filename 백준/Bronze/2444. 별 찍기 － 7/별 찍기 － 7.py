n = int(input())
for i in range(n):
    print(' '*(n-i-1) + '*'*(1+i*2))
for j in range(n, n*2-1):
    print(' '*(j-n+1) + '*'*((n*2-1)-2*(j-n+1)))