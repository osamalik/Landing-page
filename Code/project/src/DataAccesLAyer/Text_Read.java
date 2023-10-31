package DataAccesLAyer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Text_Read {
	static String Title;
	static String Author;
	static String Paragraph;
	
	
	public static ArrayList<String> errorlist = new ArrayList<String>();
	
	
public void connection_FUN(String word) {
  
	
	try {
    	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/spell_checker","root","");
    	
    	if (!con.isClosed())
    	   {
    		PreparedStatement ps = con.prepareStatement("SELECT * FROM word WHERE words LIKE '" + word + "'");
          
            ResultSet rs = ps.executeQuery();
    	      
    	      if (rs.next()) {
    	    	 
    	    	  
                 
              } else {
            	 
            	  errorlist.add(word);
            	  
              }

    	      con.close();
    	   }
    	   else
    	      System.out.println("Connect fail");
    	}
    catch(SQLException e) {
    	System.out.println(e);
    }

}
 public ArrayList<String> ErrorList() {
	 
	 return errorlist;
 }

}

