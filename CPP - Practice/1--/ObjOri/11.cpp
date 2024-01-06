#include<iostream>
using namespace std;

class NumOfObjCreated{
private:
    static int counter;
public:

    NumOfObjCreated(){
        counter++;
        numberOfObjs();
    }

    void numberOfObjs(){
        cout<<"Total objects are: "<<counter<<endl;
    }





};

int NumOfObjCreated::counter=0;



int main(){
    NumOfObjCreated c1,c2,c3;




    return 0;
}