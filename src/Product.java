/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sinhaakanksha
 */
public class Product {

    String productName = null;
    int Quantity = 0;
    int Price = 0;
    int totalPrice = 0;

    public void NameSetter(String name) {
        this.productName = name;
    }

    public void QuantitySetter(int q) {
        this.Quantity = q;
    }

    public void PriceSetter(int pr) {
        this.Price = pr;
    }

    public void TotalSetter(int t) {
        this.totalPrice = t;
    }

    public String NameGetter() {
        return productName;
    }

    public int QuantityGetter() {
        return Quantity;
    }

    public int PriceGetter() {
        return Price;
    }

    public int TotalGetter() {
        return totalPrice;
    }

}
