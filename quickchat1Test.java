/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.chatapp.registration3;

import org.json.simple.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author matsh
 */
public class quickchat1Test {
    
    public quickchat1Test() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of startChat method, of class quickchat1.
     */
    @Test
    public void testStartChat() {
        System.out.println("startChat");
        String Username = "";
        String password = "";
        quickchat1 instance = new quickchat1();
        instance.startChat(Username, password);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkMessageID method, of class quickchat1.
     */
    @Test
    public void testCheckMessageID() {
        System.out.println("checkMessageID");
        String id = "";
        boolean expResult = false;
        boolean result = quickchat1.checkMessageID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cellRecipientVerification method, of class quickchat1.
     */
    @Test
    public void testCellRecipientVerification() {
        System.out.println("cellRecipientVerification");
        String number = "";
        int expResult = 0;
        int result = quickchat1.cellRecipientVerification(number);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createMessageHash method, of class quickchat1.
     */
    @Test
    public void testCreateMessageHash() {
        System.out.println("createMessageHash");
        String messageID = "";
        int messageNumber = 0;
        String message = "";
        String expResult = "";
        String result = quickchat1.createMessageHash(messageID, messageNumber, message);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of SentMessage method, of class quickchat1.
     */
    @Test
    public void testSentMessage() {
        System.out.println("SentMessage");
        String messageID = "";
        int messageNumber = 0;
        String recipient = "";
        String message = "";
        String hash = "";
        String expResult = "";
        String result = quickchat1.SentMessage(messageID, messageNumber, recipient, message, hash);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of printMessages method, of class quickchat1.
     */
    @Test
    public void testPrintMessages() {
        System.out.println("printMessages");
        String expResult = "";
        String result = quickchat1.printMessages();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of storeMessage method, of class quickchat1.
     */
    @Test
    public void testStoreMessage() {
        System.out.println("storeMessage");
        JSONObject NotifJSON = null;
        quickchat1.storeMessage(NotifJSON);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of totalMessagesreturned method, of class quickchat1.
     */
    @Test
    public void testTotalMessagesreturned() {
        System.out.println("totalMessagesreturned");
        int expResult = 0;
        int result = quickchat1.totalMessagesreturned();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cellphoneVerification method, of class quickchat1.
     */
    @Test
    public void testCellphoneVerification() {
        System.out.println("cellphoneVerification");
        String cellphone = "";
        boolean expResult = false;
        boolean result = quickchat1.cellphoneVerification(cellphone);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMessageLimit method, of class quickchat1.
     */
    @Test
    public void testGetMessageLimit() {
        System.out.println("getMessageLimit");
        int expResult = 0;
        int result = quickchat1.getMessageLimit();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveMessagesToJson method, of class quickchat1.
     */
    @Test
    public void testSaveMessagesToJson() {
        System.out.println("saveMessagesToJson");
        quickchat1.saveMessagesToJson();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
