#include<iostream>
using namespace std;

class User{
    string status="Gold";
    public:
        string fName;
        string lName;

        string getStatus(){
            return status();
        }

        void setStatus(string status){
            if(status=="Gold"||status=="Silver"||status=="Bronze"){
            this->status=status;

            }else{
                this->status="No status";
            }
        }

    User(string fname, string lname,string status){
        this->fName=fname;
        this->lName=lname;
        this->status=status;
    }    

    ~User(){
        cout<<"Destructor\n";
    }

};

int addUser(vector<User> &users, User user){
    
}


int main(){





    return 0;
}