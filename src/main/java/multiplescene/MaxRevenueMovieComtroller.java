package multiplescene;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import multiplescene.clientmain.Movie;

import java.net.URL;
import java.util.ResourceBundle;

public class MaxRevenueMovieComtroller implements Initializable {
    private Main main;
    void setMain(Main main) {
        this.main = main;
    }
    private Movie maxRevMovie;
    public ListView<String> maxRevenueMovieListview;


    public void setMaxRevMovie(Movie movie){
        maxRevMovie=movie;
    }
    public MaxRevenueMovieComtroller(){
        maxRevMovie=new Movie();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    public void showMax(){
        String[] str=maxRevMovie.getMovieInfo();
        //String[] str={"h","n"};
        //System.out.println(str[0]);
        maxRevenueMovieListview.getItems().addAll(str);
    }

    public void onBackButtonClick(ActionEvent actionEvent) throws Exception {
        main.showHomePage(main.p_company);
    }
}
