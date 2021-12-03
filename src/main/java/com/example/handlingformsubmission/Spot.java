package com.example.handlingformsubmission;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Spot {

	private String name;
	private String location;
    private int num;

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

    public int getNum(){
        return num;
    }

    public void setNum(int num){
        this.num = num;
    }


}

