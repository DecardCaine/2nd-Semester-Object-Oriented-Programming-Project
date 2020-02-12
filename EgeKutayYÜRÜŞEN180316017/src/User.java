
import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.util.Scanner;
public class User {
private String uname;
private String email;
private String por;
private LocalDate dob;
private ArrayList<User> nonfollowed;
private ArrayList<User> followed;
private ArrayList<String> inbox;
private ArrayList<String> outbox;
private ArrayList<String> favpost;
private ArrayList<String> notifbox;
private ArrayList<User> userlist;
private ArrayList<String> timeline;
public User(String name,String email,LocalDate dob,String por){
     uname=name;
	this.email=email;
	this.por=por;
	this.dob=dob;
	nonfollowed=new ArrayList<User>();
	userlist=new ArrayList<User>();
	followed=new ArrayList<User>();
	inbox=new ArrayList<String>();
	outbox=new ArrayList<String>();
	timeline=new ArrayList<String>();
	favpost=new ArrayList<String>();
	notifbox = new ArrayList<String>();
}
public ArrayList<String> getNotifbox(){
	return notifbox;
}
public ArrayList<User> getUserlist() {
	return userlist;
}
public void setFollow(int name){

	if(name>nonfollowed.size()){
		System.out.println("You entered wrong input please enter input that is available");
	}
	else{
		followed.add(nonfollowed.get(name));//following process happens here
		String notif = "You are following "+nonfollowed.get(name).getName();
		String fotif ="You are followed by "+uname;
		System.out.println(notif);
		notifbox.add(notif);
		nonfollowed.get(name).notifbox.add(fotif);
  }//setfollow
}
public void getFollow(String name){
	String gnotif = "You are being followed by "+name;
	notifbox.add(gnotif);
}//adding followers to notif box

public ArrayList<User> getFollowed() {
	return followed;
}//returns followed people list for sendmessage;

public void sendMessage(User name, String message){
	String sout = message + "\n Message is sent to "+name.getName();
	outbox.add(sout);
}
public void recieveMessage(User name,String mess){
	String sinb = mess +"\n Message is sent by "+name.getName();
	inbox.add(sinb);
}
public String getSOutbox(){
	String sOutbox ="";
		sOutbox=outbox.get(outbox.size()-1)+"\n";
	return sOutbox;
}

public String getAInbox(){
	String aInbox ="";
	for(int i=0; i<inbox.size();i++){
		aInbox+=inbox.get(i)+"\n";
	}
	return aInbox;
}

public String getAOutbox(){
	String aOutbox ="";
	for(int i=0; i<outbox.size();i++){
		aOutbox+=outbox.get(i)+"\n";
	}
	
	return aOutbox;
}
public ArrayList<String> getTimeline() {
	return timeline;
}
public void setTimeline(String timeline) {
	this.timeline.add(timeline);
}
public String getName(){
	return uname;
}
public String getInfo(){
	String info ="Name: "+uname+"           Email adress: "+email+"         Place of Residence: "+por+"           Date of Birth: "+dob+"\n";
	return info;
}
public void setUserlist(ArrayList<User> userlist) {
	this.userlist = userlist;
}
public LocalDate getDob() {
	return dob;
}
public void setNotifbox(ArrayList<String> notifbox) {
	this.notifbox = notifbox;
}
public void setFavpost(String favpost){
	this.favpost.add(favpost);
}
public ArrayList<String> getFavpost(){
	return favpost;
}
public ArrayList<User> getNonfollowed() {
	return nonfollowed;
}
public void setNonfollowed(ArrayList<User> nonfollowed) {
	this.nonfollowed = nonfollowed;
}
public void setFollowed(ArrayList<User> followed) {
	this.followed = followed;
}
public void setdefaultfollow(User defaultUser){
	User defuser=defaultUser;
	followed.add(defuser);
}
public void addOutbox(String outbox){
this.outbox.add(outbox);
}
}
