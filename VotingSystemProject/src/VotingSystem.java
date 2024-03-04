import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Pair;

public class VotingSystem extends Application  {
	String matricNo;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver loaded");
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/votesystem", "root", "jumantara");
		System.out.println("Database connected");
		
		//Login Scene
		TextField tfMatricNo = new TextField();
		TextField tfPassword = new TextField();
		Button btLogin = new Button("Login");
		
		//initialize pane and add to pane
		GridPane paneLogin = new GridPane();
		paneLogin.setHgap(5);
		paneLogin.setVgap(5);
		
		
		paneLogin.add(new Label("Matric no: "), 0, 0);
		paneLogin.add(tfMatricNo, 1, 0);
		
		paneLogin.add(new Label("Password: "), 0, 1);
		paneLogin.add(tfPassword, 1, 1);
		
		paneLogin.add(btLogin, 1, 2);
		final Text actionTarget = new Text();
		paneLogin.add(actionTarget,0,3);
		
		//set center
		paneLogin.setAlignment(Pos.CENTER);
		Scene sceneLogin = new Scene(paneLogin,400,250);
		
		matricNo = "";
		
		//Verification Scene
		TextField tfName = new TextField();
		TextField tMatricVer = new TextField();
		TextField tfFaculty = new TextField();
		TextField tfCollege = new TextField();

		
		
		

		//initialize pane and add to scene
		GridPane paneVer = new GridPane();
		paneVer.setHgap(5);
		paneVer.setVgap(5);
		
		paneVer.add(new Label("Name: "), 0, 0);
		paneVer.add(tfName, 1, 0);
		
		paneVer.add(new Label("Matric: "), 0, 1);
		paneVer.add(tMatricVer, 1, 1);
		
		paneVer.add(new Label("Faculty: "), 0, 2);
		paneVer.add(tfFaculty, 1, 2);
		
		paneVer.add(new Label("College: "), 0, 3);
		paneVer.add(tfCollege, 1, 3);
		
		paneVer.setAlignment(Pos.CENTER);
		Scene sceneVerify = new Scene(paneVer,400,250);
		
		
		
		//Voting Sceneara
		
		 RadioButton voteSyaidi = new RadioButton("");
		 RadioButton voteNeyman = new RadioButton("");
		 RadioButton voteRyan = new RadioButton("");
		 
		//initialize pane and add to scene
		 GridPane votePane = new GridPane();
		  votePane.setHgap(10);
		  votePane.setVgap(10);

		
		 //Add voting
		votePane.add(voteSyaidi, 2, 1);
		votePane.add(voteNeyman, 2, 2);
		votePane.add(voteRyan, 2, 3);


		 //add mudah logo
		 Image imageMudah = new Image("C:\\Users\\User\\Programming Codes\\Java\\CSC3104\\VotingSystemProject\\MUDAH.png");
		 
		 //add Name Logo
		 //Image imageSyai = new Image("C:\\Users\\rezal\\OneDrive\\Pictures\\syedsyaidi.png");
		 ImageView imgMudah = new ImageView(imageMudah);
		 votePane.add(imgMudah,1,1);
		 //votePane.add(imageSyai, 0, 0);
		 imgMudah.setFitWidth(154);
		 imgMudah.setFitHeight(100);
		 
		 //add sarapan logo
		 Image imageSRP = new Image("C:\\Users\\User\\Programming Codes\\Java\\CSC3104\\VotingSystemProject\\SARAPAN.png");
		 ImageView imgSrp = new ImageView(imageSRP);
		 votePane.add(imgSrp,1,2);
		 imgSrp.setFitWidth(150);
		 imgSrp.setFitHeight(100);
		 
		 
		 //add garisan logo
		 Image imageGR = new Image("C:\\Users\\User\\Programming Codes\\Java\\CSC3104\\VotingSystemProject\\GARISAN RASIONAL.png");
		 ImageView imgGR = new ImageView(imageGR);
		 votePane.add(imgGR,1,3);
		 imgGR.setFitWidth(150);
		 imgGR.setFitHeight(100);
		 
		 
		votePane.setAlignment(Pos.CENTER);
		Scene sceneVote = new Scene(votePane,500,400);		


