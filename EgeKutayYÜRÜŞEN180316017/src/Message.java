import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Message {
	private long info;
	private String sendmessage;
	private User sender;
	private User receiver;

public Message(User sender, User receiver){
	
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();//time info;
	this.sender = sender;
	this.receiver = receiver;
	boolean checkA = false;
	boolean checkB = false;
    if(sender.getFollowed().size() == 0 || receiver.getFollowed().size() == 0){
		System.out.println("You cannot send message to "+receiver.getName()+" because you are not following each other!");
	checkA = false;}
	for(int i = 0 ; i<receiver.getFollowed().size();i++){
		
		if(receiver.getFollowed().get(i).getName()== sender.getName()){
			checkB = true;
			checkA = true;}
	}//this is for check if users follow each other
	if(checkB==false){
	}
	if(checkA==true){
	System.out.println("Please enter your message");
	Scanner scan = new Scanner(System.in);
	String[] scanA = scan.nextLine().split(" ");
	String messag ="";
	for(int i =0;i<scanA.length;i++){
		messag += scanA[i]+" ";//boþluklarý dahil etmeye yarayan fonksiyon);
	}
	sendmessage = messag+"\n"+dateFormat.format(date); 
	
	sender.sendMessage(receiver, sendmessage);
	receiver.recieveMessage(sender, sendmessage);
	System.out.println(sender.getName()+": \n"+sender.getSOutbox());
	}
}

public String getMessage(){
	return sendmessage;
}
}
