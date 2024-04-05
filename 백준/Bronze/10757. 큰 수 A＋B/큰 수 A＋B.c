#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>
#include <string.h>

void Reverse(char str[], int len) { // 문자열 역순 정렬
    int i;
    char temp;

    for (i = 0; i < len / 2; ++i) {
        temp = str[i];
        str[i] = str[len - i - 1];
        str[len - i - 1] = temp;
    }
}

int main() {

    char A[10001], B[10001], C[10002];
    int i, AN, BN, CN, temp, carry = 0, pA, pB;
    // AN, BN, CN : char형 배열 A, B, C의 크기가 몇인지(각각 몇자리 수 인지) 확인, 저장
    // temp: n자리의 A와 n자리의 B의 합이 10이상일 경우(받아올림을 해야할 경우)를 위해 A와 B의 합을 임시로 저장
    // carry : 받아올림(덧셈이니 0 or 1)이 있을 경우 1, 없을 경우 0을 다음 자리수에 더해줌
    // pA, pB : temp에 최종적으로 더해줄 A의 값과 B의 값을 저장 (A와 B의 자릿수가 다를 경우를 위해)

    scanf("%s %s", &A, &B);
    AN = strlen(A);
    BN = strlen(B);
    // 문자열 A, B의 크기를 입력받고 각 AN, BN에 저장

    Reverse(A, AN);
    Reverse(B, BN);

    for (i = 0; i < AN || i < BN; ++i) { // i는 0부터 문자열의 마지막 index 까지
        if (!(A[i] >= '0' && A[i] <= '9'))
            pA = 0;
        else
            pA = A[i] - '0';
        if (!(B[i] >= '0' && B[i] <= '9'))
            pB = 0;
        else
            pB = B[i] - '0';
        // A or B의 i번째 인덱스 값이 0~9일 경우 pA or pB에 A or B의 i번째 인덱스에 있는 값을 대입하고, 0~9가 아닐 경우 pA or pB에 0을 대입

        temp = pA + pB + carry; // A와 B의 값을 임시로 저장할 변수 temp에 pA, pB, 받아올림 값을 위한 carry 변수를 더함
        
        if (temp >= 10) { // 받아올림 있는 경우(temp >= 10) C의 i번째 index에 temp%10 값을 char형으로 형 변환 후 저장, carry에 1 저장
            C[i] = (temp % 10) + '0';
            carry = 1;
        }
        
        else { // 받아올림 없는 경우(temp < 10) C의 i번째 index에 temp 값을 char형으로 형 변환 후 저장, carry에 0 저장
            C[i] = temp + '0';
            carry = 0;
        }
    }
    
    if (carry == 1) { // 받아올림이 있는 경우, (carry의 값이 1) C의 i번째 index에 '1', i+1번째 index에 '\0' 대입. 또한, CN에 문자열 C의 크기인 i+1을 저장
        C[i] = '1';
        C[i + 1] = '\0';
        CN = i + 1;
    }
    
    else { // 받아올림이 없는 경우, (carry의 값이 0) C의 i번째 index에 '\0' 대입. 또한, CN에 문자열 C의 크기인 i을 저장
        C[i] = '\0';
        CN = i;
    }

    Reverse(C, CN); // 역순으로 되어있는 문자열을 원상복귀

    printf("%s\n", C);

    return 0;
}

// 출처 : https://bakjoon-coding.tistory.com/14

// 문자열 배열을 설정하고 문자열끼리 더하는 방식으로 문제를 해결해야 한다.
// reverse 함수를 사용 이유 : 자릿수가 하나 증가하면, 덧셈을 하기 위해 배열의 인덱스가 모두 한 칸씩 밀려야 한다.
// 그러나 reverse 함수를 사용할 경우 모두 이동하지 않고 인덱스 하나만 추가해주면 되므로 훨씬 간단하다.

// 처음에는 unsigned long long으로 해결하려 했지만 실패했다.
// 사실 정답 코드와 해설을 본 지금도 잘 모르겠다. 