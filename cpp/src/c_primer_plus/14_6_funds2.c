#include <stdio.h>

#define FUNDLEN 50

struct funds {
    char bank[FUNDLEN];
    double bankfund;
    char save[FUNDLEN];
    double savefund;
};

double sum(const struct funds *);

int main(int argc, char const *argv[])
{
    struct funds stan = {
        "ICBC",
        3024.72,
        "Lucky's Savings and Loan",
        9237.11
    };

    printf("Stan has a total of $%.2f.\n", sum(&stan));
    return 0;
}

double sum(const struct funds * money)
{
    return (money->bankfund + money->savefund);
}

