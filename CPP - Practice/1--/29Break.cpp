#include<iostream>
using namespace std;

int main(){

    int counter;


    for(counter=1;counter<=5;counter++){
        int incounter;
        for(incounter=1;incounter<=3;incounter++){
            cout<<incounter<<endl;
            if(incounter==2)
            break;
        }
    }



    return 0;
}