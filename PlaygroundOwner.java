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
public class PlaygroundOwner extends users {

    private  playground ground=null;    
     public PlaygroundOwner() {}

        
    public PlaygroundOwner(int id, String name, String password, String email, String location, int phone) {
        super(id, name, password, email, location, phone,"Owner");
     mywallet= new Ewallet(id, password);
    }



    
    
    @Override
    public void menu(ArrayList<playground>listOfGrounds,ArrayList<users>listOfUsers){
       int choose;
        Scanner input = new Scanner(System.in);
        char again;
       do{  
       System.out.println("\nHello "+this.name); 
       System.out.println("\nwhat would you like to do?");
       System.out.println("1-add playground");
       System.out.println("2-update playground info");
       System.out.println("3-check Ewallet");
       System.out.println("4-create profile ");
       
       choose =input.nextInt();
       
          while (choose <1 || choose >4) {               
           System.out.println("Enter valid number ");
            choose=input.nextInt();       
           }
       
       
       if(choose==1){this.addPlayGround(listOfGrounds);}
       
       else if(choose==2){this.EditPlayGround(listOfGrounds);}
       
      else if(choose==3){this.checkEwallet();}
      
      else if(choose==4){this.createProfile();}
       
      System.out.println("another option? ");
      again=input.next().charAt(0);
      
    }while(again!='n');
        
    }
    
    public  void addPlayGround(ArrayList<playground>listOfGrounds){
        Scanner input = new Scanner(System.in);
         
        if(ground==null){   
        
        String name,location;
        float size,pricePerHour;
        int availableHours =0,cancel_period=0;
  
    System.out.print("Enter playground name:  ");
    name =input.nextLine();
   
    System.out.print("Enter playground location:  ");
    location=input.nextLine();
    
    System.out.print("Enter playground size:  ");
    size =input.nextFloat();
    
    System.out.print("Enter availableHours:  ");
    availableHours =input.nextInt();
    
    System.out.print("Enter pricePerHour:  ");
    pricePerHour =input.nextFloat();
  
    System.out.print("Enter cancel_period:  ");
    cancel_period=input.nextInt();
    String[] TimeSlots = new String[availableHours/2];        
    String [] typeOfSlots = new String[availableHours/2];
      
     System.out.println("Enter TimeSlots:");
      for(int i=0;i<availableHours/2;i++){
    TimeSlots[i]=input.next();
      }
   
      for(int i=0;i<availableHours/2;i++){
    typeOfSlots[i]="available";
      }
    
    ground =new playground(name, location, size, availableHours, pricePerHour,"pending",TimeSlots,typeOfSlots,cancel_period);
    ground.setOwnedBy(this);
   listOfGrounds.add(ground);
        }
        else {     System.out.println("you already have a playground ");}
    }
    
    
        public  void EditPlayGround(ArrayList<playground>listOfGrounds){
            Scanner input = new Scanner(System.in);
           int choose;  
                    int availableHours=0;

                  char again;
        if(ground!=null){          
       do{  
       System.out.println("what would you like to Edit?");
       System.out.println("1-name");
       System.out.println("2-location");
       System.out.println("3-size");
       System.out.println("4-availableHours ");
       System.out.println("5-pricePerHour ");
       System.out.println("6-TimeSlotes");
       System.out.println("7-typeofhours ");
       System.out.println("8-cancelation period ");


        System.out.println(ground.toString());
        choose=input.nextInt();  
        
         while (choose <1 || choose >8) {               
         System.out.println("Enter valid number ");
          choose=input.nextInt();       
         }
       
       
        if(choose==1){
        System.out.print("enter new name:  ");
        String name=input.next();
        ground.setName(name);
        } 
       
       else if(choose==2){
        
        System.out.print("enter new location:  ");
         String location=input.next();
         ground.setLocation(location);
        } 
        
                
       else if(choose==3){
       System.out.print("enter new size:  ");     
        float size=input.nextFloat();
        ground.setSize(size);
        } 
                
       else if(choose==4){
        System.out.print("enter new available hours:  ");  
        availableHours=input.nextInt();
        ground.setAvailableHours(availableHours);
        } 
        
      else if(choose==5){
        System.out.print("enter new pricePerHour:   ");       
        float   pricePerHour=input.nextFloat();
        ground.setPricePerHour(pricePerHour);
        }
        
     String[] TimeSlots = new String[availableHours/2];        
     String [] typeOfSlots = new String[availableHours/2];
      
        
     if(choose==6){
      System.out.println("Enter TimeSlots:  ");
      
      for(int i=0;i<availableHours/2;i++){
    TimeSlots[i]=input.next();
      }
      ground.setTimeSlots(TimeSlots);

      
          }
     if(choose==7){
     System.out.println("Enter typeofTimeSlots:  ");
      for(int i=0;i<availableHours/2;i++){
    typeOfSlots[i]=input.next();
      }
           ground.setTypeOfSlots(typeOfSlots);
      }
        if(choose==8){
          System.out.println("Enter cancelation period:");
          int cancel=input.nextInt();
           ground.setCancel_period(cancel);
         }
               
      System.out.println("another option ?");
      again=input.next().charAt(0);
      }while( again !='n');
        }
        
        else{System.out.println("please add playground ");}
        
        }

    public  void createProfile(){
            Scanner input=new Scanner(System.in);
            int code;
            System.out.print("enter location:  ");
            String location=input.next();
            
            System.out.print("enter phone:  ");
            int phone=input.nextInt();
           
        int max = 9999; 
        int min = 1000; 
        int rand=0;
        int range = max - min + 1; 
        for (int i = 0; i < 10; i++) { 
            rand = (int)(Math.random() * range) + min;
        }
             System.out.println("code Number:" + rand); 
                
             System.out.print("\nenter code number:  ");
            code=input.nextInt();
            while(code!=rand){
                System.out.print("\n invalid code try again");
                  code=input.nextInt();
               }
            
             if(rand==code){System.out.print("\nconfirmed\n \n ");}
             
            this.setPhone(phone);
            this.setLocation(location);
                
    }




}
