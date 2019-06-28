#include <stdio.h>
#include <string.h>

struct namect {
    char fname[20];
    char lname[20];
    int letters;
} names;

struct namect getinfo();
struct namect makeinfo(struct namect);
void showinfo(struct namect);

int main(int argc, char const *argv[])
{
    struct namect person;

    person = getinfo();
    person = makeinfo(person);
    showinfo(person);

    return 0;
}

struct namect getinfo()
{
    struct namect temp;
    printf("first name: \n");
    scanf("%s", temp.fname);
    printf("last name: \n");
    scanf("%s", temp.lname);
    return temp;
}

struct namect makeinfo(struct namect pst)
{
    pst.letters = strlen(pst.fname) + strlen(pst.lname);
    return pst;
}

void showinfo(struct namect pst)
{
    printf("%s %s, your name contains %d letters.\n", pst.fname, pst.lname, pst.letters);
}
