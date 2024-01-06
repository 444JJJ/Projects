





/*

Access specifiers in C++ class defines the access control rules.
C++ has 3 new keywords introduced, namely.
    1. public
    2. private
    3. protected
These access specifiers are used to set boundaries for the availablilty
of members of class be it data member or member functions.

Access specifiers in the programme, are followed by a colon.

You can use wither one, two, or all the three specifiers in the same 
class to set differernt boundaries for differerent class members. 


Public: 
Public means all the class members declared under public will be 
available to everyone. 

The data members and member functions declared public can be accessed
by other classes too.

Hence there are changes that they might change them. 

So they key members must not be declared public.


Private:
Private keyword, means that no one can access the class members
declared private outside that class. 

If someone tries to access the private member, they will get a compile
error.

By default class variables and member functions are private.

Protected, is the last access specifier, and it is similar to private, 
it makes class member inaccessible outside the class. 

But they can be accessed by any subclass of that class. (if class A
is inherited by class B, then class B is subclass of class A. We will
learn this later in inheritance Topic.)



*/