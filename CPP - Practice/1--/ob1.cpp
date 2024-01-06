#include<iostream>
using namespace std;

class Entity{
    public:
    float X, Y;

    void Print(){
        cout<<X<<", "<<Y<<endl;
    }

    Entity(float x, float y){
        X=x;
        Y=y;
    }


};


int main(){

    Entity e=Entity(10.0f,5.0f);
    e.Print();

   // cin<<get();



    return 0;
}