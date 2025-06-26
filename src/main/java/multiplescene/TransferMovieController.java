package multiplescene;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;
import multiplescene.clientmain.Movie;

import java.io.*;

public class TransferMovieController {
    public TextField movieTextfield;
    public TextField p_companyTextfield;
    private Main main;
    void setMain(Main main) {
        this.main = main;
    }
    public void onConfirmClick(ActionEvent actionEvent) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("movies.txt"));
        DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream("movies.txt")));

        while (in.available()>0) {
            Movie tempMovie=new Movie();
            final String OUTPUT_FILE_NAME = "movies.txt";
            FileWriter bw = new FileWriter(OUTPUT_FILE_NAME,true);
            String line = br.readLine();

            if (line == null) break;
            String[] movieInfo=line.split(",");

            //System.out.println(line);
            //System.out.println(movieInfo[8]);
            tempMovie.setTitle(movieInfo[0]);
            tempMovie.setRelease_year(Integer.parseInt(movieInfo[1]));
            String[] tempGenre={movieInfo[2],movieInfo[3],movieInfo[4]};
            tempMovie.setGenre(tempGenre);
            tempMovie.setRunning_time(Integer.parseInt(movieInfo[5]));
            tempMovie.setProduction_company(movieInfo[6]);
            tempMovie.setBudget(Integer.parseInt(movieInfo[7]));
            tempMovie.setRevenue(Integer.parseInt(movieInfo[8]));
            if(tempMovie.getTitle().equalsIgnoreCase(movieTextfield.getText())){
                bw.write(tempMovie.getTitle()+","+tempMovie.getRelease_year()+","+tempMovie.getGenre1()+","+tempMovie.getGenre2()+","+tempMovie.getGenre3()+",");
                //bw.write();
                bw.write(tempMovie.getRunning_time()+","+p_companyTextfield.getText()+","+tempMovie.getBudget()+","+tempMovie.getRevenue());
                //bw.write();

                bw.close();
                br.close();
                main.showHomePage(main.p_company);
                break;
            }
            //allMovieList.add(tempMovie);

        }
        br.close();
    }

    public void onBackClick(ActionEvent actionEvent) throws Exception {
        main.showHomePage(main.p_company);
    }
}
