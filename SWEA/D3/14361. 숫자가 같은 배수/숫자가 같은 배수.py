from collections import Counter

T = int(input())
for test_case in range(1, T + 1):
    num = input()
    num_counter = Counter(num)
    is_possible = False

    for i in range(2, 10):
        multiplied = str(int(num) * i)

        if len(multiplied) != len(num):
            continue

        if Counter(multiplied) == num_counter:
            is_possible = True
            break

    if is_possible:
        print(f'#{test_case} possible')
    else:
        print(f'#{test_case} impossible')