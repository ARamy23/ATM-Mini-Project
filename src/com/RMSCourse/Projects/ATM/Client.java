package com.RMSCourse.Projects.ATM;

public class Client {
    //Client is linked to the database class so when the program starts
    // it reads his name then greets him
    // then after inserting the card it reads its code , and then ask for his password
    // if password matches one of the passwords on the database it grants access to the features on Client class
    // password doesn't match , it calls the police :D
    public static double balance = 0;

    public static String withdraw(double amount)
    {
        if(balance == 0)
            return "[Transaction Failed]\n[Balance]: " + balance;
        balance = (amount < balance) ? balance - amount : 0;
        return "[Transaction Successful]\n[Balance]: " + balance ;
    }

    public static String deposit(double amount)
    {
        balance += amount;
        return "[Transaction Successful]\n[Balance]: " + balance;
    }

    public static String donate(int charityNumber , double amount)
    {
        if(balance == 0)
            return "[Transaction Failed]\n[Balance]: " + balance + "\n[There is no Money in the Account]";
        balance = (amount < balance ) ? balance - amount : 0;
        return "[Transaction Successful]\n[Balance]: " + balance;
    }

    public static String transferToAnotherAccount(String name , double amount)
    {
        if(Database.isAccountInTheSystem(name))
        {
            System.out.println("[Account Found]");
            if(balance == 0)
                return "[Transaction Failed]\n[Balance]: " + balance + "\n[There is no Money in the Account]";
            balance = (amount < balance ) ? balance - amount : 0;
            return "[Transaction Successful]\n[Balance]: " + balance;
        }
        else
        {
            return "[No Such Account]";
        }
    }
    public static void displayBalance()
    {
        System.out.println("[Balance]: " + balance);
    }


}
