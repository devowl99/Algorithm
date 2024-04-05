# python에서 stack은 따로 구현할 필요 x -> list가 해당 기능을 모두 가지고 있기 때문
# push -> append
# pop -> pop
# size -> len
# empty -> if stack:
# top -> stack[-1]

import sys
input = sys.stdin.readline # input을 사용하는 것처럼 입력하며 readline 이용 가능
# 반복문으로 여러 줄을 입력 받을 때 input()은 시간초과 발생 가능
# sys.stdin.readline 사용하면 시간초과 발생 x

n = int(input())
stack = []

for _ in range(n):
    qry = input().split()

    if qry[0] == 'push':
        stack.append(qry[1])

    elif qry[0] == 'pop':
        print(stack.pop() if stack else -1)

    elif qry[0] == 'size':
        print(len(stack))

    elif qry[0] == 'empty':
        print(0 if stack else 1)

    elif qry[0] == 'top':
        print(stack[-1] if stack else -1)