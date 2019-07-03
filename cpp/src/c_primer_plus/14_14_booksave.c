#include <stdio.h>
#include <stdlib.h>
#define MAXTITL 40
#define MAXAUTL 40
#define MAXBKS 10
struct book {
    char title[MAXTITL];
    char author[MAXAUTL];
    float value;
};

int main(int argc, char const *argv[])
{
    struct book library[MAXBKS];
    int count = 0;
    int index, filecount;
    FILE * pbooks;
    int size = sizeof(struct book);

    if ((pbooks = fopen("out/book.dat", "a+b")) == NULL)
    {
        printf("Error: Can not open book.dat file.\n");
        exit(1);
    }
    rewind(pbooks);
    while(count < MAXBKS && fread(&library[count], size, 1, pbooks) == 1)
    {
        if (count == 0) 
            printf("Current contents of book.dat: ");
        printf("%s by %s: $%.2f\n", library[count].title, library[count].author, library[count].value);
        count++;
    }
    filecount = count;
    if (count == MAXBKS)
    {
        printf("The book.dat file is full");
        exit(0);
    }
    
    printf("enter book title:\n");

    while (count < MAXBKS && scanf("%[^\n]", library[count].title) != 0
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
            fwrite(&library[filecount], size, count - filecount, pbooks);
        }
    }
    fclose(pbooks);
    return 0;
}
