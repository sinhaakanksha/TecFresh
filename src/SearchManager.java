import java.io.BufferedReader;  
import java.io.FileReader;  
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JFrame;
        
public class SearchManager {
    private ArrayList<Catalog> list;
    private ArrayList<Catalog> filterlist;

    public SearchManager(){
        //this.init("");
        list = new ArrayList<>();
        filterlist = new ArrayList<>();
        searchInit("catalog.csv");
    }
    
    public boolean searchInit(String filename){
        list.clear();
        boolean result = false;
        String line = "";  
        String splitBy = ","; 
        
        try{  
            BufferedReader br = new BufferedReader(new FileReader(filename));  
            while((line = br.readLine()) != null)   //returns a Boolean value 
            {  
                //System.out.println(line);
                String[] catalog = line.split(splitBy);    // use comma as separator
                /**System.out.println("Product Name: "+product[0]+",Product Price: "
                        +product[1]+",Category: "+product[2]+",Discount: "+product[3]);*/ 
                
                Catalog c = new Catalog();
                c.setProductId(catalog[0]);
                c.setName(catalog[1]);
                c.setPrice(Integer.parseInt(catalog[2]));
                c.setCategory(catalog[3]);
                c.setDiscount(Integer.parseInt(catalog[4]));
                c.setStock(Integer.parseInt(catalog[5]));
                if(c.getStock() != 0)
                    list.add(c);
            }
            result = true;
        }   
        catch (IOException e){  
            e.printStackTrace();  
        }
   
        return result;
    }
    
    public ArrayList<Catalog> search(String query){
        filterlist.clear();
        for(int i=0;i<list.size();i++){
            if(list.get(i).getName().toLowerCase().contains(query.toLowerCase())){
                Catalog cg = new Catalog();
                cg.setProductId(list.get(i).getProductId());
                cg.setName(list.get(i).getName());
                cg.setPrice(list.get(i).getPrice());
                cg.setCategory(list.get(i).getCategory());
                cg.setDiscount(list.get(i).getDiscount());
                cg.setStock(list.get(i).getStock());
                filterlist.add(cg);
            }
        }
        return filterlist;
    }
    
    public ArrayList<Catalog> getProductList(){
        
        return list;
    }
    
    public void display(ArrayList<Catalog> arr){
        this.list = arr;
        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i).getProductId()+","+arr.get(i).getName()+","+arr.get(i).getPrice()+","
                    +arr.get(i).getCategory()+","+arr.get(i).getDiscount());
        }
    }

}

