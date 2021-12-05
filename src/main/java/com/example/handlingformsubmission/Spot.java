package com.example.handlingformsubmission;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Spot {

	private String name;
	private String location;
 private int suv,hatch;
 private List<Map<String,Integer>> maps = new ArrayList<Map<String,Integer>>();

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

    public int getSuv(){
        return suv;
    }

    public void setSuv(int suv){
        this.suv = suv;
    }
    public int getHatch(){
     return hatch;
 }

 public void setHatch(int hatch){
     this.hatch = hatch;
 }

}

