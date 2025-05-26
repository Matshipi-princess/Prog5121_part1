/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.chatapp.registration3;

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
public class Registration3Test {
    
    public Registration3Test() {
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
     * Test of CheckUsername method, of class Registration3.
     */
    @Test
    public void testCheckUsername() {
        System.out.println("CheckUsername");
        Registration3 instance = new Registration3();
        instance.CheckUsername();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkpassword method, of class Registration3.
     */
    @Test
    public void testCheckpassword() {
        System.out.println("checkpassword");
        String password = "";
        Registration3 instance = new Registration3();
        boolean expResult = false;
        boolean result = instance.checkpassword(password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RegisterUser method, of class Registration3.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("RegisterUser");
        Registration3 instance = new Registration3();
        instance.RegisterUser();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Registration3.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Registration3.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
