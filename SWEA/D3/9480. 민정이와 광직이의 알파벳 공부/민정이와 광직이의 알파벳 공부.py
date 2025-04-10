from itertools import combinations

T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    words = []
    for _ in range(n):
        words.append(input())

    answer = 0
    for i in range(1, n+1):
        for comb in combinations(words, i):
            count = 0
            s = ''.join(comb)
            s_set = set(s)
            for ss in s_set:
                if ss in 'abcdefghijklmnopqrstuvwxyz':
                    count += 1
            if count == 26:
                answer += 1

    print(f'#{test_case} {answer}')