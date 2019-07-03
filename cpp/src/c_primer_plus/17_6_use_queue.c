#include <stdio.h>
#include "include/17_6_queue.h"

int main(int argc, char const *argv[])
{
    Queue line;
    Item temp;
    char ch;

    InitQueue(&line);

    printf("a --> add, d --> delete, q --> quit\n");

    while((ch = getchar()) != 'q')
    {
        if(ch != 'a' && ch != 'd')
            continue;
        if(ch == 'a')
        {
            printf("Integer to add: ");
            scanf("%d", &temp);
            if (!QueueIsFull(&line))
            {
                printf("Putting %d into queue\n", temp);
                EnQueue(temp, &line);
            }
            else
            {
                printf("Queue is full!\n");
            }
        }
        else
        {
            if(QueueIsEmpty(&line))
            {
                printf("Nothing to delete!\n");
            }
            else
            {
                DeQueue(&temp, &line);
                printf("Removing %d from queue\n", temp);
            }
        }
        printf("%d items in queue\n", QueueItemCount(&line));
        printf("a --> add, d --> delete, q --> quit\n");
        
    }
    EmptyTheQueue(&line);
    return 0;
}
