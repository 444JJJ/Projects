#include<iostream>
using namespace std;

class Bank{
private:
    string name, actype;
    int bal,acno;

public:
    Bank(){
        cout<<"Enter account name: "<<endl;
        cin>>name;
        cout<<"Enter account type"<<endl;
        cin>>actype;
        cout<<"Enter account account number"<<endl;
        cin>>acno;
        cout<<"Enter opening balance"<<endl;
        cin>>bal;

    }

    void diposit(int amt){
        bal=bal+amt;
        cout<<"Balance after depsit: "<<bal<<endl;
    }

    void withdraw(int amt){

        if(amt>bal){
            cout<<"Insufficient funds"<<endl;

        }else{
        
            bal=bal-amt;
            cout<<"Balance after withdrawal: "<<bal<<endl;

        }
       
    }

    void display(){
        cout<<"------------------Account Details-------------"<<endl;
        cout<<"Account Name: "<<name<<endl;
        cout<<"Account Type: "<<actype<<endl;
        cout<<"Account Number: "<<acno<<endl;
        cout<<"Current Balance: "<<bal<<endl;
    }





};



int main(){
    system("clear");


    Bank objBank;
    int amount, choice;
    do{
        cout<<"----------------Main Menu---------------"<<endl;
        cout<<"1:- Deposit Money"<<endl;
        cout<<"2:- Withdraw money"<<endl;
        cout<<"3:- Display Account Detail"<<endl;
        cout<<"4:- Quit"<<endl;
        cout<<"Enter any choice:"<<endl;
        cin>>choice;

        switch (choice)
        {
        case 1:
            cout<<"Enter amount to deposit: "<<endl;
            cin>>amount;
            objBank.diposit(amount);
            break;
        case 2:
            cout<<"Enter amount to withdraw: "<<endl;
            cin>>amount;
            objBank.withdraw(amount);
            break;
        case 3:
            objBank.display();
            break;
        case 4:
            exit(1);



        default:
            cout<<"Invalid option selected"<<endl;
            break;
        }





    }while(1);




    return 0;
}