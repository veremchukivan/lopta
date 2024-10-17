module ukf.sk.lopta {
    requires javafx.controls;
    requires javafx.fxml;


    opens ukf.sk.lopta to javafx.fxml;
    exports ukf.sk.lopta;
}