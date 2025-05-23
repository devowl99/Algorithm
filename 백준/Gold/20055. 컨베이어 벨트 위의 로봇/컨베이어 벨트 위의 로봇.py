from collections import deque

n, finish = map(int, input().split())
belt = deque(map(int, input().split()))
robot = deque([0] * n)

level = 0
while True:
    level += 1

    # 1. 벨트와 로봇 회전
    belt.rotate(1)
    robot.rotate(1)
    robot[-1] = 0  # 하차

    # 2. 로봇 이동 (역순)
    for i in range(n-2, -1, -1):
        if robot[i] == 1 and robot[i+1] == 0 and belt[i+1] > 0:
            robot[i] = 0
            robot[i+1] = 1
            belt[i+1] -= 1
    robot[-1] = 0  # 하차

    # 3. 로봇 올리기
    if robot[0] == 0 and belt[0] > 0:
        robot[0] = 1
        belt[0] -= 1

    # 4. 종료 조건 확인
    if belt.count(0) >= finish:
        break

print(level)