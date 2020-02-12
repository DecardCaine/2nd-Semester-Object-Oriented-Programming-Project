import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
public class Administrator {
	private User anyuser;

	public Administrator(User anyuser) 
	{
		String bd;
	this.anyuser=anyuser;
	int a= 0;
	int b= 0;
	LocalDate localDate = LocalDate.now();
	if(anyuser.getDob().getYear()%4 == 0){
		 a = -1;
	}
	if(LocalDate.now().getYear()%4 == 0){
		 b = 1;
	}
	int difference=-LocalDate.now().getDayOfYear()+anyuser.getDob().getDayOfYear()+a+b;
	 if(difference<30 && difference >0){
		 bd="Your birth day is in "+difference+" days";
		 anyuser.getNotifbox().add(bd);
	 }
	 else if(difference==0){
		 bd="Happy Birth Days!!!";
		 anyuser.getNotifbox().add(bd);
 	 }
  }
}