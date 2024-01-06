#include<iostream>
using namespace std;

class Counter{
private:
    static int count;

public:
    Counter(){
        count++;
    }

    void showObject(){
        system("clear");
        cout<<"Total object is "<<count<<endl;

    }



};

int Counter::count=0;



int main(){
    Counter c1,c2,c3,c4,c5;
    c1.showObject();




    return 0;
}