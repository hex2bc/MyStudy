#include <stdio.h>

#define TSIZE 45
#define FMAX 5

struct film {
    char title[TSIZE];
    int rating;
};

int main(int argc, char const *argv[])
{
    struct film movies[FMAX];
    int i = 0;
    int j;

    printf("Enter first movie title: ");
    while(i < FMAX && scanf("%[^\n]", movies[i].title) != 0 &&
        movies[i].title != '\0')
    {
        printf("Enter your rating<0-10>: ");
        scanf("%d", &movies[i++].rating);
        while (getchar() != '\n')
        {
            continue;
        }
        printf("Enter next movie title (empty line to stop): ");
    }
    
    for(j = 0;j < i;j++) 
    {
        printf("Movie: %s Rating: %d\n", movies[j].title, movies[j].rating);
    }
    return 0;
}
