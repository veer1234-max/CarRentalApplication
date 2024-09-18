module com.example.w22comp1008gcassignment2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.w22comp1008gcassignment2 to javafx.fxml;
    exports com.example.w22comp1008gcassignment2;
}