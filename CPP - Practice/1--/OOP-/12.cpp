#include<iostream>
#include<string>
using namespace std;

class Cars{
private:
    string company_name;
    string model_name;
    string fuel_type;
    float mileage;
    double price;
public:

    Cars(){
        //default constructor
        cout<<"default constructor called..."<<endl;
        company_name="toyota";
        

    }

    //Parameterised constructor
    Cars(string cname, string mname, string ftype, float m, double p){
        cout<<"Parameterised Constructor Called..."<<endl;
        company_name=cname;
        model_name=mname;
        fuel_type=ftype;
        mileage=m;
        price=p;
    }

    //Copy constructor
    Cars(Cars &obj){
        cout<<"Copy Constructor Called..."<<endl;
        company_name=obj.company_name;
        model_name=obj.model_name;
        fuel_type=obj.fuel_type;
        mileage=obj.mileage;
        price=obj.price;
    }




    void setData(string cname, string mname, string ftype, float m, double p){
        company_name=cname;
        model_name=mname;
        fuel_type=ftype;
        mileage=m;
        price=p;
    }

    void display(){
        cout<<"-------------Car Properties---------------"<<endl;
        cout<<"Car Company "<<company_name<<endl;
        cout<<"Car Model "<<model_name<<endl;
        cout<<"Car Fuel Type "<<fuel_type<<endl;
        cout<<"Car Mileage "<<mileage<<endl;
        cout<<"Car price "<<price<<endl;
        cout<<endl;
    }

    ~Cars(){
        cout<<"Destructor Called"<<endl;
    }
    

// 1234

};


int main(){

    Cars car1,car2("Toyota","4Runner","Petrol",125000,15000);
    car1.setData("toyota","prius","petrol",350000,2500);
    car1.display();
    car2.display();

    Cars car3=car1;//copy constructor is called
    car3.display();



    return 0;
}