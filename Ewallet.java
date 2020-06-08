/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author zezo
 */
public class Ewallet {
    
  private  int  id;
  private  String Password;
  private  float  balance=200;
  
    public Ewallet() {
    }

  
      public Ewallet(int id, String Password) {
        this.id = id;
        this.Password = Password;
    }
      
    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }




    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

  

boolean transaction(Ewallet x, float value ){
if(this.balance-value >=0){
    this.balance-=value;
    x.balance+=value;
return  true;
}
else{return  false;} 
}

boolean check(int id,String password){

if( this.id==id && this.Password.equals(password)){
    return  true;}

else{return  false;}
}

}