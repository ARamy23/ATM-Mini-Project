package com.RMSCourse.Projects.ATM;

import java.util.ArrayList;

public class Database {
    public static ArrayList<String> names = new ArrayList<String>(10);
    public static ArrayList<String> passwords = new ArrayList<String>(10);

    public static boolean accessAccount(String name ,String password)
    { return names.contains(name) && passwords.contains(password); }

    public static void makeAnAccount(String name , String password)
    {
        names.add(name);
        passwords.add(password);
    }

    public static boolean isAccountInTheSystem(String name)
    {
        return names.contains(name);
    }




}
