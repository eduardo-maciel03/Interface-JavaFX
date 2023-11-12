package trabalhofaculdade;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Slider;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class CadastroUsuarioController implements Initializable {
    

    @FXML
    Button btnSalvar;
    @FXML
    Button btnSair;
    @FXML
    Button btnNovo;
    @FXML
    TextField txtNome;
    @FXML
    SplitMenuButton splitEstadoCivil;
    @FXML
    CheckBox checkBrasileiro;
    @FXML
    DatePicker dateData;
    @FXML
    CheckBox checkSim;
    @FXML
    CheckBox checkNao;
    @FXML
    Slider sliderEscolaridade;
    
    @FXML
    MenuItem splitSolteiro;
    
    @FXML
    MenuItem splitCasado;
    
    @FXML
    MenuItem splitViuvo;
    
    @FXML
    MenuItem splitDivorciado;
    
    @FXML
    Label Label1;
    
    int mySlider;
    String stringSlider;
    String estCivil;
    
    @FXML
    private void slider (){
        sliderEscolaridade.valueProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2){
                mySlider = (int) sliderEscolaridade.getValue();
            }
        });
        
        if(mySlider >= 0 && mySlider < 25) stringSlider = "Fundamental";
        if(mySlider >= 25 && mySlider < 50) stringSlider = "Médio";
        if(mySlider >= 50 && mySlider < 75) stringSlider = "Superior";
        if(mySlider >= 75 && mySlider < 100) stringSlider = "Mestrado";
        if(mySlider == 100) stringSlider = "Doutorado";
        
    }
    
    @FXML
    private void splitEstadoCivil (ActionEvent event){        

    }
    
    @FXML
    private void splitSolteiro (ActionEvent event){
       estCivil = "Solteiro";
       splitEstadoCivil.setText(estCivil);
    }
    
    @FXML
    private void splitCasado (ActionEvent event){
       estCivil = "Casado";
       splitEstadoCivil.setText(estCivil);
    }
    
    @FXML
    private void splitViuvo (ActionEvent event){
       estCivil = "Viúvo";
       splitEstadoCivil.setText(estCivil);
    }
    
    @FXML
    private void splitDivorciado (ActionEvent event){        
       estCivil = "Divorciado";
       splitEstadoCivil.setText(estCivil);
    }
    
    @FXML
    private void btnSair (ActionEvent event){
        System.exit(0);
    }
    @FXML
    private void btnSalvar (ActionEvent event) throws IOException{
        String nome = txtNome.getText();
        
        boolean br = false;
        boolean cnh = false;
        
        if(checkBrasileiro.isSelected() == true) br = true;
        if(checkSim.isSelected() == true || checkNao.isSelected() == true) cnh = true;
        
        slider();
        
        String cnhValida = "";
        
        if (checkSim.isSelected() == true) {
            cnhValida = "True";
        }
        else if(checkNao.isSelected() == true){
            cnhValida = "False";
        }
        else{
            cnhValida = "True" ;
        }

        
        LocalDate myDate = dateData.getValue();
        String data = myDate.toString();
        
        String informacao = "Cadastro Efetuado com sucesso! \n"+
                            "Usuario: " + nome + "\n" +
                            "Estato Civil: " + estCivil + "\n"+
                            "Brasileiro: " + br + "\n"+
                            "Data de Nascimento: " + data + "\n" +
                            "Possui CNH: " + cnhValida + "\n" +
                            "Escolaridade: " + stringSlider + "\n";
        
        if((nome != null) && (estCivil != null) && (br == true) && (!data.equals("null")) && (cnh == true))
        {
            JOptionPane.showMessageDialog(null, "Cadastro Efetuado com sucesso!\n"+nome);
            JOptionPane.showMessageDialog(null, informacao);
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Existem Campos Vazios!", "Alerta",JOptionPane.ERROR_MESSAGE);
        }
        
     }
    
    @FXML
    private void btnNovo (ActionEvent event){
        txtNome.setText("");
        estCivil = null;
        checkBrasileiro.setSelected(false);
        checkSim.setSelected(false);
        checkNao.setSelected(false);
        sliderEscolaridade.setValue(0);
        splitEstadoCivil.setText("Selecione");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       dateData.setValue(LocalDate.now());
       slider();
    }    
    
}