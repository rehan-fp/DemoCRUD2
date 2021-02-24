package sample;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller implements Initializable{
    private Label label;
    @FXML
    private TextField tfID;
    @FXML
    private TextField tfTitle;
    @FXML
    private TextField tfAuthor;
    @FXML
    private TextField tfYear;
    @FXML
    private TextField tfPages;
    @FXML
    private TableView<sample.Books> tvBooks;
    @FXML
    private TableColumn<sample.Books, Integer> colID;
    @FXML
    private TableColumn<sample.Books,String> colTitle;
    @FXML
    private TableColumn<sample.Books,String> colAuthor;
    @FXML
    private TableColumn<sample.Books,Integer> colYear;
    @FXML
    private TableColumn<sample.Books,Integer> colPages;
    @FXML
    private Button btnInsert;
    @FXML
    private Button btnUpdate;
    @FXML
    private Button btnDelete;


    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World");
    }
     @Override
    public void initialize(URL url,ResourceBundle rb){
    }
    public Connection getConnection() {
        Connection conn;
        try {
            conn = DriverManager.getConnection("String");
            return conn;


        } catch (Exception ex) {
            System.out.println("Error:" + ex.getMessage());
            return null;

        }
    }
    public ObservableList<sample.Books>getBooksList(){
        ObservableList<sample.Books>booklist=FXCollections.observableArrayList();
        Connection conn=getConnection();
        String query="SELECT * FROM books";
        Statement st;
        ResultSet rs;
        try {
            st=conn.createStatement();
            rs=st.executeQuery(query);
            sample.Books books;
            while (rs.next()){
                books=new sample.Books(rs.getInt("Id"),rs.getString("Title"),rs.getString("Author"), rs.getInt("Year"), rs.getInt("Pages"));
                booklist.add(books);
            }

        } catch (Exception ex){
            ex.printStackTrace();
        }
        return booklist;


    }
    public void showBooks(){
        ObservableList<sample.Books>list=getBooksList();
        colID.setCellValueFactory(new PropertyValueFactory<sample.Books,Integer>("Id"));
        colTitle.setCellValueFactory(new PropertyValueFactory<sample.Books,String>("Title"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<sample.Books,String>("Author"));
        colYear.setCellValueFactory(new PropertyValueFactory<sample.Books,Integer>("Year"));
        colPages.setCellValueFactory(new PropertyValueFactory<sample.Books,Integer>("Pages"));


    }

}
