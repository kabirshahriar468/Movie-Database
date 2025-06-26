package multiplescene;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import multiplescene.clientmain.Movie;

import java.net.URL;
import java.util.ResourceBundle;

public class MostRecentController implements Initializable {
    private Main main;
    private Movie mostRecent;
    public ListView<String> mostRecentMovieListView;
    void setMain(Main main){
        this.main=main;
    }
    public MostRecentController(){mostRecent=new Movie();}
    public void setMostRecent(Movie m){
        mostRecent=m;
    }
    public void onBackButtonClick(ActionEvent actionEvent) throws Exception {
        main.showHomePage(main.p_company);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void showMostRecent(){
        String str[]=mostRecent.getMovieInfo();
        mostRecentMovieListView.getItems().addAll(str);
    }
}
