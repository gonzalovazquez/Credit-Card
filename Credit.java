
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gonzalovazquez;
import javax.swing.JOptionPane;
/** 
 * This is a credit card class. A credit card has a balance and 
 * we can calculate the interest based on the rate entered.
 * @author GonzaloVazquez
 */
public class Credit {
    
    /**
     * Set the balance and interest rate doubles to zero
     */
       
    private double balance = 0;
    private double interest = 0;
    
 
    public Credit()
    {
        /**
         * Constuctor that asks user for balance and rate.
         */
       
        //Input Balance
        String myNewBalance = JOptionPane.showInputDialog(null,"Enter you credit card balance");
        double myBalance = Double.parseDouble(myNewBalance);
        setBalance(myBalance);
        
        //Input Interest Rate
        String myNewRate = JOptionPane.showInputDialog(null,"Enter your interest rate");
        double myInterest = Double.parseDouble(myNewRate);
        setInterest(myInterest);
        
        
    }
    /**
     * Sets the balance of the credit card.
     * The balance must be greater than zero 
     * @param myBalance, the balance given to the credit card
     * @throws IllegalArgumentException if balance is 0 or less.
     */
    
    public void setBalance(double myBalance)
    {
        
        if(myBalance <= 0)
        {
            IllegalArgumentException error = new IllegalArgumentException("Please enter a positive balance");
            throw error;
        }
        else
        {
            this.balance = myBalance;
        }
    }
    /**
     * Sets the interest rate of the credit card.
     * The interest rate must be greater than zero.
     * @param myInterest, the interest rate given to the credit card.
     * @throws IllegalArgumentException if rate is 0 or less.
     */
    
    public void setInterest(double myInterest)
    {
        if(myInterest <= 0)
        {
            IllegalArgumentException error = new IllegalArgumentException("Please enter a positive interest rate");
            throw error;
        }
        else
        {
            this.interest = myInterest;
        }
    }
    /**
     * Returns the balance of the credit card.
     * @return the balance of the card.
     */
    
    public double getBalance()
    {
        return balance;
    }
    /**
     * Returns the interest rate of the credit card.
     * @return the interest rate.
     */
    
    public double getInterest()
    {
        return interest;
    }
    
    /**
     * Calculates the balance based on interest rate.
     */
    
    public void calculateBalance(){
        System.out.println("Entered credit card balance: $" + balance);
        System.out.println("Entered interest rate: " + interest+ "%");
        
        //We loop the function 12 times
        for(int i=0; i < 12; i++)
        {      
        System.out.println("-----------"+(i + 1) + "---------");
        
        //Calculate the new balance based on the interest
        double preBalance =(balance *(interest / 100)) + balance;
        
        //Minimun Payment set to 10 by default
        double minimumPayment = 10;             
        
        //Calculate which is greater if $10 or 3% of new balance owed
        if((preBalance * 0.03) > 10)
        {
            minimumPayment = preBalance * 0.03;
        }else
        {
            minimumPayment = 10;
        }
        //Print out the minimum payment required based on the new balance
        //System.out.println("The minimum payment is $" + minimumPayment); 
        System.out.format("The minimum payment is $: %.2f%n", minimumPayment);
        
        //Calculate the final balance minus minumum payment;     
        double finalBalance = preBalance - minimumPayment;
        
        //Set the balance to the new finalBalance for compounding interest.
        balance = finalBalance;
        
        //Print out the final balance owed.
       // System.out.println("You final owing balance is $" + finalBalance);
        System.out.format("Your owing balance is $: %.2f%n", finalBalance);
        }
        
    }
}
