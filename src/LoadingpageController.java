import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoadingpageController implements Initializable {
    public ProgressBar loadProgress;
    public Label lblLoad;
    public AnchorPane LoadingContext;
    Thread t1;
    static int i=0;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setProgres();
    }

    private void setProgres() {
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                lblLoad.setText(String.valueOf(loadProgress.getProgress() * 100));
            }
        });
        t1 = new Thread() {
            @Override
            public void run() {
                while (loadProgress.getProgress() <= 1) {

                    loadProgress.setProgress(loadProgress.getProgress() + 0.1);
                    Platform.runLater(new Runnable() {
                        @Override
                        public void run() {
                            if (lblLoad.getText().equals("100%")) {
                                //Navigation.navigate(Routes.LOGIN,pane);
                                Stage window=(Stage)LoadingContext.getScene().getWindow();
                                try {
                                    window.setScene(new Scene(FXMLLoader.load(getClass().getResource("MainForm.fxml"))));
                                } catch (IOException e) {
                                    System.out.println(e);
                                }

                            } else {
                                i += 10;
                                lblLoad.setText(i + "%");
                            }
                        }
                    });


                    try {
                        t1.sleep(130);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        };
        t1.start();



    }


}
