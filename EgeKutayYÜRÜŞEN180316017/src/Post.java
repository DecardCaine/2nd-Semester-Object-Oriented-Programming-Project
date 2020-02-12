
import java.util.ArrayList;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Post {
	private User author;
	public Post(User author)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		
		System.out.println("Please enter your post : ");
		Scanner scan = new Scanner(System.in);
		String[] scanA = scan.nextLine().split(" ");
		String post ="";
		for(int i =0;i<scanA.length;i++){
			post += scanA[i]+" ";//including spaces between two strings;
		}
		this.author = author;
		String PostA = author.getName()+" shared :   "+post+"       "+dateFormat.format(date)+"\n";
		for(int i = 0; i<author.getUserlist().size();i++){
			author.getUserlist().get(i).setTimeline(PostA);;//adding up posts to time line for 'all users'
		}
		author.setFavpost(PostA);
		System.out.println("you shared this post!");
	}
}
