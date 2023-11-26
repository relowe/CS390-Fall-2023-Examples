#include <stdio.h>

int main()
{
  int j = 12;

  {
    int j=6;
  }

  printf("%d\n", j);
}