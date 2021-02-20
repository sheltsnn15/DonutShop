
package donutshop;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class DonutShopMain extends Application implements EventHandler<ActionEvent> {
    
    TextField txtDonutNum;
    ChoiceBox<String> choicebox;
    GridPane grid1, grid2;
    Label lblPlainO, lblSugarCO, lblChocO, lblSprinkledO, lblGrandTotalO, lblCarryOn, lblFinaliseOrder;
    Button btnSubmitOrder, btnCancelOrder, btnClearForm,
            btnAddOrder, btnFinalOrder;
    Stage window;
    Scene scene1, scene2;
    
    DonutShop plain, sugarCoated, chocolate, sprinkled;
    
    boolean orderIsDone = false;
    boolean submitOrder = true;
    int quantity = 0;
    double grandTotal;
    
    public static void main(String[] args) {

    launch(args);

    }

    @Override
    public void start(Stage primaryStage) {
        System.out.println("First Page, Please Order Donuts");
        plain = new DonutShop ("Plain Donuts", 1.99); 
        sugarCoated = new DonutShop ("Sugarcoated Donuts", 2.50); 
        chocolate = new DonutShop ("Chocolate Donuts", 2.99); 
        sprinkled = new DonutShop ("Sprinkled Donuts", 2.99);
        
//Scene1 beginning
        window = primaryStage;
        window.setTitle("Donut Shop");
        Label lblMessage = new Label("Welcome to Donut Shop");
        
        Label lblDonutType = new Label("Donut Type:");
        
        Label lblnumDonuts = new Label("Number Of Donuts:");
        txtDonutNum = new TextField();
        txtDonutNum.setPromptText("Enter number of donuts");
        
        btnSubmitOrder = new Button("Submit Order");
        btnCancelOrder = new Button("Cancel Order");
        btnClearForm = new Button("Clear Form");
        
        choicebox = new ChoiceBox();
        
        //get CB items
        choicebox.getItems().addAll(null,(String.format(plain.getdonutType() + " - %.2f", plain.getPrice())),
                (String.format(sugarCoated.getdonutType() + " - %.2f", sugarCoated.getPrice())), 
                (String.format(chocolate.getdonutType() + " - %.2f", plain.getPrice())),
                (String.format(sprinkled.getdonutType() + " - %.2f", sprinkled.getPrice())));
        //set default
        choicebox.setValue(null);
        
        //listen 4 selection changes
        choicebox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> Observable, String oldValue, String newValue) {
                //System.out.println(newValue);
            }
        });
        
        //set btn actions(see handle() method)
        btnClearForm.setOnAction(this);
        btnCancelOrder.setOnAction(this);
        btnSubmitOrder.setOnAction(this);
        
        //Grid Pane layout
        grid1 = new GridPane();
        grid1.setPadding(new Insets(10, 10, 10, 10));
        grid1.setVgap(8);
        grid1.setHgap(10);
        //set layout(variable, int Yheight, int Xheight)
        GridPane.setConstraints(lblMessage, 0, 0);
        GridPane.setConstraints(lblDonutType, 0, 1);
        GridPane.setConstraints(choicebox, 1, 1);
        GridPane.setConstraints(lblnumDonuts, 0, 3);
        GridPane.setConstraints(txtDonutNum, 1, 3);
        GridPane.setConstraints(btnSubmitOrder, 3, 5);
        GridPane.setConstraints(btnCancelOrder, 4, 5);
        GridPane.setConstraints(btnClearForm, 5, 5);
        grid1.getChildren().addAll(lblMessage, lblDonutType, choicebox, lblnumDonuts, 
                txtDonutNum, btnSubmitOrder, btnCancelOrder, btnClearForm);
        
        scene1 = new Scene(grid1, 600, 200);
