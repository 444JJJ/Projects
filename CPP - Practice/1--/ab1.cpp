#include<iostream>
using namespace std;

class Smartphone{
public: 
    virtual void TakeASelfie()=0;

};

class Android:public Smartphone{
public: 
    void TakeASelfie(){
        cout<<"Android selfie\n";
    }

};

class IPhone:public Smartphone{
public:
    void TakeASelfie(){
        cout<<"Iphone selfie\n";
    }


};



int main(){

    Smartphone *s1=new IPhone();
    s1->TakeASelfie();





    return 0;
}