		//set Background Color
		votePane.setStyle("-fx-background-color: #FFFFFF;");
		//votePane.setStyle("-fx-background-color: black;");
		sceneVote.setFill(Color.BLACK);
		
		
		//if correct at verify scene will take to voting scene
		Button Correct = new Button("Info Correct");
		Correct.setOnAction(e -> primaryStage.setScene(sceneVote));
		paneVer.add(Correct, 1, 5);
		
		//for administrator login
		TextField tfUsernameAdm = new TextField();
		PasswordField tfPasswordAdm = new PasswordField();
		Button btLoginAdm = new Button("Login");
		TextField failedAdm = new TextField();
				
		
		//initialize pane and add to pane
		GridPane paneLoginAdm = new GridPane();
		paneLoginAdm.setHgap(5);
		paneLoginAdm.setVgap(5);
		
		
		paneLoginAdm.add(new Label("Username: "), 0, 0);
		paneLoginAdm.add(tfUsernameAdm, 1, 0);
		
		paneLoginAdm.add(new Label("Password: "), 0, 1);
		paneLoginAdm.add(tfPasswordAdm, 1, 1);
		
		paneLoginAdm.add(btLoginAdm, 1, 2);
		final Text actionTarget1 = new Text();
		paneLoginAdm.add(actionTarget1,0,3);
		
		paneLoginAdm.setAlignment(Pos.CENTER);
		
		Scene sceneLoginAdm = new Scene(paneLoginAdm,400,250);
		
		//Scene for Registers Voter


		//initialize pane and add to scene
		GridPane paneRegisters = new GridPane();
		paneRegisters.setHgap(5);
		paneRegisters.setVgap(5);
		
		

		paneVer.setAlignment(Pos.CENTER);
		Scene sceneRegisters = new Scene(paneRegisters,400,250);
		
		//administrator navigating scene
		GridPane paneNavigation = new GridPane();
		paneNavigation.setHgap(5);
		paneNavigation.setVgap(5);
		
		Button votersCheck = new Button("Voters Check");
		votersCheck.setOnAction(e -> primaryStage.setScene(sceneRegisters));
				
		Button statFac = new Button("Faculty Voters");
		statFac.setOnAction(e -> primaryStage.setScene(sceneLoginAdm));
				
		Button statCollege = new Button("College Voters");
		statCollege.setOnAction(e -> primaryStage.setScene(sceneLoginAdm));
		
		paneNavigation.add(votersCheck, 0, 0);
		paneNavigation.add(statFac, 0, 1);
		paneNavigation.add(statCollege, 0, 2);

		
		Scene sceneNavigation = new Scene(paneNavigation,400,250);

		
		//Choose user type Scene
		GridPane paneChoose = new GridPane();

		Button chooseVoters = new Button("Voters");
		chooseVoters.setOnAction(e -> primaryStage.setScene(sceneLogin));
		paneChoose.add(chooseVoters, 0, 0);
				
		Button chooseAdmin = new Button("Admin");
		chooseAdmin.setOnAction(e -> primaryStage.setScene(sceneLoginAdm));
		paneChoose.add(chooseAdmin, 0, 1);
		paneChoose.setAlignment(Pos.CENTER);

		
		Scene sceneChoose = new Scene(paneChoose,400,250);
		
		
		//Primary Stage Set
		
