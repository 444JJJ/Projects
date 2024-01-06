#include<iostream>
using namespace std;

class Counter{
    private:
        static int count;

    public: 
        Counter(){
            count++;


        }

        void showCount(){
            cout<<"You created "<<count<<" object of this class"<<endl;
        }





};

int Counter::count=0;

int main(){
    Counter c1,c2,c3,c4,c5;
    c1.showCount();
    Counter a,b,c,d;
    a.showCount();



    return 0;
}