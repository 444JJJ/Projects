#include<iostream>
using namespace std;

class ClassName{
    //field;
    //method
};

class Test{
    private:
    int n=10;
    public:
    void show(){
        cout<<"The value of n: "<<n<<endl;
    }
};


int main(){

    Test t1;
    t1.show();

    return 0;
}


/*
Object oriented programming is a programming style that is associated
with the concept of class, objects and various other concepts revolving 
around these two, like inheritance, polymorphism, abstraction, 
encapsulation etc.

Object oriented programing aims to implement real world 
entities like inheritance, hiding, polymorphism etc in 
programming. 

The main aim of OOP is to bind together the data and the functions 
that operate on them so that no other part of code can access this 
data except that function. 

Introduction OOP

Classes and Objects in OOP Using C++

A class is an entity that determines how an object will behave and 
what the object will contain. 

In other words, it is a blueprint or a set of instruction to build a 
specific type of object. 

The classes and objects are the most important features of c++.

A class is similar to structure but it provides more advanced features.

When you define a class you define a blueprint for a data type.

This doesnt actually define any data but it does define what the class
name means that is what an object of the class will consist of and what
operations can be performed on such an object.

A class definition starts with the keyword class followed by the class
name and the class body, enclosed by a pair of curly braces.

A class definition must be followed either by a semicolon or a list of
declarations. 

This is the basic unit of object oriented programming.

That is both data and function that operate on data are bundled as a
unit called as object. 



*/