//Scene1 ending

        window.setTitle("Donut Shop");
        window.setScene(scene1);
        window.show();        
    }
    
    public Scene orderInfo() {
        System.out.println("\nOrder Info/Details Page");
//Scene2 beginning        
        Label lblOrder = new Label("You Have Ordered:");
        
        Label lblPlain = new Label("Plain Donuts: ");
        lblPlainO = new Label();
        lblPlainO.setText(Integer.toString(plain.getDonutsOrdered()));
        
        Label lblSugarC = new Label("Sugar Coated Donuts: ");
        lblSugarCO = new Label();
        lblSugarCO.setText(Integer.toString(sugarCoated.getDonutsOrdered()));
        
        Label lblChoc = new Label("Chocolate Donuts: ");
        lblChocO = new Label();
        lblChocO.setText(Integer.toString(chocolate.getDonutsOrdered()));
        
        Label lblSprinkled = new Label("Sprinkled Donuts: ");
        lblSprinkledO = new Label();
        lblSprinkledO.setText(Integer.toString(sprinkled.getDonutsOrdered()));
        
        Label lblGrandTotal = new Label("Grand Total = ");
        lblGrandTotalO = new Label();
        
        lblGrandTotalO.setText(Double.toString(grandTotal));
        
        lblCarryOn = new Label("Click To Add To Your Order:");
        btnAddOrder = new Button("Add Order");
        
        lblFinaliseOrder = new Label("Click to Finalise Order:");
        btnFinalOrder = new Button("Finalise Order");
        
        //set btn actions(see handle() method)
        btnAddOrder.setOnAction(this);
        btnFinalOrder.setOnAction(this);
        
        //create gridPane
        grid2 = new GridPane();
        grid2.setPadding(new Insets(10, 10, 10, 10));
        grid2.setVgap(8);
        grid2.setHgap(10);
        //set scene2 layout
        GridPane.setConstraints(lblOrder, 0, 0);
        GridPane.setConstraints(lblPlain, 0, 1);
        GridPane.setConstraints(lblPlainO, 1, 1);
        GridPane.setConstraints(lblSugarC, 0, 2);
        GridPane.setConstraints(lblSugarCO, 1, 2);
        GridPane.setConstraints(lblChoc, 0, 3);
        GridPane.setConstraints(lblChocO, 1, 3);
        GridPane.setConstraints(lblSprinkled, 0, 4);
        GridPane.setConstraints(lblSprinkledO, 1, 4);
        GridPane.setConstraints(lblGrandTotal, 0, 5);
        GridPane.setConstraints(lblGrandTotalO, 1, 5);
        GridPane.setConstraints(lblCarryOn, 1, 6);
        GridPane.setConstraints(btnAddOrder, 3, 6);
        GridPane.setConstraints(lblFinaliseOrder, 1, 7);
        GridPane.setConstraints(btnFinalOrder, 3, 7);
        //get scene2 variables
        grid2.getChildren().addAll(lblOrder, lblPlain, lblPlainO, lblSugarC, lblSugarCO, lblChoc, lblChocO,
                lblSprinkled, lblSprinkledO, lblGrandTotal, lblGrandTotalO, lblCarryOn, btnAddOrder, lblFinaliseOrder, btnFinalOrder);
        //create scene2
        scene2 = new Scene(grid2, 500, 300);
//Scene2 ending
        window.setScene(scene2);
        return scene2;

    }
    
    //get selected item 
    private double calcOrder() {
        grandTotal = plain.getDonutsOrdered() * plain.getPrice() +
                sugarCoated.getDonutsOrdered() * sugarCoated.getPrice() +
                chocolate.getDonutsOrdered() * chocolate.getPrice() +
                sprinkled.getDonutsOrdered() * sprinkled.getPrice();
        
        System.out.println("Grand Total: " + grandTotal);
        
        if (grandTotal > 10) {
        grandTotal -= (grandTotal * 0.1);
        System.out.println(String.format("You qualify for a 10 per cent discount you price is now € %.2f \n", grandTotal));
        getInformationBox("10% discount", "Your grand total is over 10euros\n You qualify for a 10% discount\n New Grand Total = " + grandTotal);
        
        
        }
        return grandTotal;
    }
    
    public void closeProgram() {
        System.out.println("Thank you \n"
                + "Program Closed");
        window.close();
    }
    
    
    
    //check if user selected donutType

    private boolean validateCheckBox (ChoiceBox value) {
        //validate if customer has selected donut type
        String choice = (String) value.getValue();
        
        if (choice == null) {
            getErrorBox("Validate Fields", "Select Donut Type \nUse Donut Menu Dropdown ");
            return false;
        }
        return true;
    }
    
    //clear form
    public void refreshForm() {
        choicebox.setValue(null);
        txtDonutNum.clear();
    }
    
    //submit the order
    public void submitOrder (ChoiceBox<String> choice, TextField amount ) {
    switch (choice.getValue()) {
        case "Plain Donuts - 1.99":
            System.out.println("Donut Type: " + choice.getValue() + "\n"
            + "Amount: " + amount.getText());
            plain.setDonutsOrdered(Integer.parseInt(amount.getText()));break;
        case "Sugarcoated Donuts - 2.50":
            System.out.println("Donut Type: " + choice.getValue() + "\n"
            + "Amount: " + amount.getText());
            sugarCoated.setDonutsOrdered(Integer.parseInt(amount.getText()));break;
        case "Chocolate Donuts - 2.99":
            System.out.println("Donut Type: " + choice.getValue() + "\n"
            + "Amount: " + amount.getText());
            chocolate.setDonutsOrdered(Integer.parseInt(amount.getText()));break;
        case "Sprinkled Donuts - 2.99":
            System.out.println("Donut Type: " + choice.getValue() + "\n"
            + "Amount: " + amount.getText());
            sprinkled.setDonutsOrdered(Integer.parseInt(amount.getText()));break;
        default:
            System.out.println("\n\tOrder submitted");break;
        }
    }
    
    
    //Form actions
    @Override
    public void handle(ActionEvent event) {
//Scene 1 Actions
        if (event.getSource() == choicebox) {
            System.out.println(choicebox.getValue());
        }
        if (event.getSource() == btnSubmitOrder) {
                
                if(!validateCheckBox(choicebox) || !(txtFisEmpty (txtDonutNum) || isDigitOnly(txtDonutNum))){
                    getErrorBox("Validate fileds", "please ensure all ia good");
                }
                
                else if (validateCheckBox(choicebox) || txtFisEmpty (txtDonutNum) || isDigitOnly(txtDonutNum)){
                    submitOrder(choicebox, txtDonutNum);
                    calcOrder();
                    orderInfo();
                }

                
        }
        if (event.getSource() == btnCancelOrder) {
            Boolean ans = CloseBox.show("Cancel Order, Close Program ","Are you sure you want to cancel order and close program?");
		if (ans)
			window.close();
        }
        if (event.getSource() == btnClearForm) {
            refreshForm();
        }
//Scene 2 buttonActions
        if (event.getSource() == btnAddOrder) {
            window.setScene(scene1);
            refreshForm();
        }
        if (event.getSource() == btnFinalOrder) {
            Boolean ans = CloseBox.show("Finalise Order, Close Program", "Are you sure you want to finalise your order and close program?");
		if (ans)
			window.close();
        }
    }   
    
    public static Alert getInformationBox(String headerText, String contentText) { //Method what will give you alert box(information)
        Alert alert1 = new Alert(AlertType.INFORMATION);
        alert1.setTitle("Information Box");
        alert1.setHeaderText(headerText);
        alert1.setContentText(contentText);
        alert1.showAndWait();
                
        return alert1;
    }
    
    public static Alert getErrorBox(String headerText, String contentText) { //Method what will give you alert box(error)
        Alert alert1 = new Alert(AlertType.ERROR);
        alert1.setTitle("Error Box");
        alert1.setHeaderText(headerText);
        alert1.setContentText(contentText);
        alert1.showAndWait();
		
	return alert1;
    }
    
    public static Alert getConfirmationBox(String headerText, String contentText) { //Method what will give you alert box(confirmation)
		
        Alert alert1 = new Alert(AlertType.CONFIRMATION);
        alert1.setTitle("Confirmation Box");
        alert1.setHeaderText(headerText);
        alert1.setContentText(contentText);
        alert1.showAndWait();

        return alert1;
    }
    
    private static boolean txtFisEmpty (TextField input) {
        String text = input.getText();
        if (text.isEmpty()) {
           getErrorBox("Check Fields", "TextFields Empty \n Please Enter Password");
           return true;
        } 
    return false;

   }
    
   public static boolean isDigitOnly(TextField text) { //Method what will set input to be only digits
        String input = text.getText(); 
        
        try {  
            int a = Integer.parseInt(input);  
            return true;
        }catch(NumberFormatException ex){  
            getErrorBox("Validate field", "Invalid input \nPlease ensure you entered a number");
            return false;
        }

        /*if(!phone.matches("[0-9]+")) {
            getErrorBox("Non-Digit Input", "Please Enter Digits For Your Phone Number");
            throw new NumberFormatException("Invalid Input!");
        }else 
            System.out.println("Correct Input!");
            */

    }
   
   public TextField donutsNumOrdered() {
            return txtDonutNum;
        }
}