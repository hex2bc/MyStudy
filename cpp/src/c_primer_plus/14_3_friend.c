#include <stdio.h>
#define LEN 20

const char * msgs[5] = {
    "Thank you",
    "How do you do",
    "How are you",
    "Nice to meet you",
    "I'm fine, too."
};

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

int main(int argc, char const *argv[])
{
    struct guy fellow = {
        { "Ewen", "Villard" },
        "apple",
        "eng",
        250
    };
    printf("%s is %s : %s\n", fellow.handle.last, fellow.job, msgs[2]);
    return 0;
}

