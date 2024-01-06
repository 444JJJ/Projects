#include<iostream>
using namespace std;

class Distance{
private:
    int km, hr;

public:
    Distance():km(0),hr(0){

    }

    void get(){
        cout<<"Enter Distance in KM: ";
        cin>>km;
        cout<<"Enter Hours of Distance: ";
        cin>>hr;
    }

    void show(){
        cout<<"You Traveled distance is "<<km<<"km in "<<hr<<" hours"<<endl;
    }

    void TotalDis(Distance tot){
        Distance t;
        t.km=km+tot.km;
        t.hr=hr+tot.hr;
        cout<<"Total distance traveled is: "<<t.km<<"km in "<<t.hr<<" hours."<<endl;

    }



};


int main(){
    Distance yourDis,myDis;

    cout<<"--------Your Input of Distance---------"<<endl;
    yourDis.get();
    yourDis.show();

    cout<<"---------My Input of Distance----------"<<endl;
    myDis.get();
    myDis.show();

    cout<<"---------Total Output of Distance------"<<endl;
    yourDis.TotalDis(myDis);
    



    return 0;
}


