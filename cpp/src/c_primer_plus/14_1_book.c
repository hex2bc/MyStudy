#include <stdio.h>

#define MAXTITL 41
#define MAXAUTL 31

void initStruct();

struct book
{
    char title[MAXTITL];
    char author[MAXAUTL];
    float value;
};

/* 
struct book library; 等于
struct book
{
    char title[MAXTITL];
    char author[MAXAUTL];
    float value;
} library;
*/


int main(int argc, char const *argv[])
{
    struct book library;
    initStruct();
    printf("enter book title:\n");
    scanf("%s", library.title);
    printf("enter the author:\n");
    scanf("%s", library.author);
    printf("enter the value:\n");
    scanf("%f", &library.value);
    printf("%s by %s: ($ %.2f)\n", library.title, library.author, library.value);
    return 0;
}

void initStruct()
{
    struct book book1= {
        "Prime plus",
        "hello",
        65
    };

    struct book book2 = {
        .value = 70,
        .author = "huangqw"
    };

    printf("%s by %s: ($ %.2f)\n", book1.title, book1.author, book1.value);
    printf("%s by %s: ($ %.2f)\n", book2.title, book2.author, book2.value);
}
