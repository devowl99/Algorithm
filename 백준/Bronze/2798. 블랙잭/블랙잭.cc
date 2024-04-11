#include <iostream>
using namespace std;

int main() {
    int n, m, sum = 0, max = 0;
    int arr[100] = { 0 };

    cin >> n >> m;
    for (int a = 0; a < n; a++) {
        cin >> arr[a];
    }
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) {
            for (int k = j + 1; k < n; k++) {
                sum = arr[i] + arr[j] + arr[k];
                if ((max < sum) && (sum <= m))
                    max = sum;
            }
        }
    }
    cout << max;

    return 0;
}