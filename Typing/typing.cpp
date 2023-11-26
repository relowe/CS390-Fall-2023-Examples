#include <iostream>
#include <string>

int main()
{
  int i;
  double d;
  char c;
  std::string s;

  //attempt to assign an integer to a double
  i = 1;
  d = i;
  std::cout << d << std::endl;

  //mix types together
  std::cout << 1 + 1.5 << std::endl;

  //attempt to assign a double to an integer
  d = 1.5;
  i = d;
  std::cout << i << std::endl;

  //attempt to assign a double to a character
  d = 65.99999;
  c = d;
  std::cout << c << std::endl;

  //what about strings?
  /* Cannot do this:
  s = "String: ";
  s = s+d;
  std::cout << s << std::endl;
  */
  
  s = "String: ";
  s = s+c;
  std::cout << s << std::endl;

  int ar[10];
  ar[0] = d;
}