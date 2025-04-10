T = int(input())
for test_case in range(1, T + 1):
    horn, animal = map(int, input().split())
    twin = horn - animal
    uni = animal - twin
    print(f'#{test_case} {uni} {twin}')