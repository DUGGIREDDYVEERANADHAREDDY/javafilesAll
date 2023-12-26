package department;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.*;
public class Imageinset {
	private Connection con;
	PreparedStatement st;
	public Imageinset()
	{
		con=Connectiondatabase.getconnection();
	}
	public void insertimage() throws SQLException, IOException
	{
		st=con.prepareStatement("insert into emp values(?,?)");
		st.setString(1,"firstname");
		FileInputStream sr = new FileInputStream("/home/administrator/Downloads/vrYFWx.jpg");
		st.setBinaryStream(2, sr, sr.available());
		int result= st.executeUpdate();
		if(result>0)

		{
			System.out.println("data is inserted");
		}

	}
	public void readimage() throws SQLException, IOException
	{
		st=con.prepareStatement("select image from emp where firstname=? ");
		st.setString(1, "firstImage");
		ResultSet result = st.executeQuery();
		if(result.next())
		{
			Blob imagedata =result.getBlob(1);
			byte arr[] =imagedata.getBytes(1, (int)imagedata.length());
			FileOutputStream out = new FileOutputStream("/home/administrator/Downloads/vrYFWx.jpg");
			out.write(arr);
			System.out.println("file is created");
		}
		else
		{
			System.out.println("file is  created ");
		}
	}
	public static void main(String[] args) throws SQLException, IOException {
		Imageinset set = new Imageinset();
		//set.insertimage();
		set.readimage();
		
	}

}