		primaryStage.setTitle("Putra Voting");
		primaryStage.setScene((sceneChoose));
		primaryStage.show();
		
		
		//button if click and correct will take to next scene 
		btLogin.setOnAction(event -> {
			try {
				Statement statementLogin = connection.createStatement();
				
				ResultSet resultSetLogin = statementLogin.executeQuery("select MatricNo, Name, VotersPassword from voters where MatricNo = '" + tfMatricNo.getText() + "'");
					
				while(resultSetLogin.next()) {
					System.out.println(resultSetLogin.getString(1) + " " + resultSetLogin.getString(2) + " " + resultSetLogin.getString(3));
						
					String inputtedMatricNo = tfMatricNo.getText();
					String availableMatricNo = resultSetLogin.getString(1);
					String inputtedPassword = tfPassword.getText();
					String availablePassword = resultSetLogin.getString(3);
						
					if(availableMatricNo.equals(inputtedMatricNo) && availablePassword.equals(inputtedPassword)) {
						matricNo = availableMatricNo;
						
						try {
							Statement statementVerify = connection.createStatement();
							
							ResultSet resultSetVerify = statementVerify.executeQuery("select Name, MatricNo, FacultyName, CollegeName from voters natural join (faculty, college) where matricNo = '" + matricNo + "'");
								
							while(resultSetVerify.next()) {
								System.out.println(resultSetVerify.getString(1) + " " + resultSetVerify.getString(2) + " " + resultSetVerify.getString(3) + " " + resultSetVerify.getString(4));
						
								tfName.setText(resultSetVerify.getString(1));
								tMatricVer.setText(resultSetVerify.getString(2));
								tfFaculty.setText(resultSetVerify.getString(3));
								tfCollege.setText(resultSetVerify.getString(4));
							}
							} catch (Exception e) {
								e.printStackTrace();
							}
						primaryStage.setScene(sceneVerify);
					} else {
						//Login failed
						actionTarget.setText("Incorrect");
					}
					
				} 
			}catch (Exception e) {
				e.printStackTrace();
			}
			
				
					
			/*
			 * Pair<String, String> credentials =
			 * readCredentialsFromFile("C:\\Users\\User\\Downloads\\credentials.txt.txt");
			 * String correctUsername = credentials.getKey(); String correctPassword =
			 * credentials.getValue();
			 * 
			 * if (tfMatricNo.getText().equals(correctUsername) &&
			 * tfPassword.getText().equals(correctPassword)) {
			 * primaryStage.setScene(sceneVerify); } else { //Login failed
			 * actionTarget.setText("Incorrect!"); }
			 */
			
		});
		
		btLoginAdm.setOnAction(event -> {
			try {
				Statement statementLoginAdm = connection.createStatement();
				
				ResultSet resultSetLoginAdm = statementLoginAdm.executeQuery("select AdminUsername, AdminPassword from admin where AdminUsername = '" + tfUsernameAdm.getText() + "'");
					
				while(resultSetLoginAdm.next()) {
					System.out.println(resultSetLoginAdm.getString(1) + " " + resultSetLoginAdm.getString(2));
						
					String inputtedUsername = tfUsernameAdm.getText();
					String availableUsername = resultSetLoginAdm.getString(1);
					String inputtedPassword = tfPassword.getText();
					String availablePassword = resultSetLoginAdm.getString(2);
						
					if(availableUsername.equals(inputtedUsername) && availablePassword.equals(inputtedPassword)) {
						primaryStage.setScene(sceneVerify);
					} else {
						//Login failed
						actionTarget.setText("Incorrect");
					}
					
				} 
			}catch (Exception e) {
				e.printStackTrace();
			}
			/*
			 * Pair<String, String> credentials =
			 * readCredentialsFromFile("C:\\Users\\User\\Downloads\\credentials.txt.txt");
			 * String correctUsername = credentials.getKey(); String correctPassword =
			 * credentials.getValue();
			 * 
			 * if (tfMatricNoAdm.getText().equals(correctUsername) &&
			 * tfPasswordAdm.getText().equals(correctPassword)) {
			 * primaryStage.setScene(sceneNavigation); } else { //Login failed
			 * actionTarget.setText("Incorrect!"); }
			 */
			
		});
		
		
	}
	
	/*
	 * private Pair<String,String> readCredentialsFromFile(String fileName){ try {
	 * //Read from file BufferedReader reader = new BufferedReader(new
	 * FileReader(fileName));
	 * 
	 * //split by comma(Username,Password); String[] credentials =
	 * reader.readLine().split(","); String username = credentials[0]; String
	 * password = credentials[1]; reader.close(); return new Pair<>(username,
	 * password); } catch (IOException e) { // File not found or error reading the
	 * file return new Pair<>(null, null); } }
	 */
	
	public static void main(String[] args) throws Exception{
		/*
		 * Class.forName("com.mysql.jdbc.Driver"); System.out.println("Driver loaded");
		 * 
		 * Connection connection =
		 * DriverManager.getConnection("jdbc:mysql://localhost:3306/votesystem", "root",
		 * "jumantara"); System.out.println("Database connected");
		 * 
		 * Statement statement = connection.createStatement();
		 * 
		 * ResultSet resultSet = statement.
		 * executeQuery("select MatricNo, Name from voters where MatricNo = '211001'");
		 * 
		 * while(resultSet.next()) { System.out.println(resultSet.getString(1) + "\t" +
		 * resultSet.getString(2));
		 * 
		 * }
		 * 
		 * connection.close();
		 */
			
		
		launch(args);
	}
}
	
	