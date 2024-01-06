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
    Cars():companyName("BMW"){
        
    }

    Cars(string cname, string mname, string ftype, float m, double p){
        companyName=cname;
        modelName=mname;
        fuelType=ftype;
        mileage=m;
        price=p;

    }


    Cars(Cars &obj){
        companyName=obj.companyName;
        modelName=obj.modelName;
        fuelType=obj.fuelType;
        mileage=obj.mileage;
        price=obj.price;


    }




    void setData(string cname, string mname, string ftype, float m, double p){
        companyName=cname;
        modelName=mname;
        fuelType=ftype;
        mileage=m;
        price=p;

    }

    void displayData(){
        cout<<"Car Properties: "<<endl;
        cout<<"Car Company Name: "<<companyName<<endl;
        cout<<"Car Model Name: "<<modelName<<endl;
        cout<<"Car Fuel Type: "<<fuelType<<endl;
        cout<<"Car Mileage: "<<mileage<<endl;
        cout<<"Car Price: "<<price<<endl;
    }


    ~Cars(){
        cout<<"destructor called"<<endl;
    }




};




int main(){

    Cars c1;
    cout<<"Deafult contructor called"<<endl;
    c1.setData("toyota", "altis", "petrol", 15.5,15000);
    c1.displayData();
    cout<<endl;

    Cars c2("Toyota","Fourrunner", "diesel", 350654,22599);
    cout<<"Parameterised contructor called"<<endl;
    c2.displayData();
    cout<<endl;


    Cars c3=c1;
    cout<<"Copy contructor called"<<endl;
    c3.displayData();
    cout<<endl;



    return 0;
}