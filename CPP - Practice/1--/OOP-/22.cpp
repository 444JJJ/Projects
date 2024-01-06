#include<iostream>
using namespace std;

class Test{
    private:
        int num;
    
    public:
        Test():num(0){
            cout<<"Construtor is called..."<<endl;
        }

        friend void show(Test obj1);




};

void show(Test obj1){
    obj1.num=10;
    //cout<<"I am simple function"<<endl;
    cout<<"The value of num:"<<obj1.num<<endl;
}





int main(){
    Test obj1;
    show(obj1);



    return 0;
}