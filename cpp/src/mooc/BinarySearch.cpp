/**
 * 01-复杂度3 二分查找 (20 分)
 * 
 *  https://pintia.cn/problem-sets/1134360184290500608/problems/1134360408631238658
 * 
 */

#include <stdio.h>
#include <stdlib.h>

#define MAXSIZE 10
#define NotFound 0
typedef int ElementType;

typedef int Position;
typedef struct LNode *List;
struct LNode {
    ElementType Data[MAXSIZE];
    Position Last; /* 保存线性表中最后一个元素的位置 */
};

List ReadInput(); /* 裁判实现，细节不表。元素从下标1开始存储 */
Position BinarySearch( List L, ElementType X );

int main()
{
    List L;
    ElementType X;
    Position P;
    struct LNode node {
        .Data = {5, 12, 31, 55, 89, 101},
        .Last = 5
    };

    L = &node;
    // L = ReadInput();

    scanf("%d", &X);
    P = BinarySearch( L, X);

    printf("%d\n", P);
    return 0;
}

Position BinarySearch( List L, ElementType X )
{
    int low = 0;
    int high = L->Last + 1;
    int half = 0;
    while (low <= high)
    {
        half = (high + low) / 2;
        if (half == low || half == high)
        {
            return NotFound;
        }
        
        if (L->Data[half] == X) {
            return half;
        } 
        else if (L->Data[half] > X)
        {
            high = half;
        } 
        else if (L->Data[half] < X)
        {
            low = half;
        }
    }
    return NotFound;
}