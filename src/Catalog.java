/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author user
 */
public class Catalog{
     
    String productName = null;
    String productCatg = null;
    String productId = null;
    int discount = 0;
    int Price = 0;
    int stock = 0;
    
    public Catalog(String productID,String productName,int Price,String productCatg, int discount,int quantity)
    {
        this.productId=productID;
        this.productName=productName;
        this.productCatg=productCatg;
        this.discount=discount;
        this.Price=Price;
        this.stock=quantity;
    }
    
    public Catalog(){}
    
    public void setName(String name){
        this.productName=name;
    }
        
    public void setCategory(String category){
        this.productCatg = category;
    }
    
    public void setDiscount(int d){
        this.discount=d;
    }
    
    public void setPrice(int pr){
        this.Price=pr;
    }
    
    public void setProductId(String id){
        this.productId=id;
    }
    
    public void setStock(int st){
        this.stock=st;
    }
    
    public String getName(){
        return productName;
    }
        
    public String getCategory(){
        return productCatg;
    }
    
    public int getDiscount(){
        return discount;
    }
    
    public int getPrice(){
        return Price;
    }
    
    public String getProductId(){
        return productId;
    }
    
    public int getStock(){
        return stock;
    }
    
    public String stringify()
    {
        return productId+","+productName+","+Integer.toString(Price)+","+productCatg+","+Integer.toString(discount)+","+Integer.toString(stock);
    }
    
}   
