#include <stdio.h>

#define FUNDLEN 50
#define N 2

struct funds {
    char bank[FUNDLEN];
    double bankfund;
    char save[FUNDLEN];
    double savefund;
};

double sum(const struct funds money[], int n);

int main(int argc, char const *argv[])
{
    struct funds jones[N] = {
        {
            "ICBC",
            3024.72,
            "Lucky's Savings and Loan",
            9237.11
        },
        {
            "BBC",
            3534.28,
            "Saveing",
            3203.89
        }
    };

    printf("Stan has a total of $%.2f.\n", sum(jones, N));

    return 0;
}

double sum(const struct funds money[], int n)
{
    double total;
    int i;
    for (i = 0; i < n; i++)
    {
        total += money[i].bankfund + money[i].savefund;
    }
    return total;
}

