package sample;
import PlayerPackage.PlayerPackage.*;
import UserPackage.User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Side;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.event.ActionEvent;
import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Controller {
    @FXML private Pane signUp;
    @FXML private Pane signIn;
    @FXML private Pane home;
    @FXML private Pane formation;
    @FXML private Pane f433;
    @FXML private Pane f442;
    @FXML private Pane f451;
    @FXML private Pane f541;
    @FXML private Pane f523;
    @FXML private Pane f532;
    @FXML private Pane f343;
    @FXML private Pane f352;
    private Pane ChosenPane;
    @FXML private Button b433;
    @FXML private Button b442;
    @FXML private Button b451;
    @FXML private Button b541;
    @FXML private Button b523;
    @FXML private Button b532;
    @FXML private Button b343;
    @FXML private Button b352;
    @FXML private TextField txt_name;
    @FXML private TextField txt_email_Sign_Up;
    private  String txt_email_memory;
    @FXML private PasswordField txt_password_Sign_Up;
    @FXML private PasswordField txt_confirm_password;
    @FXML final ContextMenu usernameValidator = new ContextMenu();
    @FXML private TextField txt_email_Sign_In;
    @FXML private PasswordField txt_password_Sign_In;
    @FXML private Pane selectGoalkeeper;
    @FXML private Pane selectDefender;
    @FXML private Pane selectMidfielders;
    @FXML private Pane selectStrikers;
    @FXML private Pane yourTeam;
    @FXML private TableView<GoalKeeper> GoalkeeperTable;
    @FXML private TableColumn<GoalKeeper, String> playerNameInGoalkeepr;
    @FXML private TableColumn<GoalKeeper, String> TeamNameInGoalkeepers;
    @FXML private TableColumn<GoalKeeper, CheckBox> ButtonInGoalkeeper;
    @FXML private TableView<Defender> DefenderTable;
    @FXML private TableColumn<Defender, String> playerNameInDefender;
    @FXML private TableColumn<Defender, String>  TeamNameInDefenders;
    @FXML private TableColumn<Defender, Button>  ButtonInDefender;
    @FXML private TableView<Midfielder> MidfielderTable;
    @FXML private TableColumn<Midfielder, String> playerNameInMidfielder;
    @FXML private TableColumn<Midfielder, String> TeamNameInMidfielder;
    @FXML private TableColumn<Midfielder, Button> ButtonInMidfielder;
    @FXML private TableView<Striker> StrikerTable;
    @FXML private TableColumn<Striker, String> playerNameInStriker;
    @FXML private TableColumn<Striker, String> TeamNameInStriker;
    @FXML private TableColumn<Striker, Button> ButtonInStriker;
    @FXML private TableView<Player> totalPointsTable;
    @FXML private TableColumn<Player, String> col_playerName;
    @FXML private TableColumn<Player, String> col_playerTeam;
    @FXML private TableColumn<Player, Integer> col_playerPerformance;
    @FXML private Pane Admin;
    @FXML private TextField Admin_TeamName;
    @FXML private TextField Admin_PlayerName;
    @FXML private TextField Admin_NumOfCS;
    @FXML private TextField Admin_NumOfGoals;
    @FXML private TextField Admin_NumOfAssists;
    @FXML private Label Admin_Dn;
    @FXML private Pane Top3Users;
    @FXML private Label TopUser2;
    @FXML private Label TopUser1;
    @FXML private Label TopUser3;
    @FXML private Label totalPointsLabel;
    @FXML private Pane TPT;
    @FXML private Label TPT_Player;
    @FXML private Label TPT_Team;
    @FXML private Label TPT_Points;
    private int numOfDefenders=0;
    private int numOfMidfielders=0;
    private int numOfStrikers=0;
    private int confirmDefender=0;
    private int confirmMidfielder=0;
    private int confirmStriker=0;
    Connect con = new Connect();
    ResultSet rs;
    ObservableList<GoalKeeper> listOfGoalkeepers =  FXCollections.observableArrayList();
    ObservableList<Defender> listOfDefenders =  FXCollections.observableArrayList();
    ObservableList<Midfielder> listOfMidfielders =  FXCollections.observableArrayList();
    ObservableList<Striker> listOfStrikers =  FXCollections.observableArrayList();
    private User currentUser = new User();
    private String [] TeamName = {"Arsenal","Burnley","Chelsea","Everton","Leicester","Liverpool","Man city","Man utd","Spurs","Wolves"};
    private int [] TeamCounter = {0,0,0,0,0,0,0,0,0,0};

    @FXML
    //make validation for sign up
    public void validation(ActionEvent e)
    {
        if(txt_name.getText().equals(""))
        {
            usernameValidator.getItems().clear();
            usernameValidator.getItems().add(new MenuItem("Error please enter name"));
            usernameValidator.show(txt_name, Side.BOTTOM, 0,10);

        }
        else if(txt_email_Sign_Up.getText().equals(""))
        {
            usernameValidator.getItems().clear();
            usernameValidator.getItems().add(new MenuItem("Error please enter Email"));
            usernameValidator.show(txt_email_Sign_Up, Side.BOTTOM, 0,10);
        }
        else if(txt_password_Sign_Up.getText().equals(""))
        {
            usernameValidator.getItems().clear();
            usernameValidator.getItems().add(new MenuItem("Error please enter password"));
            usernameValidator.show(txt_password_Sign_Up, Side.BOTTOM, 0,10);
        }
        else if(txt_confirm_password.getText().equals(""))
        {
            usernameValidator.getItems().clear();
            usernameValidator.getItems().add(new MenuItem("Error in confirming password"));
            usernameValidator.show(txt_confirm_password, Side.BOTTOM, 0,10);
        }
    }
 //open sign in page
    @FXML public void toSignIn(ActionEvent e){
        signIn.setVisible(true);
        signUp.setVisible(false);
        home.setVisible(false);
        formation.setVisible(false);
        if (ChosenPane == null) {
            ChosenPane = signUp;
        }
        ChosenPane.setVisible(false);
        Admin.setVisible(false);
        yourTeam.setVisible(false);
        Top3Users.setVisible(false);
        TPT.setVisible(false);
        txt_email_Sign_In.clear();
        txt_password_Sign_In.clear();
        currentUser = new User();

    }
    @FXML public void loggingOut(ActionEvent e){
        if (currentUser.numOfPlayersInGUI<11){
            JOptionPane.showMessageDialog(null,"You have chosen only "+currentUser.numOfPlayersInGUI+" player/s!");
        }
        else {
            signIn.setVisible(true);
            signUp.setVisible(false);
            home.setVisible(false);
            formation.setVisible(false);
            if (ChosenPane == null) {
                ChosenPane = signUp;
            }
            ChosenPane.setVisible(false);
            Admin.setVisible(false);
            yourTeam.setVisible(false);
            Top3Users.setVisible(false);
            TPT.setVisible(false);
            txt_email_Sign_In.clear();
            txt_password_Sign_In.clear();
            currentUser = new User();
            currentUser.numOfPlayersInGUI = 0;
        }

    }
    //open sign up page
    @FXML public void toSignUp(ActionEvent e){

        txt_name.clear();
        txt_email_Sign_Up.clear();
        txt_password_Sign_Up.clear();
        txt_confirm_password.clear();
        GoalkeeperTable.setDisable(false);
        DefenderTable.setDisable(false);
        MidfielderTable.setDisable(false);
        StrikerTable.setDisable(false);
        signUp.setVisible(true);
        signIn.setVisible(false);
        home.setVisible(false);
        formation.setVisible(false);
        Top3Users.setVisible(false);
        currentUser = new User();
    }

    //open home page
    @FXML public void toHome(ActionEvent e) throws SQLException {
        if (txt_email_Sign_In.getText().equals("Admin")){
            if (txt_password_Sign_In.getText().equals("Admin")){
                Admin.setVisible(true);
                signUp.setVisible(false);
                signIn.setVisible(false);
                formation.setVisible(false);
                ChosenPane.setVisible(false);
                yourTeam.setVisible(false);
            }
        }else {
            rs = con.showYourTeam(txt_email_memory);
            currentUser.numOfPlayersInGUI = 0;
            while (rs.next()) {
                if ((rs.getString("Position")).equals("Goalkeeper")) {
                    currentUser.buyPlayer(new GoalKeeper(rs.getString("Name"), rs.getString("Team"), rs.getInt("Performance")));
                    currentUser.numOfPlayersInGUI++;
                } else if ((rs.getString("Position")).equals("Defender")) {
                    currentUser.buyPlayer(new Defender(rs.getString("Name"), rs.getString("Team"), rs.getInt("Performance")));
                    currentUser.numOfPlayersInGUI++;
                } else if ((rs.getString("Position")).equals("Midfielder")) {
                    currentUser.buyPlayer(new Midfielder(rs.getString("Name"), rs.getString("Team"), rs.getInt("Performance")));
                    currentUser.numOfPlayersInGUI++;
                } else if ((rs.getString("Position")).equals("Striker")) {
                    currentUser.buyPlayer(new Striker(rs.getString("Name"), rs.getString("Team"), rs.getInt("Performance")));
                    currentUser.numOfPlayersInGUI++;
                }
            }
            if (currentUser.numOfPlayersInGUI < 11) {
                JOptionPane.showMessageDialog(null, "You have chosen only " + currentUser.numOfPlayersInGUI + " player/s!");
            } else {
                home.setVisible(true);
                signUp.setVisible(false);
                signIn.setVisible(false);
                formation.setVisible(false);
                ChosenPane.setVisible(false);
                yourTeam.setVisible(false);
            }
        }
    }
    //select top three users
    @FXML public void toTopThree(ActionEvent e) throws SQLException {
        Top3Users.setVisible(!Top3Users.isVisible());
        rs =con.selectTop3();
        String [] arr = new String[3];
        int i = 0;
        while (rs.next()) {
            if ( i < 3) {
                arr[i] = rs.getString("Name");
                i++;
            }
        }
        TopUser1.setText(arr[0]);
        TopUser2.setText(arr[1]);
        TopUser3.setText(arr[2]);
    }

    //show all formation can be selected by user
    @FXML public void toChooseFormation(ActionEvent e){
        formation.setVisible(true);
        home.setVisible(false);
        signUp.setVisible(false);
        signIn.setVisible(false);
    }

    //show all available goal Keepers
    public void toGoalKeeper(ActionEvent e) throws SQLException {
        selectGoalkeeper.setVisible(!selectGoalkeeper.isVisible());
        if (selectGoalkeeper.isVisible()&&listOfGoalkeepers.isEmpty()){
            rs = con.selectAvailablePlayers("goalkeeper");

            while (rs.next()){
                listOfGoalkeepers.add(new GoalKeeper(rs.getString("Name"), rs.getString("Team")));
            }
            playerNameInGoalkeepr.setCellValueFactory(new PropertyValueFactory<>("Name"));
            TeamNameInGoalkeepers.setCellValueFactory(new PropertyValueFactory<>("ClubName"));
            ButtonInGoalkeeper.setCellValueFactory(new PropertyValueFactory<>("CheckBox"));
            GoalkeeperTable.setItems(listOfGoalkeepers);

        }
    }

    //check there is no more than three players in the same team , submit goal keeper to user and set his availability to zero
    public void submitGoalkeeper(ActionEvent e)throws SQLException{
        int ctr=0;
        for (GoalKeeper g: listOfGoalkeepers) {
            if(g.getCheckBox().isSelected()){
                ctr++;
            }
        }
        if (ctr==1){
            for (int i1 = 0; i1 < listOfGoalkeepers.size(); i1++) {
                GoalKeeper g = listOfGoalkeepers.get(i1);
                if (g.getCheckBox().isSelected()) {
                    ObservableList<GoalKeeper> delGK = FXCollections.observableArrayList();
                    for (int i = 0; i < 10; i++) {
                        if (TeamName[i].equals(g.getClubName()) && TeamCounter[i] < 3) {
                            TeamCounter[i]++;
                            con.addPlayerToUser(g.getName(), txt_email_memory);
                            currentUser.numOfPlayersInGUI++;
                            con.setAvailability(g.getName());
                            delGK.add(g);
                            listOfGoalkeepers.removeAll(delGK);
                            GoalkeeperTable.setDisable(true);
                            selectGoalkeeper.setVisible(!selectGoalkeeper.isVisible());
                            break;
                        }
                        if (TeamName[i].equals(g.getClubName()) && TeamCounter[i] >= 3) {
                            JOptionPane.showMessageDialog(null, "You chose 3 players from "+TeamName[i]+"!");
                        }
                    }
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"You must choose only one player!");
        }
    }

    //show all available defenders
    public void toDefender(ActionEvent e) throws SQLException {
        selectDefender.setVisible(!selectDefender.isVisible());
        if (selectDefender.isVisible()&&listOfDefenders.isEmpty()){
            rs = con.selectAvailablePlayers("defender");

            while (rs.next()){
                listOfDefenders.add(new Defender(rs.getString("Name"), rs.getString("Team")));
            }
            playerNameInDefender.setCellValueFactory(new PropertyValueFactory<>("Name"));
            TeamNameInDefenders.setCellValueFactory(new PropertyValueFactory<>("ClubName"));
            ButtonInDefender.setCellValueFactory(new PropertyValueFactory<>("CheckBox"));
            DefenderTable.setItems(listOfDefenders);
        }
    }

    //check there is no more than three players in the same team , submit defenders to user and set his availability to zero
    public void submitDefender(ActionEvent e)throws SQLException{
        int ctr=0;
        for (Defender d: listOfDefenders) {
            if(d.getCheckBox().isSelected()){
                ctr++;
            }
        }
        if (ctr==1){
            for (int i1 = 0; i1 < listOfDefenders.size(); i1++) {
                Defender d = listOfDefenders.get(i1);
                if (d.getCheckBox().isSelected()) {
                    ObservableList<Defender> delDF = FXCollections.observableArrayList();
                    for (int i = 0; i < 10; i++) {
                        if (TeamName[i].equals(d.getClubName()) && TeamCounter[i] < 3) {
                            TeamCounter[i]++;
                            con.addPlayerToUser(d.getName(), txt_email_memory);
                            currentUser.numOfPlayersInGUI++;
                            con.setAvailability(d.getName());
                            delDF.add(d);
                            confirmDefender++;
                            listOfDefenders.removeAll(delDF);
                            if (confirmDefender == numOfDefenders) {
                                DefenderTable.setDisable(true);
                            }
                            selectDefender.setVisible(!selectDefender.isVisible());
                            break;
                        }
                        if (TeamName[i].equals(d.getClubName()) && TeamCounter[i] >= 3) {
                            JOptionPane.showMessageDialog(null, "You chose 3 players from "+TeamName[i]+"!");
                        }
                    }
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"You must choose only one player!");
        }
    }

    //show user team
    @FXML public void toTeam(ActionEvent e) throws SQLException {
        home.setVisible(false);
        signUp.setVisible(false);
        signIn.setVisible(false);
        formation.setVisible(false);
        yourTeam.setVisible(true);

        if (yourTeam.isVisible()) {
            rs = con.showYourTeam(txt_email_memory);
            ObservableList<Player> list = FXCollections.observableArrayList();
            while (rs.next()) {
                if ((rs.getString("Position")).equals("Goalkeeper")) {
                    currentUser.buyPlayer(new GoalKeeper(rs.getString("Name"), rs.getString("Team"), rs.getInt("Performance")));
                } else if ((rs.getString("Position")).equals("Defender")) {
                    currentUser.buyPlayer(new Defender(rs.getString("Name"), rs.getString("Team"), rs.getInt("Performance")));
                } else if ((rs.getString("Position")).equals("Midfielder")) {
                    currentUser.buyPlayer(new Midfielder(rs.getString("Name"), rs.getString("Team"), rs.getInt("Performance")));
                } else if ((rs.getString("Position")).equals("Striker")) {
                    currentUser.buyPlayer(new Striker(rs.getString("Name"), rs.getString("Team"), rs.getInt("Performance")));
                }
            }

            list.addAll(currentUser.getTeam());
            col_playerName.setCellValueFactory(new PropertyValueFactory<>("Name"));
            col_playerTeam.setCellValueFactory(new PropertyValueFactory<>("ClubName"));
            col_playerPerformance.setCellValueFactory(new PropertyValueFactory<>("Performance"));
            totalPointsTable.setItems(list);
            totalPointsLabel.setText("" + currentUser.calcTotalPoints());
            con.setUserPoints(txt_email_memory, currentUser.calcTotalPoints());
            rs.close();
        }
    }

    //show all available midfielders
    public void toMidfielder(ActionEvent e) throws SQLException {
        selectMidfielders.setVisible(!selectMidfielders.isVisible());
        if (selectMidfielders.isVisible()&&listOfMidfielders.isEmpty()){
            rs = con.selectAvailablePlayers("midfielder");
            while (rs.next()){
                listOfMidfielders.add(new Midfielder(rs.getString("Name"), rs.getString("Team")));
            }
            playerNameInMidfielder.setCellValueFactory(new PropertyValueFactory<>("Name"));
            TeamNameInMidfielder.setCellValueFactory(new PropertyValueFactory<>("ClubName"));
            ButtonInMidfielder.setCellValueFactory(new PropertyValueFactory<>("CheckBox"));
            MidfielderTable.setItems(listOfMidfielders);
        }
    }

    //check there is no more than three players in the same team , submit midfielder to user and set his availability to zero
    public void submitMidfielder(ActionEvent e)throws SQLException{
        int ctr=0;
        for (Midfielder m: listOfMidfielders) {
            if(m.getCheckBox().isSelected()){
                ctr++;
            }
        }
        if (ctr==1){
            for (int i1 = 0; i1 < listOfMidfielders.size(); i1++) {
                Midfielder m = listOfMidfielders.get(i1);
                if (m.getCheckBox().isSelected()) {
                    ObservableList<Midfielder> delMF = FXCollections.observableArrayList();
                    for (int i = 0; i < 10; i++) {
                        if (TeamName[i].equals(m.getClubName()) && TeamCounter[i] < 3) {
                            TeamCounter[i]++;
                            con.addPlayerToUser(m.getName(), txt_email_memory);
                            currentUser.numOfPlayersInGUI++;
                            con.setAvailability(m.getName());
                            delMF.add(m);
                            confirmMidfielder++;
                            listOfMidfielders.removeAll(delMF);
                            if (confirmMidfielder == numOfMidfielders) {
                                MidfielderTable.setDisable(true);
                            }
                            selectMidfielders.setVisible(!selectMidfielders.isVisible());
                            break;
                        }
                        if (TeamName[i].equals(m.getClubName()) && TeamCounter[i] >= 3) {
                            JOptionPane.showMessageDialog(null, "You chose 3 players from "+TeamName[i]+"!");
                        }
                    }
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"You must choose only one player!");
        }
    }
    //show all available strikers
    public void toStriker(ActionEvent e) throws SQLException {
        selectStrikers.setVisible(!selectStrikers.isVisible());
        if (selectStrikers.isVisible()&&listOfStrikers.isEmpty()){
            rs = con.selectAvailablePlayers("striker");
            while (rs.next()){
                listOfStrikers.add(new Striker(rs.getString("Name"), rs.getString("Team")));
            }
            playerNameInStriker.setCellValueFactory(new PropertyValueFactory<>("Name"));
            TeamNameInStriker.setCellValueFactory(new PropertyValueFactory<>("ClubName"));
            ButtonInStriker.setCellValueFactory(new PropertyValueFactory<>("CheckBox"));
            StrikerTable.setItems(listOfStrikers);
        }
    }
    //check there is no more than three players in the same team , submit striker to user and set his availability to zero
    public void submitStriker(ActionEvent e)throws SQLException{
        int ctr=0;
        for (Striker s: listOfStrikers) {
            if(s.getCheckBox().isSelected()){
                ctr++;
            }
        }
        if (ctr==1){
            for (int i1 = 0; i1 < listOfStrikers.size(); i1++) {
                Striker s = listOfStrikers.get(i1);
                if (s.getCheckBox().isSelected()) {
                    ObservableList<Striker> delST = FXCollections.observableArrayList();
                    for (int i = 0; i < 10; i++) {
                        if (TeamName[i].equals(s.getClubName()) && TeamCounter[i] < 3) {
                            TeamCounter[i]++;
                            con.addPlayerToUser(s.getName(), txt_email_memory);
                            currentUser.numOfPlayersInGUI++;
                            con.setAvailability(s.getName());
                            delST.add(s);
                            confirmStriker++;
                            listOfStrikers.removeAll(delST);
                            if (confirmStriker == numOfStrikers) {
                                StrikerTable.setDisable(true);
                            }
                            selectStrikers.setVisible(!selectStrikers.isVisible());
                            break;
                        }
                        if (TeamName[i].equals(s.getClubName()) && TeamCounter[i] >= 3) {
                            JOptionPane.showMessageDialog(null, "You chose 3 players from "+TeamName[i]+"!");
                        }
                    }
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"You must choose only one player!");
        }
    }
    //set user formation to database
    @FXML public void toFormation(ActionEvent e) throws SQLException {
        formation.setVisible(false);
        home.setVisible(false);
        signUp.setVisible(false);
        signIn.setVisible(false);
        if(b433.isFocused()){
            f433.setVisible(true);
            con.addFormation(txt_email_memory,1);
            ChosenPane=f433;
            numOfDefenders=4;
            numOfMidfielders=3;
            numOfStrikers=3;
        }
        else if(b442.isFocused()){
            f442.setVisible(true);
            con.addFormation(txt_email_memory,2);
            ChosenPane=f442;
            numOfDefenders=4;
            numOfMidfielders=4;
            numOfStrikers=2;
        }
        else if(b451.isFocused()){
            f451.setVisible(true);
            con.addFormation(txt_email_memory,3);
            ChosenPane=f451;
            numOfDefenders=4;
            numOfMidfielders=5;
            numOfStrikers=1;
        }
        else if(b541.isFocused()){
            f541.setVisible(true);
            con.addFormation(txt_email_memory,4);
            ChosenPane=f541;
            numOfDefenders=5;
            numOfMidfielders=4;
            numOfStrikers=1;
        }
        else if(b532.isFocused()){
            f532.setVisible(true);
            con.addFormation(txt_email_memory,5);
            ChosenPane=f532;
            numOfDefenders=5;
            numOfMidfielders=3;
            numOfStrikers=2;
        }
        else if(b523.isFocused()){
            f523.setVisible(true);
            con.addFormation(txt_email_memory,6);
            ChosenPane=f523;
            numOfDefenders=5;
            numOfMidfielders=2;
            numOfStrikers=3;
        }
        else if(b343.isFocused()){
            f343.setVisible(true);
            con.addFormation(txt_email_memory,7);
            ChosenPane=f343;
            numOfDefenders=3;
            numOfMidfielders=4;
            numOfStrikers=3;
        }
        else if(b352.isFocused()){
            f352.setVisible(true);
            con.addFormation(txt_email_memory,8);
            ChosenPane=f352;
            numOfDefenders=3;
            numOfMidfielders=5;
            numOfStrikers=2;
        }
    }


    @FXML public void logOut(ActionEvent e){
        toSignIn(e);
    }
///save users (name , email , password)
    public void addToDB(ActionEvent e) throws SQLException {
        validation(e);
        if((!(txt_name.getText().equals(""))&&!(txt_email_Sign_Up.getText().equals(""))&&!(txt_password_Sign_Up.getText().equals("")))&&!(txt_confirm_password.getText().equals(""))){
            if (txt_password_Sign_Up.getText().equals(txt_confirm_password.getText())) {
                con.addUsers(txt_name.getText(), txt_email_Sign_Up.getText(), txt_password_Sign_Up.getText());
                txt_email_memory = txt_email_Sign_Up.getText();
                toChooseFormation(e);
            }
            else{
                usernameValidator.getItems().clear();
                usernameValidator.getItems().add(new MenuItem("Password isn't matching!"));
                usernameValidator.show(txt_confirm_password, Side.BOTTOM, 0,10);
            }
        }
    }


    public void SignInValidator(ActionEvent e)throws SQLException {
        if (!txt_email_Sign_In.getText().equals("")) {
            if (txt_email_Sign_In.getText().equals("Admin")) {
                if (txt_password_Sign_In.getText().equals("Admin")) {
                    toHome(e);
                }
                else if (txt_password_Sign_In.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Empty password box!");
                }
                else {
                    JOptionPane.showMessageDialog(null,"Wrong password!");
                }
            } else {
                rs = con.validateInDB();
                while (rs.next()) {
                    if (rs.getString("EMAIL").equals(txt_email_Sign_In.getText())) {
                        if (rs.getString("PASSWORD").equals(txt_password_Sign_In.getText())) {
                            txt_email_memory = txt_email_Sign_In.getText();
                            toHome(e);
                            rs.close();
                            break;
                        }
                        else if (txt_password_Sign_In.getText().equals("")){
                            JOptionPane.showMessageDialog(null,"Empty password box!");
                        }
                        else {
                            JOptionPane.showMessageDialog(null,"Wrong password!");
                        }
                    }
                }
                rs = null;
            }
        }
        else{
            JOptionPane.showMessageDialog(null,"Fill the form!");
        }
    }
    public void OnAdminConfirmation(ActionEvent e) throws SQLException {
        rs = con.selectAllPlayers();
        ObservableList<Player> list = FXCollections.observableArrayList();
        while(rs.next()) {
            if((rs.getString("Position")).equals("Goalkeeper")){
                list.add(new GoalKeeper(rs.getString("Name"),rs.getString("Team"),rs.getInt("Performance")));
            }
            else if((rs.getString("Position")).equals("Defender")) {
                list.add(new Defender(rs.getString("Name"), rs.getString("Team"), rs.getInt("Performance")));
            }
            else if((rs.getString("Position")).equals("Midfielder")) {
                list.add(new Midfielder(rs.getString("Name"), rs.getString("Team"), rs.getInt("Performance")));
            }
            else if((rs.getString("Position")).equals("Striker")) {
                list.add(new Striker(rs.getString("Name"), rs.getString("Team"), rs.getInt("Performance")));
            }
        }
        boolean isDone = false;
        for (Player p:list) {
            if (p.getName().equals(Admin_PlayerName.getText())&&p.getClubName().equals(Admin_TeamName.getText())){
                p.cleanSheet(Integer.parseInt(Admin_NumOfCS.getText()));
                p.scoringGoal(Integer.parseInt(Admin_NumOfGoals.getText()));
                p.assistingGoal(Integer.parseInt(Admin_NumOfAssists.getText()));
                con.setPlayerPerformance(p.getPerformance(), Admin_PlayerName.getText(), Admin_TeamName.getText());
                Admin_Dn.setVisible(true);
                Admin_TeamName.clear();
                Admin_PlayerName.clear();
                Admin_NumOfCS.clear();
                Admin_NumOfGoals.clear();
                Admin_NumOfAssists.clear();
                isDone = true;
                break;
            }
        }
        if (!isDone){
            JOptionPane.showMessageDialog(null, "Check the validation of the inputs!");
        }
    }
    public void textFieldisPressed(MouseEvent e){
        if (Admin_Dn.isVisible()){
            Admin_Dn.setVisible(false);
        }
    }

    public void toTopPlayer(ActionEvent e) throws SQLException {
        rs = con.showYourTeam(txt_email_memory);
        ObservableList<Player> list = FXCollections.observableArrayList();
        while (rs.next()) {
            if ((rs.getString("Position")).equals("Goalkeeper")) {
                currentUser.buyPlayer(new GoalKeeper(rs.getString("Name"), rs.getString("Team"), rs.getInt("Performance")));
            } else if ((rs.getString("Position")).equals("Defender")) {
                currentUser.buyPlayer(new Defender(rs.getString("Name"), rs.getString("Team"), rs.getInt("Performance")));
            } else if ((rs.getString("Position")).equals("Midfielder")) {
                currentUser.buyPlayer(new Midfielder(rs.getString("Name"), rs.getString("Team"), rs.getInt("Performance")));
            } else if ((rs.getString("Position")).equals("Striker")) {
                currentUser.buyPlayer(new Striker(rs.getString("Name"), rs.getString("Team"), rs.getInt("Performance")));
            }
        }
        TPT.setVisible(!TPT.isVisible());
        if (TPT.isVisible()) {
            TPT_Player.setText(currentUser.getTopPlayer().getName());
            TPT_Team.setText(currentUser.getTopPlayer().getClubName());
            TPT_Points.setText(String.valueOf(currentUser.getTopPlayer().getPerformance()));
        }
    }

}