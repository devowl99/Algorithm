T = int(input())
for test_case in range(1, T + 1):
    n = int(input())
    nums = list(map(int, input().split()))
    num_sums = set([0])

    for num in nums:
        save = set()
        for num_sum in num_sums:
            new = num_sum + num
            save.add(new)
        num_sums.update(save)

    print(f'#{test_case} {len(num_sums)}')