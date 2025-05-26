/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.chatapp.registration3;

import javax.swing.*;

public class Registration3 {

    public String Username;
    public String password;
    public String firstName;
    public String lastName;
    public String cellphone;
     
    //Username contains an underscore and is no more tahn five characters long
    public void CheckUsername(){
        if (Username == null ) {
            Username = JOptionPane.showInputDialog("Username cannot be empty. \n Please enter a username: ");
        }
        if (Username == null){
            JOptionPane.showMessageDialog(null,"Registration cancelled,");
}       //return;

        boolean Underscore = Username.contains("_");
        if (Underscore && Username.length()<= 5){
            JOptionPane.showMessageDialog(null,"You username has been successfully captured");   
          
}else{
            JOptionPane.showMessageDialog(null,"Your username is incorrectly formatted .\n Please ensure your username contains an underscore and is five characters in length.");
            Username = JOptionPane.showInputDialog("Welcome to registeration please enter username");
            CheckUsername();
            //method for if the user wants to quit registration

        }
        
    }
   //method to check password. password meets the following password complexity rules , the password must be more than eight characters long ,contain a capirl letter and a number and a spesciL CASE
    public boolean checkpassword (String password){
        boolean hasUppercase = false,hasDigit=false ,hasSpecialChar=false;
        
        //define special chaaracters
        String SpecialChar="~'!@#$%^&*()_+{}[]:;?/><,|\"." ;
        
        //check each character in password
        for(char ch:password.toCharArray()){
        if(Character.isUpperCase(ch))hasUppercase=true;
        if(Character.isDigit(ch))hasDigit=true;
        if(SpecialChar.contains(String.valueOf(ch)))hasSpecialChar =true;
        }  
        return password.length()> 8 && hasUppercase && hasDigit && hasSpecialChar;
    }
       
    public void RegisterUser (){
        //username
        
        
        Username = JOptionPane.showInputDialog("Welcome!.\nTo register you need to enter your username .\nPlease enter username: ");
        CheckUsername();
        //password
        password = JOptionPane.showInputDialog("Please enter your password. Your passwords needs to contain: \n- Atleast 1 Uppercase \n- Atleast 1 digit \n- Atleast 1 special character \n- More than 8 caharacters long");

            //check password while was here
            while (!checkpassword(password)){
              JOptionPane.showMessageDialog(null,"Password is incorrectly format \n- Please ensure your password contains : \n- Atleast 1 uppercase letter \n-  Atleast 1 digit \n- Atleast 1 special character \n- More than 8 characters. ");
              password = JOptionPane.showInputDialog("Enter your password again : ");
   }
    //the cellphone contains the international country code followed by th number , which is no more than ten characters
    cellphone = JOptionPane.showInputDialog("Enter cellphone(with country code, e.g. +27...)");
    while(!cellphone.matches("\\+\\d{10,}")){
     cellphone = JOptionPane.showInputDialog("Invalid cellphone number.Please enter digits only.");
    }        
    //done
    
    JOptionPane.showMessageDialog(null,"Registration complete,Welcome " + Username + ", Next step is to Login");
    
  
  }
    public static void main(String[] args) {
        Registration3 user = new Registration3();
        user.RegisterUser();
        // Pass username and password to login
       
        
        Login3 login = new Login3(user.Username, user.password,user.firstName,user.lastName,user.cellphone);
        
        boolean loginSuccess = login.loginUser();
    
    
        JOptionPane.showMessageDialog(null,login.returnLoginStatus(loginSuccess));
   
       if (loginSuccess ){
           quickchat1 chat = new quickchat1();
           chat.startChat(user.Username, user.password);
       }
}
    }

