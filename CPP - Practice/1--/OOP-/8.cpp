#include<iostream>
using namespace std;

class Point{
public:
    double x,y;

    Point(){
        //default constructor
        //makes constructor with default values
        x=0;
        y=0;
        cout<<"default Call"<<endl;
    }
    Point(double X, double Y){
        x=X;
        y=Y;
        cout<<"Parameterised call"<<endl;
    }
    Point(const Point& rhs){
        x=rhs.x;
        y=rhs.y;
        cout<<"Copy constructor call"<<endl;
    }

};





int main(){
    Point p1;
    Point P2(1.3,3.4);
    Point p3=p1;





    return 0;
}