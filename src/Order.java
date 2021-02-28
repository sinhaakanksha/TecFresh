
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Order {
   int orderId;
   String Status;
    String date;
    String Name;
    String Address;
    String phone;
    int total;
    ArrayList<Product> OD;
    
    public Order(){}
    
public void setOrderId(int id){
    //System.out.println("OM"+id);
    this.orderId=id;
}
public void setAddress(String add){
    this.Address=add;
}
public void setName(String na){
    this.Name=na;
}
public void setPhone( String ph){
    this.phone=ph;
}

public void setDate(String dt){
    this.date=dt;
}
public void setOrder(ArrayList<Product> PD){
    this.OD=PD;
}
public void setTotal( int t){
    this.total=t;
}
/*public int getOrderId(){
    return orderId++;
}*/
public String getPhone(){
    return phone;
}
public void setStatus(String s){
    this.Status=s;
}
public String getAddress(){
    return Address;
}
public String getDate(){
    return date;
}
public ArrayList getOrder(){
    return OD;
}
public int getTotal(){
    return total;
}
public String getID(){
    
    return String.valueOf(orderId);
}
public String getStatus(){
    return Status;
}
public String getName(){
    return Name;
}
}

 