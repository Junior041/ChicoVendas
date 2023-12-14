module br.com.unifebe.aulafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens br.com.unifebe.aulafx to javafx.fxml;
    exports br.com.unifebe.aulafx;
    exports br.com.unifebe.aulafx.controller;
    opens br.com.unifebe.aulafx.controller to javafx.fxml;
    opens br.com.unifebe.aulafx.model to javafx.base;
    opens br.com.unifebe.aulafx.dao to javafx.base;

}