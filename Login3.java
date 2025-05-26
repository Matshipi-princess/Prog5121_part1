package com.chatapp.registration3;

import javax.swing.*;

public class Login3 {

    private String registeredUsername;
    private String registeredpassword;
    private String firstName;
    private String lastName;
    private String registeredcellphone;
    
    private boolean loginSuccessful;

    public Login3(String Username, String password ,String firstName ,String lastName, String cellphone) {
        this.registeredUsername = Username;
        this.registeredpassword = password;
        
        
            
    }
    //this methods ensures that any username contains an underscore (_)and is more than
    public boolean checkUserName(){
        return registeredUsername.contains("_") && registeredUsername.length() <=5;
}   
    //this method ensures that password meet the following password complexity rules
    public boolean checkpassword(){
       boolean hasUppercase = false, hasDigit= false, hasSpecialChar = false;
       String specialChars = "~'!@#$%^&*()_+{}[]:;?/><,|\".";
    
        for (char ch: registeredpassword.toCharArray()){
          if(Character.isUpperCase(ch))hasUppercase = true;
          if (Character.isDigit(ch))hasDigit =true;
          if(specialChars.contains(String.valueOf(ch)))hasSpecialChar = true;
    }
     return registeredpassword.length()>8 && hasUppercase && hasDigit && hasSpecialChar;

}
    //method ensures cellphone is the correct length and contains the international code
    public boolean cellphoneNumber(){
        return registeredcellphone.contains("\\+\\d{10,}");
        
    }
    //this method returns necessary registration messaging 
     public String registerUser(){
    if(!checkUserName()){
        return "Username is incorrectly formatted,please ensure that your username contains an underscore '_'and is no more than 5 characters.";
}
    
    if(!checkpassword()){
        return "Password does not meet complexity requirements.";
       
}
    if(!cellphoneNumber()){
    } else {
        return"Cellphone is not valid";
        }
    return "user has been registered successfully.";
}
     //this methos verifies that the login details entered match the login details stored when the user registers
     public boolean loginUser(){
        String enteredUsername =JOptionPane.showInputDialog("Login\nPlease enter your username; ");
        String enteredpassword = JOptionPane.showInputDialog("Please enter your password: ");
        String firstName = JOptionPane.showInputDialog("Every hero has a name - Whats yours ? : ");
        String lastName = JOptionPane.showInputDialog("Full identity mode: ACTIVATED \nWhat's your last name? ");
        
        return enteredUsername.equals(registeredUsername )&& enteredpassword.equals(registeredpassword);
        
     }//method returns messaging for successful or failed login
     
    public String returnLoginStatus(boolean loginSuccessful){
                
        if(loginSuccessful){
            return "Access granted your login was successful .Welcome its good to have you!";
        }else{
            return "Username or password incorrect , please try again";
        }

 
    
        
    }

}
    

