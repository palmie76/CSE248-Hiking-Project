package GUI_components;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class MainView extends BorderPane{
	Text text;
	Button btnProfile;
	Button btnTrail;
	VBox vbox;
	
	MainView(){
		vbox = new VBox();
		text = new Text("Select type");
		
		vbox.getChildren().addAll(text, createButtons());
		vbox.setPadding(new Insets(10, 10, 10, 10));
		vbox.setSpacing(10);
		vbox.setAlignment(Pos.CENTER);
		
		this.setCenter(vbox);
	}
	
	HBox createButtons() {
		HBox hbox = new HBox();
		btnProfile = new Button("Profiles");
		btnTrail = new Button("Trails");
		
		hbox.getChildren().addAll(btnProfile, btnTrail);
		hbox.setAlignment(Pos.CENTER);
		hbox.setSpacing(10);
		hbox.setPadding(new Insets(10, 10, 10, 10));
		
		return hbox;
	}

}
