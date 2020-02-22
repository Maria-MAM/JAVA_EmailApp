import java.util.*;

public class Email {
    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private String companySuffix = "company.com";
    private int mailboxCapacity = 500;
    private int defaultPasswordLength = 10;
    private String alternateEmail;

    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        
        this.department = setDepartment();
        
        this.password = randomPassword(defaultPasswordLength);
        System.out.println("Password is " + this.password);
        
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department + "." + companySuffix;
    }
    
    private String setDepartment() {
        System.out.print("Dep codes:\n 1 for Sales\n 2 for Dev\n 3 for Accounting\nEnter the dep: ");
        Scanner in = new Scanner(System.in);
        int depChoice = in.nextInt();
        if (depChoice == 1) {return "sales";}
            else if (depChoice == 2) {return "dev";}
            else if (depChoice == 3) {return "accounting";}
            else {return "";}
    }
    
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVXYZ123456789@#$%";
        char[] password = new char[length];
        for (int i = 0; i<length; i++) {
            int rand = (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);
        }
        return new String(password);
    }
    
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }
    
    public void setAltEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }
    
    public void changePassword(String password) {
        this.password = password;
    }
    
    public int getMailboxCapacity() {
        return mailboxCapacity;
    }
    
    public String getAltEmail() {
        return alternateEmail;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String showInfo() {
        return "Display name is: " + firstName + " " + lastName + "\nCompany email " + email + "\nMailbox capacity: " + mailboxCapacity + "mb";
    }
    
}