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
public class Player extends users {
String[] team=new String[4];
String Ground_Name;
String Ground_Time;
ArrayList<String>invitation= new ArrayList<String>();

public Player(){}

    public Player(int id, String name, String password, String email, String location, int phone) {
        super(id, name, password, email, location, phone,"Player");
         mywallet= new Ewallet(id, password);
    }


    public String[] getTeam() {
        return team;
    }

    public void setTeam(String[] team) {
        this.team = team;
    }

    public String getGround_Name() {
        return Ground_Name;
    }

    public void setGround_Name(String Ground_Name) {
        this.Ground_Name = Ground_Name;
    }

    public String getGround_Time() {
        return Ground_Time;
    }

    public void setGround_Time(String Ground_Time) {
        this.Ground_Time = Ground_Time;
    }

@Override
    public ArrayList<String> getInvitation() {
        return invitation;
    }

    public void setInvitation(ArrayList<String> invitation) {
        this.invitation = invitation;
    }
    
    @Override
   public  void menu(ArrayList<playground>listOfGrounds,ArrayList<users>listOfUsers){
       
          int choose;
          
         for(int i=0;i<invitation.size();i++){
             System.out.println(invitation.get(i)+"/n");
             
}
               char again;
       do{  
           
        Scanner input = new Scanner(System.in);
       System.out.println("\nHello "+this.name); 
       System.out.println("what would you like to do?");
       System.out.println("1-Book playground");
       System.out.println("2-send invetation");
       System.out.println("3-cancel playground");
       System.out.println("4-edit profile info");
       System.out.println("5-view playing hours");
       System.out.println("6-create team");
       System.out.println("7-check Ewallet");
       choose =input.nextInt();
       
          while (choose <1 || choose >7) {               
           System.out.println("Enter valid number ");
            choose=input.nextInt();       
           }
       
       if(choose==1){this.BookPlayground(listOfGrounds);}
       else if(choose==2){this.sendInvetation(listOfUsers);}
       else if(choose==3){this.cancelPlayground(listOfGrounds);}
       else if(choose==4){this.editProfileInfo();}
       else if(choose==5){this.viewPlaygroundHours(listOfGrounds);}
       else if(choose==6){this.createTeam(listOfUsers);}
       else if(choose==7){this.checkEwallet();}
       
       System.out.println("another option? ");
      again=input.next().charAt(0);
      
    }while(again!='n');
        
       }
  public void BookPlayground(ArrayList<playground>listOfGrounds){
 Scanner input = new Scanner(System.in);
  String groundName="";
String slot="";

this.viewPlaygroundHours(listOfGrounds);
  
System.out.println("Enter name of ground ");
groundName=input.next();
Ground_Name=groundName;
  System.out.println("Enter slot of ground ");
slot=input.next();
Ground_Time=slot;
 
 String password;
 int id;
for(int i=0 ;i<listOfGrounds.size();i++){
    if(groundName.equals(listOfGrounds.get(i).getName()) ){
        
       System.out.println("Enter Ewallet id:  ");
       id=input.nextInt();
       System.out.println("Enter Ewallet password:  ");
       password=input.next();
        
       if(mywallet.check(id, password)){ 
        if(mywallet.transaction(listOfGrounds.get(i).getOwnedBy().getMywallet(),listOfGrounds.get(i).getPricePerHour()*2 )){
            System.out.println("Done ");
        }
       
        else{System.out.println("money is not enough ");
        break;
        }
       }
       else{System.out.println("id or password is wrong ");}
       
       
      for(int j=0;j<listOfGrounds.get(i).getAvailableHours()/2;j++){
      
          if(slot.equals(listOfGrounds.get(i).getTimeSlots()[j])){
              
 listOfGrounds.get(i).getTypeOfSlots()[j]="not available";
                break;
          }
          
      }
    }
  
  }
  }
  
