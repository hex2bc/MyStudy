#include <stdio.h>
#define LEN 20

struct names {
    char first[LEN];
    char last[LEN];
};

struct guy {
    struct names handle;
    char favfood[LEN];
    char job[LEN];
    float income;
};

// barney.income == (*him).income == him->income // 假设 him == &barney
int main(int argc, char const *argv[])
{
    struct guy fellow[2] = {
        {{ "Ewen", "Villard" },
        "apple",
        "eng",
        250
        },
        {{ "Rodney", "Swillbelly" },
        "orange",
        "test",
        500
        }
    };

    struct guy * him;

    printf("address #1: %p #2: %p \n", &fellow[0], &fellow[1]);

    him = &fellow[0];
    printf("pointer #1: %p #2 %p \n", him, him + 1);

    printf("him->income is $%.2f: (*him).incomde is $%.2f\n", him->income, (*him).income);
    him++;
    printf("him->favfood is %s: him->handle.last is %s\n", him->favfood, him->handle.last);
    return 0;
}

