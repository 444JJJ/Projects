#include<iostream>
#include<string>
using namespace std;

class Cars{
private:
    string companyName;
    string modelName;
    string fuelType;
    float mileage;
    double price;
public:

    Cars(){
        //default constructor
        cout<<"default constructor called..."<<endl;
        companyName="toyota";
    }





};





int main(){
    Cars c1;
    




    return 0;
}