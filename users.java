/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author SALSABIL
 */
public class users {
    protected int id;
    protected String name;
    protected String password;
    protected String email;
    protected String location;
    protected int phone;
    protected String type;
    protected Ewallet mywallet;

    
        public users() {}
    
    public users(int id,String name,String password ,String email,String location, int phone,String type) {
         this.id = id;
         this.name = name;
        this.password = password;
        this.email = email;
        this.location = location;
        this.phone = phone;
        this.type = type;

    }

    
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


        

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }
    
        public Ewallet getMywallet() {
        return mywallet;
    }

    public void setMywallet(Ewallet mywallet) {
        this.mywallet = mywallet;
    }
    public void SignUp(int id,String name,String password ,String email,String location,int phone){
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.location = location;
        this.phone = phone;
        
    }
    
    public void logIn(ArrayList<users>listOfUsers,ArrayList<playground>listOfGrounds){
         Scanner input=new Scanner(System.in);
         
         System.out.print("enter email: ");
         String email=input.next();
            System.out.print("enter password: ");
          String  password=input.next();
           
          int count=-1;
            for(int i=0;i<listOfUsers.size();i++){
                        
            if(email.equals(listOfUsers.get(i).getEmail())&&password.equals(listOfUsers.get(i).getPassword())){
                           count=i;
            }
            }
             if(count==-1){
                            System.out.println("invalid login! ");

            }
             
             else{
             listOfUsers.get(count).menu(listOfGrounds,listOfUsers);
             }
        


    }
    
    
    public  void checkEwallet(){
    
        System.out.println(mywallet.getBalance());
    }
    
public void  menu(ArrayList<playground>listOfGrounds,ArrayList<users>listOfUsers){}
    
     public ArrayList<String> getInvitation() {return null;}

    @Override
    public String toString() {
        return  email ;
    }

     
}







