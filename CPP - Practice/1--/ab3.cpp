#include<iostream>
using namespace std;

class Rectangle{
    private:
    int width, height;

    public: 
    void setVals(int x, int y){width=x,height=y};
    int area(){return width*height}
    int getWidth(){return width}
    int getHeight(){return height}


};


class Rocket{
    void fly(){

    }
};


int main(){
    Rectangle obj1;


    return 0;
}