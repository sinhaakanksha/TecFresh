
/**
 *
 * @author Sandeep-Das-og
 */

public class MainManager {

    OrderManager orderMgr;
    SearchManager searchMgr;
    CatalogManager catalogMgr;

    public MainManager() {
        orderMgr = new OrderManager();
        searchMgr = new SearchManager();
    }

    public static void main(String[] args) {
        DisplayManager dMgr = new DisplayManager();
        dMgr.mainMgr = new MainManager();
        dMgr.mainMgr.catalogMgr = new CatalogManager(dMgr.mainMgr);
        dMgr.SPU = new SearchProductUI(dMgr);
        dMgr.SU = new StartUI(dMgr);
        dMgr.CU = new CardUI(dMgr);
        dMgr.MOU = new ManageOrdersUI(dMgr);
        dMgr.POU = new PlaceOrderUI(dMgr);
        dMgr.ODU = new OrderDetailsUI(dMgr);
        dMgr.SMU = new ShopkeeperMainUI(dMgr);
        dMgr.VPU = new ViewProductUI(dMgr);
        dMgr.APU = new AddProductUI(dMgr);

        dMgr.showStartUI();
    }

}
