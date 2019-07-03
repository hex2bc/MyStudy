#include <stdio.h>
#include <stdlib.h>
#include "include/17_3_list.h"
// #include "include/17_3_list2.h"
// #include "include/17_3_list3.h" 

#define TSIZE 45
void showmovies(Item item);

int main(int argc, char const *argv[])
{
    List movies;
    Item temp;
    
    InitList(&movies);

    if (ListIsFull(&movies))
    {
        printf("No memory!\n");
        exit(1);
    }
    printf("Enter first movie title: ");
    
    while(scanf("%[^\n]", temp.title) != 0 && temp.title[0] != '\0')
    {
        printf("Enter your rating <0-10>: ");
        scanf("%d", &temp.rating);
        while (getchar() != '\n')
        {
            continue;
        }

        if(AddItem(temp, &movies) == false)
        {
            printf("Error!");
            break;
        }

        if (ListIsFull(&movies))
        {
            printf("The list is now full!\n");
            break;
        }
        printf("Enter next movie title (empty line to stop): \n");
    }
    
    if (ListIsEmpty(&movies))
    {
        printf("No data entered!\n");
    } 
    else
    {
        printf("Here is the movie list: \n");
        Traverse(&movies, showmovies);
    }
    
    printf("You entered Movie: %d \n", ListItemCount(&movies));
    
    EmptyTheList(&movies);

    return 0;
}

void showmovies(Item item) {
    printf("Movie: %s Rating: %d\n", item.title, item.rating);
}
