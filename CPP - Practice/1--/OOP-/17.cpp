#include<iostream>
using namespace std;

// Passing objects as functions


class Distance{
private:
    int km,hr;
public:
    Distance():km(0),hr(0){


    }

    void get(){
        cout<<"Enter distance in KM: "<<endl;
        cin>>km;
        cout<<"Enter hour of distance: "<<endl;
        cin>>hr;
    }

    void show(){
        cout<<"Your Traveled is: "<<km<<" km "<<hr<<" hours "<<endl;
    }

    void TotalDistance(Distance tot){
        Distance t;
        t.km=km+tot.km;
        t.hr=hr+tot.hr;
        cout<<"Total distance travelled is: "<<t.km<<" km in "<<t.hr<<endl;
    }


};

int main(){

    Distance yourDis,myDis;
    cout<<"----------Your input of distance--------------"<<endl;
    yourDis.get();
    yourDis.show();

    cout<<"----------My Input of distance-----------------"<<endl;
    myDis.get();
    myDis.show();


    cout<<"----------------Total distance output--------------"<<endl;
    yourDis.TotalDistance(myDis);






    return 0;
}