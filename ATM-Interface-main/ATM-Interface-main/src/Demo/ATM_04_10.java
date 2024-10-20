import java.util.*;
import java.text.*;
class Account_04_10
{
	Scanner input = new Scanner(System.in);
	DecimalFormat df = new DecimalFormat("###,##0.00' Rupee'");
	DecimalFormat df1 = new DecimalFormat("###,##0.00' Dollar'");
	
	private int CN;
	private int PN;
	private double CB=2000;
	private double SB=1000;
	void setCustomerNumber(int a )
	{
		CN = a;
	}
	void setPINNumber(int b)
	{
		PN = b;
	}
	int getCustomerNumber()
	{
		return CN;
	}
	int getPINNumber()
	{
		return PN;
	}
	void getCurrentBalance()
	{
		
		System.out.println("Your Current Account Balance : "+df.format(CB));
	}
	void getSavingBalance()
	{
		System.out.println("Your Saving Account Balance : "+df1.format(SB));
	}
	void getCurrentWithDrawInput()
	{
		System.out.println("Your Current Account Balance : "+df.format(CB));
		System.out.println("Please Enter the amount you want to withdraw");
		
		double amount=input.nextDouble();
		if((CB - amount) >= 0)
		{
			calcCurrentWithDraw(amount);
			System.out.println("Transaction Successfull");
			System.out.println("Your new Current Account Balance : " +df.format(CB));
		}
		else
		{
			System.out.println("Insufficent Balance");
			System.out.println("Please Enter the valid amount");
		}
	}
	double calcCurrentWithDraw(double amount)
	{
		CB = CB - amount;
		return CB;
	}
	void getCurrentDepositInput()
	{
		System.out.println("Your Current Account Balance : "+df.format(CB));
		System.out.println("Please Enter the amount you want to deposite");
		
		double amount=input.nextDouble();
		if((CB + amount) >= 0)
		{
			calcCurrentDeposite(amount);
			System.out.println("Transaction Successfull");
			System.out.println("Your new Current Account Balance : " +df.format(CB));
		}
		else
		{
			System.out.println("Invalid Amount");
			System.out.println("Please Enter the valid amount");
		}
	}
	double calcCurrentDeposite(double amount)
	{
		CB = CB + amount;
		return CB;
	}
	
	void getSavingWithDrawInput()
	{
		System.out.println("Your Saving Account Balance : "+df1.format(SB));
		System.out.println("Please Enter the amount you want to withdraw");
		
		double amount=input.nextDouble();
		if((SB - amount) >= 0)
		{
			calcSavingWithDraw(amount);
			System.out.println("Transaction Successfull");
			System.out.println("Your new Saving Account Balance : " +df1.format(SB));
		}
		else
		{
			System.out.println("Insufficent Balance");
			System.out.println("Please Enter the valid amount");
		}
	}
	double calcSavingWithDraw(double amount)
	{
		SB = SB - amount;
		return SB;
	}
	void getSavingDepositInput()
	{
		System.out.println("Your Saving Account Balance : "+df1.format(SB));
		System.out.println("Please Enter the amount you want to deposite");
		
		double amount=input.nextDouble();
		if((SB + amount) >= 0)
		{
			calcSavingDeposite(amount);
			System.out.println("Transaction Successfull");
			System.out.println("Your new Saving Account Balance : " +df1.format(SB));
		}
		else
		{
			System.out.println("Invalid Amount");
			System.out.println("Please Enter the valid amount");
		}
	}
	double calcSavingDeposite(double amount)
	{
		SB = SB + amount;
		return SB;
	}	
}
class OptionMenu_04_10 extends Account_04_10
{
	Scanner input = new Scanner(System.in);
	HashMap<Integer,Integer> data = new HashMap<Integer ,Integer>();
	void getLogin()
	{
		int foundation = 560;
		do
		{
			try
			{
				data.put(11111, 111); // Akshay
				data.put(11112, 222); // Kunal
				data.put(11113, 333); // Bhushan
				data.put(11114, 444); // Vaishnavi
				data.put(11115, 111); // Renuka
				
				
				System.out.println("Welcome To The Sandip ATM ");
				System.out.print("\nEnter Your Customer Number : ");
			    setCustomerNumber( input.nextInt() );
			    System.out.print("Enter Your PIN Number : ");
			    setPINNumber(input.nextInt());
			    
			    int P = getCustomerNumber();
			    int Q = getPINNumber();
			    
			    if( data.containsKey(P) && data.get(P) == Q )
			    {
			    	getAccountType();
			    }
			    else
			    {
			    	System.out.println("\nWrong Customer Number or PIN Number ");
			    	System.out.println("Please Try again with Valid Customer Number or PIN Number");   
			    }
			}
			catch(InputMismatchException e)
			{
				System.out.println("\nPlease Enter Only Numbers");
				System.out.println("Characters And Symbols are Not Allowed ");
				foundation = 565;
			}
		}while(foundation==560);
	}	
	void getAccountType()
	{
		System.out.println("\nSelect The Account Type You Want to Access");
		System.out.println("Type 1 : Currrent Account");
		System.out.println("Type 2 : Saving Account");
		System.out.println("Type 3 : Exit");
		System.out.print("Choice : ");

		int ch = input.nextInt();
		
		switch(ch)
		{
		case 1:
			getCurrent();
			break;
			
		case 2:
			getSaving();
			break;
			
		case 3:
			System.out.println("Thank You For Visiting ,VISIT AGAIN !");
			break;
			
		default:
			System.out.println("Invalid Choice");
			System.out.println("Please Enter the valid choice.");
			break;
		}
	}
	void getCurrent()
	{
		System.out.println("\nCURRENT ACCOUNT");
		System.out.println("\nType 1 : View Balance");
		System.out.println("Type 2 : Withdraw Money");
		System.out.println("Type 3 : Deposit Money");
		System.out.println("Type 4 : Exit");
		System.out.print("Choice : ");
		
		int ch = input.nextInt();
		
		switch(ch) 
		{
		case 1:
			getCurrentBalance();
			getAccountType();
			break;
		case 2:
			getCurrentWithDrawInput();
			getAccountType();
			break;
		case 3:
			getCurrentDepositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("Thank You For Visiting ,VISIT AGAIN !");
			break;
			
		default:
			System.out.println("Invalid Choice");
			System.out.println("Please Enter the valid choice.");
			getCurrent();
			break;
		}
	}
	void getSaving()
	{
		System.out.println("\nSAVING ACCOUNT");
		System.out.println("\nType 1 : View Balance");
		System.out.println("Type 2 : Withdraw Money");
		System.out.println("Type 3 : Deposit Money");
		System.out.println("Type 4 : Exit");
		System.out.print("Choice : ");
		
		int ch = input.nextInt();
		
		switch(ch) 
		{
		case 1:
			getSavingBalance();
			getAccountType();
			break;
		case 2:
			getSavingWithDrawInput();
			getAccountType();
			break;
		case 3:
			getSavingDepositInput();
			getAccountType();
			break;
		case 4:
			System.out.println("Thank You For Visiting ,VISIT AGAIN !");
			break;
			
		default:
			System.out.println("Invalid Choice");
			System.out.println("Please Enter the valid choice.");
			getSaving();
			break;
		}

	}
}

public class ATM_04_10 
{
	public static void main(String[] args) 
	{
		OptionMenu_04_10 op = new OptionMenu_04_10();
		op.getLogin();	
	}
}
