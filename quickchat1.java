/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.chatapp.registration3;

import javax.swing.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
/**
 *
 * @author RC_Student_lab
 */
    
public class quickchat1 {
    
    static int messageNumber = 1;
    static int sentMessages = 0;
    
    static Random random = new Random();
    static JSONArray MessagesStored = new JSONArray();

    public void startChat(String Username, String password) {
       //link this is for login
       
        if (Username == null || password == null) {
            JOptionPane.showMessageDialog(null, "Your attempt to login has been cancelled./n Please try again later, Exiting .");
            System.exit(0);//stop the program
        }

        JOptionPane.showMessageDialog(null, "Welcome to QuickChat.");//only if login was successful
        int messageLimit = getMessageLimit();

        while (true) {
            String choice = JOptionPane.showInputDialog("""
                Please select an option:
                1) Send Messages
                2) Show recently sent messages (Coming soon)
                3) Quit
                 Please choose one option (1-3)                                       
            """);

            if (choice == null) System.exit(0);

            switch (choice) {
                case "1":
                    if (messageNumber > messageLimit) {
                        JOptionPane.showMessageDialog(null, "Message limit reached.");
                    } else {
                        String recipient = JOptionPane.showInputDialog("Enter recipient's phone number (with international code e.g +97 ,+27):");
                        if (!cellphoneVerification(recipient) || cellRecipientVerification(recipient) > 10) {
                            JOptionPane.showMessageDialog(null, "Invalid recipient number. Must include international code and have no more than 9 digits after the code.");
                            break;
                        }

                        String message = JOptionPane.showInputDialog("Enter your message ,your message must not exceed 250 characters .(max 250 characters):");
                        if (message == null || message.length() > 250) {
                            JOptionPane.showMessageDialog(null, "Please enter a mesaage of less than 50 characters (max 50 characters).");
                            break;
                        }

                        String messageID = String.format("%010d", random.nextInt(1_000_000_000));
                        if (!checkMessageID(messageID)) {
                            JOptionPane.showMessageDialog(null, "Message ID invalid.");
                            break;
                        }

                        String hash = createMessageHash(messageID, messageNumber, message);
                        String actionResult = SentMessage(messageID, messageNumber, recipient, message, hash);
                        JOptionPane.showMessageDialog(null, actionResult);
                        messageNumber++;
                    }
                    break;

                case "2":
                    JOptionPane.showMessageDialog(null, printMessages());//coming soon 
                    break;

                case "3":
                    JOptionPane.showMessageDialog(null, "Total messages handled: " + totalMessagesreturned());// Total number of messages sent
                    System.exit(0);
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
            }
        }
    }

    static boolean checkMessageID(String id) {
        return id != null && id.length() <= 10;
    }

    static int cellRecipientVerification(String number) {
        
        if (number == null || !number.startsWith("+")) return Integer.MAX_VALUE;
        String withoutPlus = number.substring(1); 
        String[] parts = withoutPlus.split("(?<=\\d{1,3})(?=\\d{7,10})", 2); 
        if (parts.length != 2) return Integer.MAX_VALUE;
        return parts[1].length();
    }

    static String createMessageHash(String messageID, int messageNumber, String message) {
        String[] words = message.trim().split("\\s+");
        String first = words.length > 0 ? words[0] : "";
        String last = words.length > 1 ? words[words.length - 1] : first;
        return (messageID.substring(0, 2) + ":" + messageNumber + ":" + first + last).toUpperCase();
    }

    static String SentMessage(String messageID, int messageNumber, String recipient, String message, String hash) {
        String[] options = {"Send Message", "Discard Message", "Store Message to send later"};
        int action = JOptionPane.showOptionDialog(null, "Message Hash: " + hash + "\nPlease selecet an option ?",
                "Message Options", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, options, options[0]);

        JSONObject nessageJSON = new JSONObject();
        
        nessageJSON.put("hash", hash);
        nessageJSON.put("messageNumber", messageNumber);
        nessageJSON.put("recipient", recipient);
        nessageJSON.put("message", message);
        nessageJSON.put("id", messageID);
               

        switch (action) {
            case 0: // Send first button 
                sentMessages++;
                return "Your message has been sent.";
            case 1: // Disregard(second message
                return "Your message has been discarded.";
            case 2: // Store(third button)
                storeMessage(nessageJSON);
                saveMessagesToJson();
                sentMessages++;
                return "Message has been stored to send later .";
            default:
                return "No action taken.";//printing message(option 2 )
        }
    }

    static String printMessages() {
        if (MessagesStored.isEmpty()) return "There are no stored messages.";
        StringBuilder sb = new StringBuilder("Stored Messages:\n\n");
        for (Object obj : MessagesStored) {
            JSONObject msg = (JSONObject) obj;
            sb.append("To: ").append(msg.get("recipient")).append("\n");
            sb.append("Message: ").append(msg.get("message")).append("\n");
            sb.append("Hash: ").append(msg.get("hash")).append("\n\n");
        }
        return sb.toString();
    }

    static void storeMessage(JSONObject NotifJSON) {
        MessagesStored.add(NotifJSON);
    }

    static int totalMessagesreturned() {
        return sentMessages;
    }

    static boolean cellphoneVerification(String cellphone) {
        return cellphone != null && cellphone.matches("^\\+\\d{1,3}\\d{7,10}$");
    }

    static int getMessageLimit() {
        int limit = -1;
        while (limit <= 0) {
            String input = JOptionPane.showInputDialog("How many messages do you wish to send?");
            if (input == null) System.exit(0);
            //added
            if (input.matches("\\d+")) {
                limit = Integer.parseInt(input);
                if (limit > 0) {
                    break ;
                }else{
                    JOptionPane.showMessageDialog(null, "Number must be greater than 0.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid number, please enter a whole number.");
            }
        }
        return limit;
    }

    static void saveMessagesToJson() {
        try (FileWriter file = new FileWriter("stored_messages.json")) {
            file.write(MessagesStored.toJSONString());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error saving to JSON.");
        }
    }
}