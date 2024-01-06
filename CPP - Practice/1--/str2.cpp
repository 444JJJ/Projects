#include<iostream>
using namespace std;

struct SmartPhones{
    string name;
    int storageSpace;
    string color;
    float price;


};

struct Person{
    string name;
    int age;
    SmartPhones smartPhone;
    
};


void printSmartPhoneInfo(SmartPhones smartphone){

    cout<<smartphone.name<<" "<<smartphone.storageSpace<<" "<<" "<<smartphone.color<<" "<<smartphone.price<<endl;


}

void printPersonInfo(Person pp){
    cout<<"Name: "<<pp.name<<endl;
    cout<<"Age: "<<pp.age<<endl;
    cout<<"SmartPhone: "<<pp.smartPhone<<endl;
    printSmartPhoneInfo(pp.smartPhone);

}


int main(){

    SmartPhones ios;

    ios.name="iPhone 12";
    ios.storageSpace=64;
    ios.color="Black";
    ios.price=999.99;

    SmartPhones Android;

    Android.name="Samsung Galaxy S21 Ultra";
    Android.storageSpace=128;
    Android.color="Silver";
    Android.price=888.88;

    printSmartPhoneInfo(ios);
    printSmartPhoneInfo(Android);


    Person p1;
    p1.name="John";
    p1.age=24;
    p1.smartPhone=ios;
    printPersonInfo(p1);






    return 0;
}