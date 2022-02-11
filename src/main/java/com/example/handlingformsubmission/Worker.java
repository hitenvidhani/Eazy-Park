package com.example.handlingformsubmission;
 
import lombok.Getter;
import lombok.Setter;
 
@Setter
@Getter
public class Worker {
 
	private String name;
	private String spot;
    // private int slot;
    private int hour;
    private int rating;
    private String password;
 
	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}
 
	public String getSpot() {
		return spot;
	}
 
	public void setSpot(String spot) {
		this.spot = spot;
    }
 
    // public int getSlot(){
    //     return slot;
    // }
 
    // public void setSlot(int slot){
    //     this.slot = slot;
    // }
 
    public int getHour(){
        return hour;
    }
 
    public void setHour(int hour){
        this.hour = hour;
    }
 
    public int getRating(){
        return rating;
    }
 
    public void setRating(int rating){
        this.rating = rating;
    }
    public void setPassword(String password) {
     this.password = password;
    }
   
    public String getPassword() {
     return password;
    }
 
}
 