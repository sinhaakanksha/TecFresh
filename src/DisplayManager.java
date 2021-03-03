/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sandeep-Das-og
 */
public class DisplayManager {

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
        mainMgr.searchMgr.searchInit("catalog.csv");
        SU.setVisible(true);
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
        ODU.setVisible(true);
    }

    public void ShowInventoryScreen() {
        hideAll();
        VPU.setVisible(true);
    }

    public void ShowCatalogScreen() {
        hideAll();
        APU.setVisible(true);
    }

}
