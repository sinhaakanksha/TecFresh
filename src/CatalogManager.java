/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mistuk2000
 */

import java.io.*;
import java.util.*;

public class CatalogManager {

    private MainManager mMgr;
    ArrayList<Catalog> prod1 = new ArrayList<>();

    public CatalogManager(MainManager mMgr) {
        this.mMgr = mMgr;
        catalogInit();
    }

    public void catalogInit() {
        mMgr.searchMgr.searchInit("catalog.csv");
        prod1 = mMgr.searchMgr.getProductList();
    }

    public ArrayList getAllProducts() {
        return prod1;
    }

    public void removeProduct(String name, int serialNo) {
        for (int i = 0; i < this.prod1.size(); i++) {
            if (this.prod1.get(i).getName().equalsIgnoreCase(name) == true && i + 1 == serialNo) {
                this.prod1.remove(i);
            }
        }
    }

    public void addProduct(Catalog cg) {
        prod1 = this.getAllProducts();
        this.prod1.add(cg);
    }

    public void editProduct(int index, Catalog cg) {
        this.prod1.set(index, cg);
    }

    public boolean doHousekeeping(String filename) {
        ArrayList<Catalog> prod1 = mMgr.catalogMgr.getAllProducts();
        try {
            BufferedWriter bfw = new BufferedWriter(new FileWriter(filename));
            for (int i = 0; i < this.prod1.size(); i++) {
                bfw.write(this.prod1.get(i).stringify());
                bfw.newLine();
            }
            bfw.close();
        } catch (IOException e) {
            System.out.println("somethings wrong");
            return false;
        }
        return true;

    }

    public boolean updateStock(Order order) {

        catalogInit();
        ArrayList<Product> pro = order.getOrder();
        for (int i = 0; i < pro.size(); i++) {
            Product p = pro.get(i);
            String nm = p.NameGetter();
            for (Catalog c : prod1) {
                if (c.getName().equalsIgnoreCase(nm)) {
                    if (c.getStock() < p.QuantityGetter()) {
                        return false;
                    } else {
                        c.setStock(c.getStock() - p.QuantityGetter());
                    }
                }

            }
        }

        return true;
    }

}
