package gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import services.ServiceUtilisateur;




public class LoginForm extends Form {
    
    private TextField emailField;
    private TextField passwordField;
    
    public LoginForm() {
        super(new BorderLayout(BorderLayout.CENTER_BEHAVIOR_CENTER_ABSOLUTE));
        
        // create form elements
        Container center = new Container(new BoxLayout(BoxLayout.Y_AXIS));
        Label emailLabel = new Label("Email:");
        emailField = new TextField("", "Enter your email address", 20, TextField.EMAILADDR);
        Label passwordLabel = new Label("Password:");
        passwordField = new TextField("", "Enter your password", 20, TextField.PASSWORD);
        Button loginButton = new Button("Login");
        Button registerButton = new Button("Register");
                
                 loginButton.addActionListener((evt) ->{
                     try{
                         ServiceUtilisateur.getInstance().signin(emailField.getText(),passwordField.getText());
                     }catch(Exception e){
                         System.out.println("errorrrrr");
                     }
    });
                 
               
registerButton.addActionListener((evt) -> {
    new RegisterForm().show();
});

        // add form elements to container
        center.add(emailLabel);
        center.add(emailField);
        center.add(passwordLabel);
        center.add(passwordField);
        center.add(loginButton);
        center.add(registerButton);
        
        // add container to form
        add(BorderLayout.CENTER, center);
    }
    
    // getters for email and password fields
    public String getEmail() {
        return emailField.getText();
    }
    
    public String getPassword() {
        return passwordField.getText();
    }
}
