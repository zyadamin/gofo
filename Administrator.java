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
public class Administrator extends users {

    public Administrator() {
    }

    public Administrator(int id, String name, String password, String email, String location, int phone) {
        super(id, name, password, email, location, phone,"Admin");
    }
    
    @Override
      public void menu(ArrayList<playground>listOfGrounds,ArrayList<users>listOfUsers){
       
int choose;
        Scanner input = new Scanner(System.in);
       
       System.out.println("\nHello "+this.name);
             char again;
       do{
       System.out.println("\nwhat would you like to do?");
       System.out.println("1-approve playground");
       System.out.println("2-activate playground ");
       System.out.println("3-suspend playground");
       System.out.println("4-delete playground ");
       
       choose =input.nextInt();   
         
       while (choose <1 || choose >4) {               
         System.out.println("Enter valid number ");
          choose=input.nextInt();       
          
         }
      
       if(choose==1){
      this.approvePlayground(listOfGrounds);
      }
       
      else if(choose==2){
      this.activatPlayground(listOfGrounds);
      }
       
      else  if(choose==3){
      this.suspendPlayground(listOfGrounds);
      }
      
      else if(choose==4){
      this.deletePlayground(listOfGrounds);
      }
       
     System.out.println("another option?");
     again=input.next().charAt(0);
    }while(again!='n');            
      
     }
      
    public void approvePlayground(ArrayList<playground>listOfGrounds){
    
    Scanner input = new Scanner(System.in);

    int count,done;
    String again;
    do{
        count=1;
    for(int i=0 ;i<listOfGrounds.size();i++){
    
    if("pending".equals(listOfGrounds.get(i).getState())){
        System.out.print(count+"- ");
        listOfGrounds.get(i).toString();
        count++;
    }
    }
    
    System.out.println("\nEnter playground name ");
    do{
      done=0;
    String x=input.next();

     for(int i=0 ;i<listOfGrounds.size();i++){
    
    if(x.equals(listOfGrounds.get(i).getName())){
        listOfGrounds.get(i).setState("active");
       done++;
       count--;
    }
    
    }
         
    if(done==0){ System.out.println("try again ");} 
    }while(done<1);
    
    if(count-1==0){break;}
    System.out.println("approve another ground? ");
    again=input.next();
    }while(!"n".equals(again));

    
}

public void activatPlayground(ArrayList<playground>listOfGrounds){


    Scanner input = new Scanner(System.in);

    int count,done;
    String again;
    do{
        count=1;
    for(int i=0 ;i<listOfGrounds.size();i++){
    
    if("suspend".equals(listOfGrounds.get(i).getState())){
        System.out.print(count+"- ");
        listOfGrounds.get(i).toString();
        count++;
    }
    }
    
    System.out.println("\nEnter playground name: ");
    do{
      done=0;
    String x=input.next();

     for(int i=0 ;i<listOfGrounds.size();i++){
    
    if(x.equals(listOfGrounds.get(i).getName())){
        listOfGrounds.get(i).setState("active");
       done++;
    count--;
    }
    
    }
         
    if(done==0){ System.out.println("try again!");} 
    }while(done<1);
    
    if(count-1==0){break;}
    System.out.println("activat another ground? ");
    again=input.next();
    }while(!"n".equals(again));


}
    
public void suspendPlayground(ArrayList<playground>listOfGrounds){


    Scanner input = new Scanner(System.in);

    int count,done;
    String again;
    do{
        count=1;
    for(int i=0 ;i<listOfGrounds.size();i++){
    
    if("active".equals(listOfGrounds.get(i).getState())){
        System.out.print(count+"- ");
        listOfGrounds.get(i).toString();
        count++;
    }
    }
    
    System.out.println("\nEnter playground name: ");
    do{
    done=0;
    String x=input.next();

     for(int i=0 ;i<listOfGrounds.size();i++){
    
    if(x.equals(listOfGrounds.get(i).getName())){
        listOfGrounds.get(i).setState("suspend");
       done++;
       count--;
    }
    
    }
         
    if(done==0){ System.out.println("try again!");} 
    }while(done<1);
    
    if(count-1==0){break;}
    
    System.out.print("suspend another ground? ");
    again=input.next();
    }while(!"n".equals(again));


}

 public void deletePlayground(ArrayList<playground>listOfGrounds){
    
    Scanner input = new Scanner(System.in);

    int done,count = 0;
    
    char again;
    do{
    for(int i=0 ;i<listOfGrounds.size();i++){
    
        System.out.print((i+1)+"- ");
        listOfGrounds.get(i).toString();
       }
    
    
    System.out.println("\nEnter playground name: ");
    do{
      done=0;
    String x=input.next();

     for(int i=0 ;i<listOfGrounds.size();i++){
    
    if(x.equals(listOfGrounds.get(i).getName())){
       count=i;
       done++;
    }
    
     }
     
     listOfGrounds.remove(count);
         
    if(done==0){ System.out.println("try again");} 
    }while(done<1);
    
    if(listOfGrounds.isEmpty()){break;}
    System.out.println("delete another ground ?");
    again=input.next().charAt(0);
    }while(again!='n');


}
    

}