#include <stdio.h>

int findSpecialInteger(int* arr, int arrSize) {
    int c = 0;
    int pre = -1;
    for (int i = 0; i < arrSize; i++) {
        if (pre == arr[i]) {
            c++;
        } else {
            if (arrSize < 4*c) {
                return arr[i-1];
            }
            pre = arr[i];
            c = 1;
        }
    }
    return arr[arrSize-1];
}

int main( int argc, char *argv[ ] ){
    int arr1[] = {1,2,2,6,6,6,6,7,10};
    printf("%d\n", findSpecialInteger(arr1, sizeof(arr1) / sizeof(int)));

    int arr2[] = {1,1};
    printf("%d\n", findSpecialInteger(arr2, sizeof(arr2) / sizeof(int)));

}