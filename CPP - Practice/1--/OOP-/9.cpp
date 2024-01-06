#include<iostream>
using namespace std;

class Test{
private:
    int n=0;

public:
    Test(){
        cout<<"Constructor is called"<<endl;
        n=0;
    }

    Test(int num){
        n=num;
    }

    void displat(){
        cout<<n<<endl;
    }



};


int main(){
    Test t1(20);

    t1.displat();






    return 0;
}