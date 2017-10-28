package com.RMSCourse.Projects.ATM;

import java.util.Scanner;

public class Main
{
    public static Scanner in = new Scanner(System.in);
    public static void main(String[] args)
    {
        System.out.println("Welcome To blabla Bank.");
        System.out.println("1-Insert Credit Card\n2-Enter Account Credentials\n3-Make a New Account");
        int prompt = in.nextInt();
        if(prompt == 1 )
        {
            boolean passwordInvalid = true;
            do
            {

                System.out.print("Enter Credit Card password: ");
                String cardPassword = in.next();
                if (cardPassword.equals("123"))
                {
                    System.out.println("[Access Granted]");
                    systemInterface();
                    passwordInvalid = false;

                } else if (cardPassword.equals("321"))
                {
                    System.out.println("Please hold on for 5 mins since the system is facing a temporarily downtime , thank you for your patience ***police is being called***");
                    passwordInvalid = false;
                } else
                {
                    System.out.println("[Access Denied]: Invalid Password !");

                }
            }while (passwordInvalid);
        }
        else if(prompt == 2)
        {
            System.out.print("Enter Account's Name: ");
            String name = in.nextLine();
            System.out.print("Enter Account's Password: ");
            String password = in.next();
            if(Database.accessAccount(name, password))
            {
                systemInterface();
            }
        }
        else if(prompt == 3)
        {
            System.out.print("Enter Account's Name: ");
            in.nextLine();
            String name = in.nextLine();
            System.out.print("Enter Account's Password: ");
            String password = in.next();
            Database.makeAnAccount(name , password);
            systemInterface();
        }

    }

    public static void systemInterface()
    {
        systemLoop: while (true)
        {
            System.out.println("1-Withdraw\n2-Deposit\n3-Donate\n4-Transfer Money to Another Account\n5-Display Current Balance\n6-Exit");
            int prompt = in.nextInt();
            optionMenu: switch (prompt)
            {
                case 1:
                    System.out.print("Enter the amount you want to withdraw: ");
                    double moneyToBeWithdrawn = in.nextDouble();
                    System.out.println(Client.withdraw(moneyToBeWithdrawn));
                    break optionMenu;
                case 2:
                    System.out.print("Enter the amount you want to deposit: ");
                    double moneyToBeDeposited = in.nextDouble();
                    System.out.println(Client.deposit(moneyToBeDeposited));
                    break optionMenu;
                case 3:
                    System.out.println("Please Select One of the Following Charities to Donate to: ");
                    System.out.println("1-Masr El-Orman\n2-57357\n3-El-Resala");
                    prompt = in.nextInt();
                    switch (prompt)
                    {
                        case 1:
                            System.out.print("Enter the Amount of Money You want to transfer to Masr El-Orman: ");
                            System.out.println(Client.donate(prompt,in.nextDouble()));
                            break optionMenu;
                        case 2:
                            System.out.println("Enter the amount of money you want to transfer to 57357: ");
                            System.out.println(Client.donate(prompt, in.nextDouble()));
                            break optionMenu;
                        case 3:
                            System.out.println("Enter the amount of money you want to transfer to El-Resala: ");
                            System.out.println(Client.donate(prompt , in.nextDouble()));
                        default:
                            System.out.println("[Invalid Prompt]");
                            break optionMenu;
                    }
                case 4:
                    System.out.print("Enter the Account's Name: ");
                    in.nextLine();
                    String name = in.nextLine();

                    System.out.print("Enter the amount you want to transfer to: " + name);
                    double amount = in.nextDouble();
                    Client.transferToAnotherAccount(name,amount);
                    break optionMenu;
                case 5:
                    Client.displayBalance();
                    break optionMenu;
                case 6:
                    break systemLoop;

            }
        }

    }
    }

