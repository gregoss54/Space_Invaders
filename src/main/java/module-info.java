module fr.greg.space_invaders {
    requires javafx.controls;
    requires javafx.fxml;


    opens fr.greg.space_invaders to javafx.fxml;
    exports fr.greg.space_invaders;
}