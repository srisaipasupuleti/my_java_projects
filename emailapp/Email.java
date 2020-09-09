package emailapp;

import java.util.Scanner;

public class Email {
	private String firstname;
	private String lastname;
	private String password;
	private int defaultpasswordlength=8;
	private String department;
	private int mailboxcapacity=100;
	private String altemail;
	private String email;
	private String companysuffix="anycomp.com";
	
	//constructor to recieve first and last name
	public Email(String firstname,String lastname) {
		this.firstname=firstname;
		this.lastname=lastname;
		//ask for department
		this.department=setdepartment();
	
		//generate a random password
		this.password=setrandpassword(defaultpasswordlength);
		System.out.print("Your password :"+this.password+"\n");
		email=firstname.toLowerCase()+lastname.toLowerCase()+"@"+department+"."+companysuffix;
		
		
	}
	//ask for the department
	private String setdepartment() {
		
		System.out.print("New worker"+this.firstname+" Department codes:\n1 sales\n2 development\n3 accounting\n4 none\nEnter dep code:");
		Scanner in=new Scanner(System.in);
		int dept_choice=in.nextInt();
		in.close();
		if(dept_choice==1)return"sales";
		else if(dept_choice==2)return "development";
		else if(dept_choice==3)return"accounting";
		else return "";
	}
	//generate a random password
	private String setrandpassword(int dafaultpasswordlength) {
		String charset="ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%&";
		int length=dafaultpasswordlength;
		char[] password=new char[length];
		for(int i=0;i<length;i++) {
			int index=(int)(Math.random()*charset.length());
			password[i]=charset.charAt(index);
		}
		return new String(password);
	}
	
	//set mailbox capacity
	public void setMailboxCapacity(int capacity) {
		this.mailboxcapacity=capacity;
	}
	
	//set alternate mail
	public void setAlternateMail(String altmail) {
		this.altemail=altmail;
	}
	
	//change the password
	public void setPassword(String newpassword) {
		this.password=newpassword;
	}
	//implementing get methods
	public int getMailboxCapacity() {return this.mailboxcapacity;}
	public String getAlternatemail() {return this.altemail;	}
	//retrive info method
	public String showInfo() {
		return "Display name:"+this.firstname+" "+this.lastname+"\nCompany Email:"+this.email+"\nMailboxCapacity:"+this.mailboxcapacity+"MB";
	}
}
