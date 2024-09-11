package app;
import java.net.URL;
import java.util.ResourceBundle;

import app.Logical.Sorting;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;

public class indexController implements Initializable {
    int vetorSize = 100;
    int[] vetor = new int[vetorSize];

    @FXML
    private ChoiceBox<String> sortingChoiceBox;
    private String[] ordenationMethods = {
        "InsertionSort",
        "SelectionSort",
        "BubbleSort", 
        "ShakerSort",
        "ShellSort",
        "HeapSort", 
        "QuickSort", 
    };
    
    @FXML
    private CheckBox txtCheckBox;

    @FXML
    private Button gerarVetorButton;
    
    @FXML
    private TextArea vetorTextField;

    @FXML
    private TableView<?> ordenationMetricsTable;

    @FXML private Label insertionTime;    
    @FXML private Label insertionTrade;

    @FXML private Label selectionTime;    
    @FXML private Label selectionTrade;

    @FXML  private Label heapTime;   
    @FXML private Label heapTrade;     

    @FXML private Label quickTime;    
    @FXML private Label quickTrade;    

    @FXML private Label shakerTime;    
    @FXML private Label shakerTrade;
    

    @FXML private Label shellTime;   
    @FXML private Label shellTrade;

    @FXML private Label bubbleTime;
    @FXML private Label bubbleTrade;
    

    
    //Construtor do Initialize
    //Aqui vão os metodos onStart da aplicação.
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sortingChoiceBox.getItems().addAll(ordenationMethods);
     }

    @FXML
    void gerarVetor(ActionEvent event) {
        for(int i = 0; i < vetorSize; i++){
            this.vetor[i] = (int)(Math.random() * 100) + 1;
            vetorTextField.setText(Sorting.vetorParaString(vetor));
        }
    }

    @FXML
    void ordenarVetor(ActionEvent event) {
        String sortingOptionChoiced = sortingChoiceBox.getValue();

        switch (sortingOptionChoiced) {
            case "InsertionSort":
                System.out.println("InsertionSort");
                Sorting.insertionSort(vetor, insertionTime, insertionTrade);
                vetorTextField.setText(Sorting.vetorParaString(vetor));
                break;

            case "SelectionSort":
                System.out.println("SelectionSort");
                Sorting.selectionSort(vetor, selectionTime, selectionTrade);
                vetorTextField.setText(Sorting.vetorParaString(vetor));                
                break;

            case "BubbleSort":
                System.out.println("BubbleSort");
                Sorting.bubbleSort(vetor, bubbleTime, bubbleTrade);
                vetorTextField.setText(Sorting.vetorParaString(vetor));
                break;

            case "ShakerSort":
                System.out.println("ShakerSort");
                Sorting.shakerSort(vetor, shakerTime, shakerTrade);
                vetorTextField.setText(Sorting.vetorParaString(vetor));
                break;

            case "ShellSort":
                System.out.println("ShellSort");
                Sorting.shellSort(vetor, shellTime, shellTrade);
                vetorTextField.setText(Sorting.vetorParaString(vetor));
                break;

            case "HeapSort":
                System.out.println("HeapSort");
                Sorting.heapsort(vetor, heapTime, heapTrade);
                vetorTextField.setText(Sorting.vetorParaString(vetor));
                break;             

            case "QuickSort":
                System.out.print("QuickSort");
                Sorting.quickSort(vetor, quickTime, quickTrade);
                vetorTextField.setText(Sorting.vetorParaString(vetor));
                break;

            default:
                break;
        }
    }
}
