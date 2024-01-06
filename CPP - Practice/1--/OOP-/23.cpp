#include<iostream>
using namespace std;

class B;

class A{
    private:
    int num1;
    
    public:
    void getValueA();
        friend void Add(A,B);




};

void A::getValueA(){
    cout<<"Enter first number:";
    cin>>num1;
}

class B{
    private:
    int num2;
    
    public:
    void getValueB();

    friend void Add(A,B);


};

void B::getValueB(){
    cout<<"Enter second number:";
    cin>>num2;

}

void Add(A obj1,B obj2){
    cout<<"The result is: "<<obj1.num1+obj2.num2<<endl;
}




int main(){
    A obj1;
    B obj2;

    obj1.getValueA();
    obj2.getValueB();
    Add(obj1,obj2);



    return 0;
}