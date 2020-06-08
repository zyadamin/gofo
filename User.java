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
public class User {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Scanner input=new Scanner(System.in);

          ArrayList<users>listOfUsers= new ArrayList<users>();
          ArrayList<playground>listOfGrounds= new ArrayList<playground>();
         
          

            Player b1=new Player(1, "youssef", "1234", "youssef@yahoo.com", "giza",22 );
          listOfUsers.add(b1);
            Player b3=new Player(2, "ahmed", "1234", "ahmed@yahoo.com", "giza",22 );
          listOfUsers.add(b3);
            Player b4=new Player(3, "ziad", "1234", "ziad@yahoo.com", "giza",22 );
          listOfUsers.add(b4);
            Player b5=new Player(4, "mostafa", "1234", "mostafa@yahoo.com", "giza",22 );
          listOfUsers.add(b5);
          
          Administrator a1=new Administrator(5, "zyad", "admin", "admin", "giza",22 );
          listOfUsers.add(a1);
          
          PlaygroundOwner a3=new PlaygroundOwner(6, "rehab", "1234", "rehab@yahoo.com", "giza",22 );
          listOfUsers.add(a3);
          
          PlaygroundOwner a4=new PlaygroundOwner(7, "salsbel", "1234", "salsbel@yahoo.com", "giza",22 );
          listOfUsers.add(a4);
          
          
       char again;
               int choose = 0;

       do{
                   
        System.out.print("1-create new account\n");
        System.out.print("2-LogIn\n");
        choose=input.nextInt(); 
        
        while (choose <1 || choose >2) {               
                 System.out.println("Enter valid number ");
                 choose=input.nextInt();       
           }
 


        if(choose==1){
         
            int ch=0;
           System.out.print("1-Player\n");
           System.out.print("2-playgroundOwner\n");
           
            ch=input.nextInt(); 
           
         while (ch <1 || ch >2) {               
           System.out.println("Enter valid number ");
           ch=input.nextInt();       
           
         }
            System.out.print("enter id:  ");
            int id=input.nextInt();
           System.out.print("enter  name:  ");
            String name=input.next();
           System.out.print("enter password:  ");
           String password=input.next();
            System.out.print("enter email:  ");
            String email=input.next();
            
              Ewallet wallet =new Ewallet(id,password);
            

           if(ch==1){
               
               
           System.out.print("enter location:  ");
            String location=input.next();
           System.out.print("enter phone:  ");
           int phone=input.nextInt();

               Player x = new Player();
               x.setType("player");
               x.setMywallet(wallet);
               x.SignUp(id ,name, password, email, location, phone);
               listOfUsers.add(x);
      
           }
              else if(ch==2){
               PlaygroundOwner y = new PlaygroundOwner();   
               y.setType("Owner");
               y.setMywallet(wallet);
               y.SignUp(id ,name, password, email, "", 0000);
               listOfUsers.add(y);
      
           }
             
              else{System.out.print("please enter valid number ");}
   
            
        }
        else if (choose==2){
      
            users one= new users();
           one.logIn(listOfUsers,listOfGrounds);

        }
             
      System.out.println("another thing? ");
       again=input.next().charAt(0);
      } while(again!='n');
     
    }
}
