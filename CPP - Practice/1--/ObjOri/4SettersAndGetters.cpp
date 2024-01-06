#include<iostream>
using namespace std;

class Book{
private:
    int page;
    float price;
    string name;


public:
    void setPage(int sPage){
        page=sPage;
    }
    void setPrice(float sPrice){
        price=sPrice;
    }
    void setName(string sName){
        name=sName;
    }

    int getPage(){
        return page;
    }
    float getPrice(){
        return price;
    }
    string getName(){
        return name;
    }

};



int main(){
    Book b1,b2;
    b1.setName("AnotherBook");
    b1.setPrice(155.0);
    b1.setPage(100);

    cout<<"The name of the book is: "<<b1.getName();
    cout<<" It has "<<b1.getPage()<<" number of pages";
    cout<<" and it costs "<<b1.getPrice();

    return 0;
}


//123