
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class OrderManager {

    /*static*/ int id;
    private ArrayList<Product> cart = new ArrayList<>();
    private ArrayList<Order> orderList = new ArrayList<>();
    ArrayList<Product> prod1 = new ArrayList<>();
    private String status;

    public OrderManager() {
        orderInit();
        id = ThreadLocalRandom.current().nextInt(1000,999999999);
    }

    public void orderInit() {
        cart = new ArrayList<>();
        orderList = new ArrayList<>();
        //id=1123;
    }

    public void Add(String name, int quantity, int price) {
        Product item = new Product();
        item.NameSetter(name);
        item.QuantitySetter(quantity);
        item.PriceSetter(price);
        item.TotalSetter(quantity * price);
        cart.add(item);

        //cart.add(item);
        //System.out.println(cart.size());
    }

    public void Delete(String name) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).NameGetter().equals(name)) {
                cart.remove(i);
            }
        }
    }

    public void Display() {
        int s = 0;
        for (int i = 0; i < cart.size(); i++) {
            s = s + cart.get(i).TotalGetter();

        }

    }

    public ArrayList getCart() {
        return cart;
    }

    public ArrayList viewOrder(String filename) {
        ArrayList<Product> pd = new ArrayList<>();
        Map<String, ArrayList<Product>> map = new HashMap<>();
        
        orderList.clear();
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            while ((line = br.readLine()) != null) //returns a Boolean value 
            {
                String[] arr = line.split(splitBy);

                if (arr.length > 4) {
                    String temp = arr[0];
                    Order o = new Order();
                    o.setOrderId(Integer.parseInt(temp));
                    o.setName(arr[1]);
                    o.setPhone(arr[2]);
                    o.setAddress(arr[3]);
                    o.setDate(arr[4]);
                    o.setStatus(arr[5]);
                    orderList.add(o);
                    continue;
                }

                // use comma as separator
                if (!map.containsKey(arr[0])) {
                    map.put(arr[0], new ArrayList<>());

                    Product p = new Product();
                    p.NameSetter(arr[1]);
                    p.QuantitySetter(Integer.parseInt(arr[2]));
                    p.TotalSetter(Integer.parseInt(arr[3]));
                    map.get(arr[0]).add(p);
                    //o.setOrder(pd);
                    //orderList.add(o);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        for(var i:orderList){
            i.setOrder(map.get(i.getID()));
        }

        /*for (var p : map.entrySet()) {
            System.out.println(p.getKey());
            pd.addAll(p.getValue());
            for (var q : p.getValue()) {
                System.out.println(q.NameGetter());
            }
        }*/
        
        
        return orderList;
    }

    public void Confirm(String cname, String add, String phone, String filename) {
        int sum = 0;
        Order order = new Order();
        order.setOrderId(id);
        
        
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy ");
        order.setName(cname);
        order.setAddress(add);
        order.setPhone(phone);
        order.setDate(formatter.format(date));
        order.setStatus("pending");

        //System.out.println(getCart().size());
        order.setOrder(this.getCart());

        for (int i = 0; i < cart.size(); i++) {
            sum = sum + cart.get(i).TotalGetter();
        }

        order.setTotal(sum);
        /*orderList.add(orderList);*/

        //System.out.println(this.orderList.size());
        //prod1 = this.getCart();
        try {
            prod1 = order.getOrder();

            BufferedWriter bfw = new BufferedWriter(new FileWriter(filename, true));
            bfw.append(order.getID());
            System.out.println(order.getID());
            bfw.append(',');
            bfw.append(order.getName());
            bfw.append(',');
            bfw.append(order.getPhone());
            bfw.append(',');
            bfw.append(order.getAddress());
            bfw.append(',');
            bfw.append(order.getDate());
            bfw.append(',');
            bfw.append(order.getStatus());

            bfw.newLine();

            for (int i = 0; i < prod1.size(); i++) {
                //bfw.write(this.prod1.get(i).stringify());

                bfw.append(order.getID());
                bfw.append(',');
                bfw.append(prod1.get(i).NameGetter());
                bfw.append(',');
                bfw.append(String.valueOf(prod1.get(i).QuantityGetter()));
                bfw.append(',');
                bfw.append(String.valueOf(prod1.get(i).TotalGetter()));
                bfw.newLine();
            }
            bfw.close();
        } catch (IOException e) {
            System.out.println("somethings wrong");
        }
        ++id;
        //System.out.println(orderList.size());
        cart.clear();
    }

    public void Disp() {
//        for (int i = 0; i < orderList.size(); i++) {
//            // if(ORDER.get(i).getID()==(oid)){
//            System.out.println(OR.get(i).getOrderId() + " " + ORDER.get(i).getAddress() + " " + ORDER.get(i).getDate());
//            for (int j = 0; j < OD.size(); j++) {
//                System.out.println(OD.get(j).NameGetter() + " " + OD.get(j).QuantityGetter() + " " + OD.get(j).PriceGetter() + " " + OD.get(j).TotalGetter());
//            }
//            System.out.println(ORDER.get(i).getTotal());
//            //}
//        }
    }

}
