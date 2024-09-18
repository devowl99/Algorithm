def solution(n):
    for i in range(n+1,1000001):
        if bin(n)[2:].count('1') == bin(i)[2:].count('1'):
            return i