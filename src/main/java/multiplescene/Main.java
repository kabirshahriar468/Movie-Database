package multiplescene;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import multiplescene.clientmain.Movie;
import multiplescene.util.SocketWrapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private Stage stage;
    private SocketWrapper socketWrapper;

    public Stage getStage() {
        return stage;
    }
    public String p_company;
    public List<Movie> allMovieList;

    public void setAllMovieList(List<Movie> allMovieList) {
        this.allMovieList = allMovieList;
    }

    public SocketWrapper getSocketWrapper() {
        return socketWrapper;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;
        connectToServer();
        showLoginPage();
    }

    private void connectToServer() throws IOException {
        String serverAddress = "127.0.0.1";
        int serverPort = 1759;
        socketWrapper = new SocketWrapper(serverAddress, serverPort);
        new ReadThread(this);
    }

    public void showLoginPage() throws Exception {
        // XML Loading using FXMLLoader
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("login.fxml"));
        Parent root = loader.load();

        // Loading the controller
        LoginController controller = loader.getController();
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle("Login");
        stage.setScene(new Scene(root, 400, 300));
        stage.show();
    }

    public void showHomePage(String userName) throws Exception {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("home.fxml"));
        Parent root = loader.load();
        this.p_company=userName;
        // Loading the controller
        HomeController controller = loader.getController();
        //controller.init(userName);
        controller.setMain(this);

        // Set the primary stage
        stage.setTitle(userName);
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
    public void showMaxRevenuePage(String name, Movie maxRevMovie) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("max-revenue-movie.fxml"));
        Parent root = loader.load();
        MaxRevenueMovieComtroller controller=loader.getController();
        controller.setMain(this);
        controller.setMaxRevMovie(maxRevMovie);
        controller.showMax();
        stage.setTitle(name);
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
    public void showMostRecentPage(String name,Movie mostRecent) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("most-recent.fxml"));
        Parent root = loader.load();
        MostRecentController controller=loader.getController();
        controller.setMain(this);
        controller.setMostRecent(mostRecent);
        controller.showMostRecent();
        stage.setTitle(name);
        stage.setScene(new Scene(root, 600, 400));
        stage.show();
    }
   public void showTotalProfit(String name,long profit) throws IOException{
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("total-profit.fxml"));
       Parent root = loader.load();
       TotalProfitController controller=loader.getController();
       controller.setMain(this);
       controller.setProfit(profit);
       controller.showProfit();
       stage.setTitle(name);
       stage.setScene(new Scene(root, 600, 400));
       stage.show();
   }
   public void showAllMovie(String name, List<Movie> allMovie) throws IOException {
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("show-movie.fxml"));
       Parent root = loader.load();
       ShowMovieController controller=loader.getController();
       controller.setMain(this);
       controller.setAllMovieList(allMovie);
       controller.showMovie();
       stage.setTitle(name);
       stage.setScene(new Scene(root, 900, 700));
       stage.show();
   }
   public void showAddMovie(String name) throws IOException {
       System.out.println("showing add movie");
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("add-movie.fxml"));
       Parent root = loader.load();
       System.out.println("showing add movie");
       AddMovieController controller=loader.getController();
       controller.setMain(this);

       stage.setTitle(name);
       stage.setScene(new Scene(root, 600, 400));
       stage.show();

   }
   public void showTransferMovie(String name )throws IOException{
       System.out.println("showing transfer movie");
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("transfer-movie.fxml"));
       Parent root = loader.load();

       TransferMovieController controller=loader.getController();
       controller.setMain(this);
       stage.setTitle(name);
       stage.setScene(new Scene(root, 600, 400));
       stage.show();
   }
    public void showAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Incorrect Credentials");
        alert.setHeaderText("Incorrect Credentials");
        alert.setContentText("The username and password you provided is not correct.");
        alert.showAndWait();
    }
    public void showAlert1() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Alert!!!");
        alert.setHeaderText("Enter necessary Credentials");
        alert.setContentText("Must enter title,release year,running time,budget,revenue.");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        // This will launch the JavaFX application

        launch(args);
    }
}
