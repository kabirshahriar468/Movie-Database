package multiplescene;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import multiplescene.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class TotalProfitController implements Initializable {
    private Main main;
    void setMain(Main main) {
        this.main = main;
    }
    public ListView<String> profitListView;
    private long profit;
    public void setProfit(long p){
        profit=p;
    }
    public void onBackButtonClick(ActionEvent actionEvent) throws Exception {
        main.showHomePage(main.p_company);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void showProfit(){
        String str="Your total profit = "+String.valueOf(profit)+" Dollar";
        profitListView.getItems().add(str);
    }
}
