#include <stdio.h>

#define MAXTITL 41
#define MAXAUTL 31
#define MAXBKS 5

struct book
{
    char title[MAXTITL];
    char author[MAXAUTL];
    float value;
};



int main(int argc, char const *argv[])
{
    struct book library[MAXBKS];
    int count = 0;
    int index;
    printf("enter book title:\n");

    while (count < MAXBKS && scanf("%s", library[count].title) != 0
                          && library[count].title[0] != '\0')
    {
        printf("enter the author:\n");
        scanf("%s", library[count].author);
        printf("enter the value:\n");
        scanf("%f", &library[count++].value);
        while (getchar() != '\n')
        {
            continue;
        }
        if (count < MAXBKS)
        {
            printf("Enter the next title.\n");
        }
    }

    if (count > 0)
    {
        for (index = 0; index < count; index++)
        {
            printf("%s by %s: ($ %.2f)\n", library[index].title, library[index].author, library[index].value);
        }
        
    }
    
    return 0;
}

