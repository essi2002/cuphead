module com.example.cuphead {
    requires javafx.controls;

    requires javafx.fxml;

    requires com.google.gson;

    requires javafx.media;




    opens com.example.cuphead to javafx.fxml,com.google.gson;
    opens com.example.cuphead.View to javafx.fxml,com.google.gson;
    opens com.example.cuphead.Model to javafx.fxml,com.google.gson;
    exports com.example.cuphead;
    exports com.example.cuphead.View;
    exports  com.example.cuphead.Model;

}