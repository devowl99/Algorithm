# 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
# 아래 표준 입출력 예제 필요시 참고하세요.

# 표준 입력 예제
'''
a = int(input())                        정수형 변수 1개 입력 받는 예제
b, c = map(int, input().split())        정수형 변수 2개 입력 받는 예제 
d = float(input())                      실수형 변수 1개 입력 받는 예제
e, f, g = map(float, input().split())   실수형 변수 3개 입력 받는 예제
h = input()                             문자열 변수 1개 입력 받는 예제
'''

# 표준 출력 예제
'''
a, b = 6, 3
c, d, e = 1.0, 2.5, 3.4
f = "ABC"
print(a)                                정수형 변수 1개 출력하는 예제
print(b, end = " ")                     줄바꿈 하지 않고 정수형 변수와 공백을 출력하는 예제
print(c, d, e)                          실수형 변수 3개 출력하는 예제
print(f)                                문자열 1개 출력하는 예제
'''




'''
아래의 구문은 input.txt 를 read only 형식으로 연 후,
앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
아래 구문을 이용하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 구문을 사용하셔도 좋습니다.
아래 구문을 사용하기 위해서는 import sys가 필요합니다.
단, 채점을 위해 코드를 제출하실 때에는 반드시 아래 구문을 지우거나 주석 처리 하셔야 합니다.
'''
#import sys
#sys.stdin = open("input.txt", "r")

T = int(input())
for test_case in range(1, T + 1):
    N, M = map(int, input().split())
    square = []

    case9 = '0001011'
    case8 = '0110111'
    case7 = '0111011'
    case6 = '0101111'
    case5 = '0110001'
    case4 = '0100011'
    case3 = '0111101'
    case2 = '0010011'
    case1 = '0011001'
    case0 = '0001101'
    check = '0'*56

    for _ in range(N):
        square.append(input())

    is_code = False
    for row in range(N):
        for col in range(M-56+1):
            codes = []
            numbers = []

            if square[row][col:col+56] != check:
                code = square[row][col:col+56]
                codes.append(code[:7])
                codes.append(code[7:14])
                codes.append(code[14:21])
                codes.append(code[21:28])
                codes.append(code[28:35])
                codes.append(code[35:42])
                codes.append(code[42:49])
                codes.append(code[49:56])

                for code in codes:
                    if code == case0:
                        numbers.append(0)
                    elif code == case1:
                        numbers.append(1)
                    elif code == case2:
                        numbers.append(2)
                    elif code == case3:
                        numbers.append(3)
                    elif code == case4:
                        numbers.append(4)
                    elif code == case5:
                        numbers.append(5)
                    elif code == case6:
                        numbers.append(6)
                    elif code == case7:
                        numbers.append(7)
                    elif code == case8:
                        numbers.append(8)
                    elif code == case9:
                        numbers.append(9)

            if len(numbers) == 8:
                check_code = (numbers[0]+numbers[2]+numbers[4]+numbers[6])*3 + numbers[1]+numbers[3]+numbers[5]+numbers[7]

                if str(check_code)[-1] == '0':
                    is_code = True
                    break

        if is_code:
            break

    if is_code:
        print(f'#{test_case} {sum(numbers)}')
    else:
        print(f'#{test_case}', 0)