/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mistu
 */
//assert(mgr.getAllPatients().length()==12)
//assert(mgr.getPatient("123").name().equals("Arif")
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.*;
import javax.swing.JFrame;

public class CatalogManager {
    private MainManager mMgr;
    ArrayList<Catalog> prod1=new ArrayList<>();
    
    public CatalogManager(MainManager mMgr){
        this.mMgr = mMgr;
    }
    

    public void catalogInit()
    {
        mMgr.searchMgr.searchInit("catalog.csv");
        prod1 = mMgr.searchMgr.getProductList();
        //System.out.println(prod1.size());
    }
    
    
    public ArrayList getAllProducts()
    {
        return prod1;
    }
    
    public void removeProduct(String name,int serialNo)
    {
        for(int i=0;i<this.prod1.size();i++)
        {
            if(this.prod1.get(i).getName().equalsIgnoreCase(name)==true && i+1==serialNo)
            {
                this.prod1.remove(i);
            }
        }
    }
    
    public void addProduct(Catalog cg)
    {
        
        //System.out.println(prod1.size());//0
        this.prod1.add(cg);
        System.out.println(prod1.size());//1
    }
    
    public void editProduct(int index,Catalog cg)
    {
        this.prod1.set(index, cg);
        
    }
    
    public boolean doHousekeeping(String filename)
    {
        ArrayList<Catalog> prod1 = mMgr.catalogMgr.getAllProducts();
        //System.out.println(prod1.size());
        try  {
            BufferedWriter bfw = new BufferedWriter(new FileWriter(filename));
            for(int i=0;i<this.prod1.size();i++)
            {
                bfw.write(this.prod1.get(i).stringify());
                //bfw.write(this.prod1.get(i).stringify());
                bfw.newLine();
            }
            bfw.close();
        }catch(IOException e)
        {
            System.out.println("somethings wrong");
            return false;
        }
        return true;
        
    }
    
    public boolean updateStock(Order order)
    {
        //System.out.println(od.getTotal());
        //ArrayList<Product> list = order.viewOrder();
        
        catalogInit();
        ArrayList<Product> pro = order.getOrder();
        for(int i=0;i<pro.size();i++)
        {
            Product p = pro.get(i);
            String nm = p.NameGetter();
            //int pr=p.PriceGetter();
            for(Catalog c:prod1)
            {
                if(c.getName().equalsIgnoreCase(nm))
                {
                    if(c.getStock()<p.QuantityGetter())
                        return false;
                    else
                        c.setStock(c.getStock()- p.QuantityGetter());
                }
               
            }
        }
        
        
        return true;
    }
    
}
