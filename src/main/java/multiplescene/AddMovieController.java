package multiplescene;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import multiplescene.clientmain.Movie;
import multiplescene.server.ReadThreadServer;
import multiplescene.server.Server;

import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AddMovieController {
    private Main main;
    void setMain(Main main) {
        this.main = main;
    }
    public TextField titleText;
    public TextField r_yearText;
    public TextField genre1Text;
    public TextField genre2Text;
    public TextField genre3Text;

    public TextField r_timeText;
    public TextField budgetText;
    public TextField revenueText;

    public void onConfirmClick(ActionEvent actionEvent) throws IOException {
        if(titleText.getText().length()!=0&&r_timeText.getText().length()!=0&&r_yearText.getText().length()!=0&&budgetText.getText().length()!=0&&revenueText.getText().length()!=0){
            Movie m=new Movie();
            final String OUTPUT_FILE_NAME = "movies.txt";
            //BufferedWriter bw = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
            FileWriter bw = new FileWriter(OUTPUT_FILE_NAME,true);
            //RandomAccessFile b=new RandomAccessFile("mov.txt","rw");

            m.setTitle(titleText.getText());
            m.setRelease_year(Integer.parseInt(r_yearText.getText()));
            m.setRunning_time(Integer.parseInt(r_timeText.getText()));
            m.setProduction_company(main.p_company);
            m.setBudget(Integer.parseInt(budgetText.getText()));
            m.setRevenue(Integer.parseInt(revenueText.getText()));
            String str[]={genre1Text.getText(),genre2Text.getText(),genre3Text.getText()};
            m.setGenre(str);

            bw.write(titleText.getText()+","+r_yearText.getText()+","+genre1Text.getText()+","+genre2Text.getText()+",");
            bw.write(genre3Text.getText()+","+r_timeText.getText()+","+main.p_company+","+budgetText.getText()+","+revenueText.getText());
            bw.write(System.lineSeparator());
            bw.close();

           //  ReadThreadServer.allMovieList.add(m);

        }else {
            main.showAlert1();
        }

    }

    public void onBackClick(ActionEvent actionEvent) throws Exception {
        main.showHomePage(main.p_company);
    }
}
