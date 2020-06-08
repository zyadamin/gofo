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
public class playground {
    
    private  String  name;
    private  String  location;
    private  float   size;
    private  int  availableHours;
    private  float   pricePerHour;
    private  String  state;
    String[] TimeSlots = new String[availableHours/2]; 
    String [] typeOfSlots = new String[availableHours/2];
    int cancel_period;
    PlaygroundOwner ownedBy;

           public playground() {}

    public playground(String name, String location, float size, int availableHours, float pricePerHour, String state,String[] TimeSlots,String[] typeOfSlots ,int cancel_period) {
        this.name = name;
        this.location = location;
        this.size = size;
        this.availableHours = availableHours;
        this.pricePerHour = pricePerHour;
        this.state = state;
       this.TimeSlots = TimeSlots;
        this.typeOfSlots = typeOfSlots;

        this.cancel_period = cancel_period;
    }

           
    public int getCancel_period() {
        return cancel_period;
    }

    public void setCancel_period(int cancel_period) {
        this.cancel_period = cancel_period;
    }


    public String getState() {
        return state;
    }


       
    public void setState(String state) {
        this.state = state;
    }

    
    public String[] getTimeSlots() {
        return TimeSlots;
    }

    public void setTimeSlots(String[] TimeSlots) {
        this.TimeSlots = TimeSlots;
    }

    public String[] getTypeOfSlots() {
        return typeOfSlots;
    }

    public void setTypeOfSlots(String[] typeOfSlots) {
        this.typeOfSlots = typeOfSlots;
    }
       


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public float getSize() {
        return size;
    }

    public void setSize(float size) {
        this.size = size;
    }

    public float getAvailableHours() {
        return availableHours;
    }

    public void setAvailableHours(int availableHours) {
        this.availableHours = availableHours;
    }

    public float getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(float pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public PlaygroundOwner getOwnedBy() {
        return ownedBy;
    }


    public void setOwnedBy(PlaygroundOwner ownedBy) {
        this.ownedBy = ownedBy;
    }

    
    
    
        @Override
    public String toString() {
        int count=1;
       System.out.println(  name + "  " + location + "  " + size + "  " + availableHours + "  " + pricePerHour );
        System.out.println("time: ");
       for(int i=0;i<this.availableHours/2;i++){
        if("available".equals(typeOfSlots[i]))
           System.out.println(count+"-"+TimeSlots[i]);
       count++;
       }
        
      return " "; 
    }

            
      }
