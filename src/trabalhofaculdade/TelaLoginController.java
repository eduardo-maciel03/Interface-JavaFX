package trabalhofaculdade;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class TelaLoginController implements Initializable {
    
    int tentativasLog = 1;
    
    @FXML
    Button btnSair;
    
    @FXML
    Button btnLogin;
    
    @FXML
    Button btn_home;
    
    @FXML
    TextField login;
    
    @FXML
    PasswordField senha;
    
    @FXML
    CheckBox verSenha;
    
    
    @FXML
    private void btnSair(ActionEvent event){
        System.exit(0);
    }
    
    @FXML
    private void btnLogin(ActionEvent event) throws IOException{
        
        if(tentativasLog != 3){
            if("admin".equals(login.getText()) && "admin".equals(senha.getText())){
                JOptionPane.showMessageDialog(null,"Logado com sucesso" );
                String file = "CadastroUsuario.fxml";
                URL url = getClass().getResource(file);
                Parent root = FXMLLoader.load(url);
                Scene scene = new Scene(root);
                Stage stage = (Stage) btnLogin.getScene().getWindow();
                stage.setScene(scene);
                stage.setTitle("Unimater");
                stage.show();
                tentativasLog = 1;
            }
            else{
                JOptionPane.showMessageDialog(null,"Informe um usuario e uma senha válida \n" + "Tentativas:"+tentativasLog+"/3","ALERTA", JOptionPane.ERROR_MESSAGE);
                login.setText("");
                senha.setText("");
                tentativasLog += 1;
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"Informe um usuario e uma senha válida \n" + "Tentativas:"+tentativasLog+"/3","ALERTA", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    
    @FXML
    private void btnHome(ActionEvent event) throws IOException{
        login.setText("");
        senha.setText("");
        tentativasLog = 1;
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}