module imobiliaria {
    requires javafx.controls;
    requires javafx.fxml;

    opens imobiliaria to javafx.fxml;
    exports imobiliaria;
}
