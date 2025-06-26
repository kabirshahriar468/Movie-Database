package multiplescene;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import multiplescene.clientmain.Movie;

import java.util.ArrayList;
import java.util.List;

public class ShowMovieController {
    public TableColumn<Movie,String> genreCol1;
    public TableColumn<Movie,String> genreCol2;
    private Main main;
    void setMain(Main main) {
        this.main = main;
    }
    public List<Movie> allMovieList;
    public void setAllMovieList(List<Movie> m){
        allMovieList=m;
    }
    public TableView<Movie> tableView;
    public TableColumn<Movie,String> titleCol;
    public TableColumn<Movie, Long> r_yearCol;
    public TableColumn<Movie,String> genreCol;
    public TableColumn<Movie,Integer> r_timeCOl;
    public TableColumn<Movie,Long> budgetCol;
    public TableColumn<Movie,Long> revenueCol;
    @FXML
    void initialize(){
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        r_yearCol.setCellValueFactory(new PropertyValueFactory<>("release_year"));
        genreCol.setCellValueFactory(new PropertyValueFactory<>("genre1"));
        genreCol1.setCellValueFactory(new PropertyValueFactory<>("genre2"));
        genreCol2.setCellValueFactory(new PropertyValueFactory<>("genre3"));
        //genreCol.setCellFactory();
        r_timeCOl.setCellValueFactory(new PropertyValueFactory<>("running_time"));
        budgetCol.setCellValueFactory(new PropertyValueFactory<>("budget"));
        revenueCol.setCellValueFactory(new PropertyValueFactory<>("revenue"));

    }
    public ShowMovieController(){
        allMovieList=new ArrayList<>();
    }

    public void showMovie(){
        for(Movie m: allMovieList){
            tableView.getItems().add(m);
        }
    }

    public void onBackClick(ActionEvent actionEvent) throws Exception {
        main.showHomePage(main.p_company);
    }
}
