N,r,c = map(int, input().split())
r += 1
c += 1

visit = 0
while N:
    N -= 1   
    if c > 2**N and r <= 2**N:
        visit += (2**N)**2
        c -= 2**N
    elif c <= 2**N and r > 2**N:
        visit += ((2**N)**2)*2
        r -= 2**N
    elif c > 2**N and r > 2**N:
        visit += ((2**N)**2)*3
        c -= 2**N
        r -= 2**N

print(visit)