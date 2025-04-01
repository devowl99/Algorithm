from collections import deque

T = int(input())
for test_case in range(1, T + 1):
    n, m = map(int, input().split())
    words = []
    for _ in range(n):
        words.append(input())

    dq_words = deque(words)

    max_len = 0

    while dq_words:
        current = dq_words.popleft()
        if current[::-1] in dq_words:
            max_len += (m*2)
            dq_words.remove(current[::-1])

    for word in words:
        if word == word[::-1]:
            max_len += m
            break

    print(f'#{test_case} {max_len}')