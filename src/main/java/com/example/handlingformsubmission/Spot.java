package com.example.handlingformsubmission;
 
import java.util.ArrayList;
import java.util.Map;
import java.util.*;
 
import lombok.Getter;
import lombok.Setter;
 
@Setter
@Getter
public class Spot {
 
	private String name;
	private String location;
 private int suv,hatch;
 private ArrayList<Map<String,ArrayList<String>>> hour = new ArrayList<Map<String,ArrayList<String>>>(24);
 
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
 public void setMap(){
  for(int i=0;i<24;i++){
   // ArrayList<String> inin= new ArrayList<String>();
   // inin.add("");
   // inin.add("");
   // inin.add("");
   // inin.add("");
   // inin.add("");
   // inin.add("");
   // inin.add("");
   // Map<Integer,ArrayList<String>> in= new HashMap<Integer,ArrayList<String>>();
   // in.put(0,inin);
   // maps.add(in);
   Map<String,ArrayList<String>> in= new HashMap<String,ArrayList<String>>();
   for(int j = 0; j < suv;j++){
    ArrayList<String> inin= new ArrayList<String>();
    inin.add("");
    inin.add("");
    inin.add("false");
    inin.add("true");
    inin.add("false");
    inin.add("false");
    inin.add("false");
    inin.add("");
 
    in.put(Integer.toString(j),inin);
   }
   for(int j = suv; j < hatch+suv;j++){
    ArrayList<String> inin= new ArrayList<String>();
    inin.add("");
    inin.add("");
    inin.add("false");
    inin.add("false");
    inin.add("false");
    inin.add("false");
    inin.add("false");
    inin.add("");
    in.put(Integer.toString(j),inin);
   }
   hour.add(in);
   // maps[i].put("Space", new ArrayList<String>(Arrays.asList("", "", "", "", "","","")));
  }
 }
   
}
 
 
 