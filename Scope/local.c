#include <stdio.h>
int x;

void g() {
  x = x + 1;
}

int main() {
  x=5;
  g();
  printf("%d\n", x);
}