
import java.util.ArrayList;
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
public class DisplayManager {

    /*private OrderManager orderMgr;
    private SearchManager searchMgr;
    private CatalogManager catalogMgr;*/
    SearchProductUI SPU;
    StartUI SU;
    CardUI CU;
    ManageOrdersUI MOU;
    PlaceOrderUI POU;
    OrderDetailsUI ODU;
    ShopkeeperMainUI SMU;
    ViewProductUI VPU;
    AddProductUI APU;
    MainManager mainMgr;

    public void hideAll() {
        SU.setVisible(false);
        SPU.setVisible(false);
        CU.setVisible(false);
        POU.setVisible(false);
        MOU.setVisible(false);
        ODU.setVisible(false);
        SMU.setVisible(false);
        VPU.setVisible(false);
        APU.setVisible(false);
    }

    public void showStartUI() {
        hideAll();
        mainMgr.searchMgr.searchInit("src/catalog.csv");
        SU.setVisible(true);
        //anotherUI.setVisible(false);
    }

    public void showShopkeeperMain() {
        hideAll();
        SMU.setVisible(true);
    }

    public void showSearchScreen() {
        hideAll();
        SPU.addRowToTable();
        SPU.setVisible(true);

    }

    public void showCard() {
        hideAll();
        //card.cardDetails(id, name, price, discount);
        CU.setVisible(true);
    }

    public void showProductScreen() {
        hideAll();

        POU.setVisible(true);

    }

    public void showOrderScreen() {
        hideAll();
        MOU.setVisible(true);
    }

    public void ShowDetails() {
        hideAll();
        //od.Show(id);
        ODU.setVisible(true);
    }

    public void ShowInventoryScreen() {
        hideAll();
        //vp.populateData(catalogMgr.getAllProducts());
        VPU.setVisible(true);
    }

    public void ShowCatalogScreen() {
        hideAll();
        APU.setVisible(true);
    }

}
