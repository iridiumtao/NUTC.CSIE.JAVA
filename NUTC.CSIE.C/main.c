#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <time.h>

int main() {
    int a;  // variable 'a' of type int,
    // stores "value".

    int *p; // Pointer int,
    // Stores "address" of integer.
    // (* = asterisk sign)

    p = &a; // Stores the address of 'a' in 'p'.
    // (& = ampersand)
    // '&a' returns the address of the particular variable(&a).

    a = 20; // fill value '20' into 'a'

    // Let's say the address of 'a' is 204.
    // And the address of 'p' is 64.

    printf("%d\n", p);  // print the value that stores in 'p',
    // which is the address of 'a'. (line 14)
    // print '204'

    printf("%d\n", &a); // print the address of 'a'
    // print '204'

    printf("%d\n", &p); // print the address of 'p'
    // print '64'


    printf("%d\n", *p); // print the value that 'p' points to,
    // which is the value of 'a'
    // print '20'
    // '*p' returns the value at the location that points to
    // also called 'Dereferencing'
    *p = 8;

    printf("%d\n", a);  // print '8'



}