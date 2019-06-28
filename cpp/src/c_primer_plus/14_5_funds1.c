#include <stdio.h>

#define FUNDLEN 50

struct funds {
    char bank[FUNDLEN];
    double bankfund;
    char save[FUNDLEN];
    double savefund;
};

double sum(double, double);
void modify(double *);

int main(int argc, char const *argv[])
{
    struct funds stan = {
        "ICBC",
        3024.72,
        "Lucky's Savings and Loan",
        9237.11
    };

    printf("Stan has a total of $%.2f.\n", sum(stan.bankfund, stan.savefund));

    printf("savefund %.2f \n", stan.savefund);
    modify(&stan.savefund);
    printf("after modify savefund %.2f \n", stan.savefund);
    return 0;
}

double sum(double x, double y)
{
    return (x + y);
}

void modify(double * x)
{
    *x = 250;
}
