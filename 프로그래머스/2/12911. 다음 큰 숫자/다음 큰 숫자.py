def solution(n):
    binn = bin(n)[2:] # bin()
    numone = binn.count('1')

    for i in range(n+1,1000001):
        if bin(i)[2:].count('1') == numone:
            return i