#include<iostream>
using namespace std;

int main(){



}



/*
What is a constructor?
-   A constructor is a member function of a class which initialises
    objects of a class. In C++ constructor is automatically called
    when an object(instance of class) is created. It is special member
    function of the class.
How are constructors different from a normal member function?
-   A constructor is different for normal functions in the following ways:
        1. Constructor has the same name as the class itself
        2. Constructor doesnt have return type
        3. A constructor is automatically called when an object is created
        4. If we do not specify a construtor, C++ compiler generates a default
           constructor for us (excepts no paramters and has an empty body)


Types for constrcutors?

1. Default constructors: Default constructor is the constructor which 
    does not take any argument. It has no parameters.

2. Parameterised constructor: It is possible to pass arguments to 
    constructors. Typically, these arguments help initialise when it
    is created. To creat an paramterised constructor, simply add
    parameters to it the way you would to any other function. When you
    define the constructor's body, use the parameters to initialise 
    the object.
3. Copy constructor: A copy constructor is a member function which
    initlizes an object using another object of the same class. 

*/



/*
Destructors in C++
-   Destrucor is a member function which destructs or deletes an object

When are destructors called?
-   The function ends.
-   THe programme ends.
-   A block containing local variables ends
-   A delete operator is called.

How destructors are different from a normal function?
-   Destructors have the same name as the class preceded by a tilde(~).
-   Destructors dont take any argument and dont return anything(not even void).


Can there be nore tan one destructor in a class?
-   No, there can only be one destructor in a class with classname
    preceded by ~, no parameters and no return type. 

When do we need to write a user-interface destructor?
-   If we do not write our own destrutor in class, compiler created a
    default constructor for us. The default destructor works fine unless
    we have dynamically allocated memory or pointer in class.

    When a class contains a pointer to memory allocated in class, we 
    should write a destructor to release memory before the class instance
    is destroyed. This must be done to aoid memory leakage.




*/