   public void cancelPlayground(ArrayList<playground>listOfGrounds){
       
     for(int i=0 ;i<listOfGrounds.size();i++){
    if(Ground_Name.equals(listOfGrounds.get(i).getName()) ){
         for(int j=0;j<listOfGrounds.get(i).getAvailableHours()/2;j++){
      
          if(Ground_Time.equals(listOfGrounds.get(i).getTimeSlots()[j])){ 
 
            listOfGrounds.get(i).getOwnedBy().getMywallet().transaction(mywallet,listOfGrounds.get(i).getPricePerHour()*2);
            listOfGrounds.get(i).getTypeOfSlots()[j]="available";
                break;
          }
   
   
   
         }
   }
     }
   }
   public void sendInvetation(ArrayList<users>listOfUsers){
       Scanner input = new Scanner(System.in);
       String email;
          
     for(int i=0 ;i<listOfUsers.size();i++){
        if("Player".equals(listOfUsers.get(i).getType())&&!this.name.equals(listOfUsers.get(i).getName())){

      System.out.println( listOfUsers.get(i).toString());

    }
     }
     
System.out.println("enter who you want invite them");
email=input.next();
  for(int i=0;i<listOfUsers.size();i++){
if(email.equals(listOfUsers.get(i).getEmail())){
    listOfUsers.get(i).getInvitation().add(this.name+" invited you");
}
        
        
        }
   }
   
   
  public void viewPlaygroundHours(ArrayList<playground>listOfGrounds){
          Scanner input = new Scanner(System.in);
      char choice;

    for(int i=0 ;i<listOfGrounds.size();i++){
        
     if("active".equals(listOfGrounds.get(i).getState()))
       listOfGrounds.get(i).toString();

    }
      System.out.println("Do you want to filter playgrounds?");
      choice=input.next().charAt(0);
             if(choice=='y'){
               this.filter(listOfGrounds);
            }
  }
  
      public void filter(ArrayList<playground>listOfGrounds){
        Scanner input = new Scanner(System.in);
        int choice=0;
        System.out.println("Please select one of the following :\n");
        System.out.println("1-area or your location :\n");
        System.out.println("2-available slots:\n"); 
        System.out.println("3-price Range:\n");
        
        choice=input.nextInt();
          while (choice <1 || choice > 3) {               
           System.out.println("Enter valid number ");
            choice=input.nextInt();       
           }
        
    if(choice==1){
    System.out.println("Please enter an area or your location: ");

      String area=input.next();

   for(int i=0 ;i<listOfGrounds.size();i++){
    if(area.equals(listOfGrounds.get(i).getLocation())&&
           "active".equals(listOfGrounds.get(i).getState()) ){
            listOfGrounds.get(i).toString();
    }
    }
}
else if(choice==2){
        System.out.println("Please enter slot you want: ");

        String slots=input.next();
       for(int i=0 ;i<listOfGrounds.size();i++){
    if("active".equals(listOfGrounds.get(i).getState()) ){
        
      for(int j=0;j<listOfGrounds.get(i).getAvailableHours()/2;j++){
      
          if(slots.equals(listOfGrounds.get(i).getTimeSlots()[j])){ 
              listOfGrounds.get(i).toString();
                break;
          }
          
      }
    
    }
    }
}
    
else if(choice==3){
   System.out.println("Please enter  priceRange: ");

    int price=input.nextInt();
    
 for(int i=0 ;i<listOfGrounds.size();i++){
    if(listOfGrounds.get(i).getPricePerHour()<=price &&
            "active".equals(listOfGrounds.get(i).getState())){
       System.out.println(listOfGrounds.get(i).toString());
        
    }
    }
    
}  
      
      
      }
  
    public void createTeam( ArrayList<users>listOfUsers){
           Scanner input = new Scanner(System.in);
           String email="";
           int count=0;
           System.out.println("enter emails of your team:");
           for(int j=0;j<team.length;j++){
           email=input.next();

         for(int i=0;i<listOfUsers.size();i++){
         if(email.equals(listOfUsers.get(i).getEmail())){
         team[j]=email;   
         count++;
    }
        else if(count==0){System.out.println("this email not found");
           email=input.next();
           }
    }
    count=0;

    }
    
    }
    
    public  void editProfileInfo(){
        Scanner input = new Scanner(System.in);
        int choose;     
       System.out.println("what would you like to Edit?");
       System.out.println("1-name");
       System.out.println("2-id");
       System.out.println("3-password");
       System.out.println("4-email ");
       System.out.println("5-location ");
       System.out.println("6-phone ");


        choose=input.nextInt();  
    
        while (choose <1 || choose >6) {               
        System.out.println("Enter valid number ");
        choose=input.nextInt();       
       }
        if(choose==1){
      String name=input.next();
       setName(name);

        } 
        
        else   if(choose==2){
      int id=input.nextInt();
      setId(id);
        } 
        
        else    if(choose==3){
        String Password=input.next();
        setPassword(Password);
        } 
        
                
       else if(choose==4){
        String email =input.next();
        setEmail(email);
        } 
                
      else if(choose==5){
       String location=input.next();
        setLocation(location);
        } 
        
     else if(choose==6){
    int phone=input.nextInt();
    setPhone(phone);
        } 
        
        }


}
