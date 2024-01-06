#include<iostream>
using namespace std;

class Square:public Shape{
    
}


int main(){

    Shape *shapes[]=
    {
        new Square (5),
        new Triangle (8,10),
        new Square(7),
        new Triangle(3,4)
    }

    for(int i=0;i<4;i++){
        cout<<"Shape"<<i<<": "<<shapes[i]->area()<<endl;
    }




    return 0;
}