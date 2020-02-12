import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.Month;
public class UserPanel{

public static void main(String[] args){
int operator=1;
int acc=100;
LocalDate localDate1 = LocalDate.of(1999, Month.OCTOBER, 13);
LocalDate localDate2 = LocalDate.of(1992, Month.JUNE, 16);
LocalDate localDate3 = LocalDate.of(1958, Month.JUNE, 28);
LocalDate localDate4 = LocalDate.of(1962, Month.APRIL, 29);
LocalDate localDate5 = LocalDate.of(2000, Month.FEBRUARY, 17);
LocalDate localDate6 = LocalDate.of(1990, Month.MAY, 31);
User userEntered;
Scanner scan = new Scanner(System.in);
ArrayList<User> users=new ArrayList<User>();
 User u1 = new User("Ege","egeyurusen@gmail.com",localDate1,"Gaziemir");
 User u2 = new User("Cem","lovelybrother@gmail.com",localDate2,"Gaziemir");
 User u3 = new User("Semih","semihyurusen@gmail.com",localDate3,"Gaziemir");
 User u4 = new User("Ayhan","ayhanyurusen@hotmail.com",localDate4,"Gaziemir");
 User u5 = new User ("Merve","merveyurduseven@hotmail.com",localDate5,"Gaziemir");
 User u6 = new User ("Nurseda","nursedayurusen@gmail.com",localDate6,"Gaziemir");
 users.clear();
 users.add(u1);
 users.add(u2);
 users.add(u3);
 users.add(u4);
 users.add(u5);
 users.add(u6);

 u1.setdefaultfollow(u6);
 u6.setdefaultfollow(u1);
 System.out.println("INFO*** User1(Ege) and User6(Nurseda) are already following each other ");
 System.out.println("You can choose which account you want to enter by entering number that writes next to username");
 System.out.println("You can choose which operation do you want by entering number that writes next to operations.");
 for(int i=0;i<users.size();i++){
	System.out.println(i+1+". "+users.get(i).getName());
 }
 for(int i=0;i<users.size();i++){
	 Administrator adminis =new Administrator(users.get(i));//birthday
 }
 while(acc!=-2){
acc=scan.nextInt();
if(acc<=users.size() && acc>0){
 userEntered= users.get(acc-1);
 System.out.println("Joined as "+users.get(acc-1).getName());
userEntered.setUserlist(users);
userEntered.setNonfollowed(users);
 System.out.println("To go back to user select segment please enter -1");
 operator=99;
 while(operator!=-1){
	 users.clear();
	 users.add(u1);
	 users.add(u2);
	 users.add(u3);
	 users.add(u4);
	 users.add(u5);
	 users.add(u6);
	 System.out.println("1.Show Inbox\n2.Show Outbox\n3.SendMessage\n4.SharePost\n5.Show timeline\n6.Show contact list\n7.Show Notifications\n8.Follow People");
	 if(operator!=1||operator!=2||operator!=5||operator!=6){
	 }
	 operator=scan.nextInt();
	  if (operator ==-1){
	  System.out.println("Going back to user segment ... Here is the userlist:");
	  for(int i =0;i<userEntered.getUserlist().size();i++){
		  System.out.println(userEntered.getUserlist().get(i).getName());
	  }
	 }
	if(operator== 1)
	{
		if(userEntered.getAInbox().isEmpty()){
 			System.out.println("Your inbox is empty! ");
 		}
	else{
		System.out.println("Showing inbox . . . ");
		System.out.println(userEntered.getAInbox());
		}
	}
 	else if(operator== 2)
 	{
 		if(userEntered.getAOutbox().isEmpty()){
 			System.out.println("Your outbox is empty! ");
 		}
 	else
 	{
 		System.out.println("Showing outbox . . . ");
 		System.out.println(userEntered.getAOutbox());
 		
 		}
 	}
	else if(operator ==3){
		if(userEntered.getFollowed().isEmpty()){
			System.out.println("You dont follow any user!");
		}
			else{
		System.out.println("Choose user for  sendmessage from written below: ");
		for(int i=0;i<userEntered.getFollowed().size();i++)
		{
			System.out.println(i+1+". "+userEntered.getFollowed().get(i).getName());
		}
		int op3 =scan.nextInt();
		Message m1 = new Message(userEntered,userEntered.getFollowed().get(op3-1));
		}//end of send message;
	}
    else if(operator== 4){
    	if(userEntered.getFavpost().isEmpty()){
    		System.out.println("You havent share any post yet");
    	
    	}
    	else
    	{
    	System.out.println("Here is the old posts that you shared in past:");
    	 }
    	for(int i=0;i<userEntered.getFavpost().size();i++){
    		System.out.println(userEntered.getFavpost().get(i));
    	 }
    	Post post = new Post(userEntered);
       }
    else if(operator== 5){
    	if(userEntered.getTimeline().isEmpty())
    	{
    		System.out.println("Your timeline is empty! ");
    	}
    	else{
    	System.out.println("Showing timeline :");
		System.out.println(userEntered.getTimeline());
    	}
    }
	else if(operator== 6){
		if(userEntered.getFollowed().isEmpty()){
			System.out.println("Your contact list is empty!");
		}
     else{
		   System.out.println("Showing contactlist :");
	   for(int i=0;i<userEntered.getFollowed().size();i++)
	       {
		System.out.println(i+1+". "+userEntered.getFollowed().get(i).getInfo());
	    }
     }
		}
	else if(operator== 7){
		if(userEntered.getNotifbox().isEmpty()){
			System.out.println("Your notification box is empty!");
		}
		else{
				for(int i=0;i<userEntered.getNotifbox().size();i++){
					System.out.println(userEntered.getNotifbox().get(i));
	 			}
		 }
	}
	 else if(operator== 8){
	if(userEntered.getFollowed().size()==userEntered.getUserlist().size()-1){
			 System.out.println("You are already follow everyone in userlist");
	}
	else{
		 userEntered.getNonfollowed().remove(users.get(acc-1));
		 for(int i = 0;i<userEntered.getFollowed().size();i++){
			 userEntered.getNonfollowed().remove(userEntered.getFollowed().get(i));
			 //
			 }
	 System.out.println("Please choose user you  want to follow from the userlist below :");
	 for(int i=0;i<userEntered.getNonfollowed().size();i++)
		{
			System.out.println(i+1+". "+userEntered.getNonfollowed().get(i).getName());
		}
		 int setFol = scan.nextInt();
		 userEntered.setFollow(setFol-1);
	}
	 }
	 else if(operator==-1);
	 else{
		 System.out.println("You entered wrong input!");
	 }
 if(operator !=-1){
	 System.out.println("Welcome back to the operation segment "+userEntered.getName()+" you can enter  -1 if you want to quit from this account");
   }
   } // inner while loop
 System.out.println("if you want to finish this process enter '-2' or you can swap to other users from the list above");
}//else
 else{
	 System.out.println("Wrong input please enter user that is available!");
 }//else
 } //outer while loop
}//main method
}//class