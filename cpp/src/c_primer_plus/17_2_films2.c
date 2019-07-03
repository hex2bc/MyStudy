#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define TSIZE 45

struct film {
    char title[TSIZE];
    int rating;
    struct film *next;
};

int main(int argc, char const *argv[])
{
    struct film *head = NULL;
    struct film *prev, *current;
    char input[TSIZE]; 
    int i = 0;
    int j;

    printf("Enter first movie title: ");
    while(scanf("%[^\n]", input) != 0 && input != '\0')
    {
        current = (struct film *) malloc(sizeof(struct film));
        if (head == NULL)
        {
            head = current;
        } 
        else
        {
            prev->next = current;
        }

        current->next = NULL;
        strcpy(current->title, input);
        
        printf("Enter your rating<0-10>: ");

        scanf("%d", &current->rating);
        while (getchar() != '\n')
        {
            continue;
        }
        printf("Enter next movie title (empty line to stop): ");
        prev = current;
    }
    
    current = head;
    while (current != NULL)
    {
        printf("Movie: %s Rating: %d\n", current->title, current->rating);
        current = current->next;
    }
    return 0;
}
