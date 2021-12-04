package com.example.handlingformsubmission;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class User {

	private String fname;
	private String lname;
	private String vehNo;
	private String mobNo;
	private String email;

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getVehicleNo() {
		return vehNo;
	}

	public void setVehicleNo(String vehNo) {
		this.vehNo = vehNo;
    }

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }


}

