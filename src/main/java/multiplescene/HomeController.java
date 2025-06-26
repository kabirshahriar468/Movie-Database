package multiplescene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;

public class HomeController {

    private Main main;

    @FXML
    private Label message;

    @FXML
    private ImageView image;

    @FXML
    private Button button;

    public void init(String msg) {
        message.setText(msg);
        Image img = new Image(Main.class.getResourceAsStream("1.png"));
        image.setImage(img);
    }

    @FXML
    void logoutAction(ActionEvent event) {
        try {
            main.showLoginPage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void setMain(Main main) {
        this.main = main;
    }

    public void onShowMovieClick(ActionEvent actionEvent) throws IOException {
        String str="ShowMovie";
        main.getSocketWrapper().write(str);
    }

    public void onMaxRevenueClick(ActionEvent actionEvent) throws IOException {
        String str="MaxRevenueMovie";
        main.getSocketWrapper().write(str);
    }

    public void onMostRecentMovieClick(ActionEvent actionEvent) throws IOException {
        String str="MostRecentMovie";
        main.getSocketWrapper().write(str);
    }

    public void onTotalProfitClick(ActionEvent actionEvent) throws IOException {
        String str="TotalProfit";
        main.getSocketWrapper().write(str);
    }

    public void onTransferClick(ActionEvent actionEvent) throws IOException {
        String str="Transfer";
        main.getSocketWrapper().write(str);
    }

    public void onAddMovieClick(ActionEvent actionEvent) throws IOException {
        String str="AddMovie";
        main.getSocketWrapper().write(str);
    }
}
