#include <stdio.h>

int main() {
	int n, m, sum = 0, max = 0;
	int arr[100] = { 0 };

	scanf("%d %d", &n, &m);
	for (int a = 0; a < n; a++) {
		scanf("%d", &arr[a]);
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
	printf("%d", max);

	return 0;
}