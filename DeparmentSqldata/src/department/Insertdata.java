package department;
import java.sql.*;
import java.util.*;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Any;
public class Insertdata {
	private Connection con;
	PreparedStatement st;
	Statement sr;
	CallableStatement stm;
	private Scanner sc;
	public Insertdata()
	{
		con = Connectiondatabase.getconnection();
		sc = new Scanner(System.in);
	}
	public void insertemployeedata() throws Exception
	{
		try {
			st=con.prepareStatement("insert into employee(Employee_Id, Employee_Name, Employee_Address, Employee_Salary, Employee_Contact_No, Department_Id) values(?,?,?,?,?,?)");
			System.out.println("enter how many you want");
			int  number= sc.nextInt();
			for(int i=1;i<=number;i++)
			{
				System.out.println("enter empid");
				st.setInt(1,sc.nextInt());
				System.out.println("enter employee name");
				st.setString(2,sc.next());
				System.out.println("enter address");
				st.setString(3,sc.next());
				System.out.println("enter salary");
				//st.setDouble(4,sc.nextDouble());
				if(sc.nextDouble()>1000)
				{
					st.setDouble(4,sc.nextDouble());
			
				}
				else
				{
					throw new Exception();
				}

				System.out.println("enter contact number ");
				st.setString(5,sc.next());
				System.out.println("enter dpt id ");
				st.setInt(6, sc.nextInt());
				int result = st.executeUpdate();
				if(result>0)
				{
					System.out.println("data updated");
				}
				else
				{
					System.out.println("data not inserted");
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*System.out.println("enter how many you want");
		int  number= sc.nextInt();
		for(int i=1;i<=number;i++)
		{
			System.out.println("enter empid");
			st.setInt(i,sc.nextInt());
			System.out.println("enter employee name");
			st.setString(i,sc.next());
			System.out.println("enter address");
			st.setString(i,sc.next());
			System.out.println("enter salary");
			st.setDouble(i,sc.nextDouble());
			System.out.println("enter contact number ");
			st.setString(i,sc.next());
			System.out.println("enter dpt id ");
			st.setInt(i, sc.nextInt());
			int result = st.executeUpdate();
			if(result>0)
			{
				System.out.println("data updated");
			}
			else
			{
				System.out.println("data not inserted");
			}
		}*/
		
	}
	public void deptdata() throws SQLException {
		st=con.prepareStatement("insert into department values(?,?,?,?)");
		System.out.println("enter hoe many you want");
		int x = sc.nextInt();
		for(int i =1;i<=x;i++)
		{
			System.out.println("enter dpt id");
			st.setInt(1, sc.nextInt());
			System.out.println("enter name");
			st.setString(2, sc.next());
			System.out.println("enter head");
			st.setString(3, sc.next());
			System.out.println("enter description");
			st.setString(4, sc.next());
			int result = st.executeUpdate();
			if(result>0)
			{
				System.out.println("data entered ");
			}
			else
			{
				System.out.println("the data was not update");
			}
		}
	}
	public void retivedetails() throws SQLException
	{
		sr=con.createStatement();
		ResultSet resut=sr.executeQuery("select*from employee");
		while(resut.next())
		{
			System.out.println("the employee naumberis:- "+resut.getInt(1));
			if(resut.getInt(1)==resut.getInt(1))
			{
				System.out.println("the number is  already present");
			}
			
			System.out.println("the employee nameis:-"+resut.getString(2));
			System.out.println("employee address is:-"+resut.getString(3));
			System.out.println("employee salary  is:- "+resut.getInt(4));
			System.out.println("employee contact number:-"+resut.getString(5));
			System.out.println("employee id is:-"+resut.getInt(6));
		}
		
	}
	public void Values()throws SQLException
	{
		System.out.println("enter employee id");
		int id = sc.nextInt();
		
		/*sr=con.prepareStatement("select e.Employee_Id,e.Employee_name,e.Employee_contact_no,e.Employee_Addess,d.Department_name,d.Department_Head "
				+ "from Employee e JOIN Department d on e.Department_Id=d.Department_Id and Employee_id="+id+"");*/
		/*sr=con.prepareStatement("SELECT e.Employee_Id, e.Employee_Name, e.Employee_Address, d.Department_Name, d.Department_Head FROM employee e \"\n"
				+"JOIN department d ON"
				+ " e.Department_Id = d.Department_ID WHERE e.Employee_Id="+id+"");*/
		/*sr=con.prepareCall("SELECT e.Employee_Id, e.Employee_Name, e.Employee_Address, d.Department_Name, d.Department_Head FROM employee e"
				+ "JOIN department d ON"
				+ "e.Department_Id = d.Department_ID WHERE e.Employee_Id="+id+"");*/
		ResultSet result = sr.executeQuery("SELECT e.Employee_Id, e.Employee_Name, e.Employee_Address, d.Department_Name, d.Department_Head FROM employee e"
				+ "JOIN department d ON"
				+ "e.Department_Id = d.Department_ID WHERE e.Employee_Id="+id+""); 
		//int result=sr.executeUpdate(null)
		
		while(result.next())
		{
				System.out.println("the employee nanmeis:- "+result.getInt(1));
				System.out.println("the employee nameis:-"+result.getString(2));
				System.out.println("employee address is:-"+result.getString(3));
				System.out.println("Department name   is:- "+result.getString(4));
				System.out.println("employee name is :-"+result.getString(5));
				//System.out.println("department name");
			}
			
}
	/*"SELECT e.Employee_Id, e.Employee_Name, e.Employee_Contact_Number, e.Employee_Address, d.Department_Name, d.Department_Head " +
                         "FROM employees e " +
                         "JOIN departments d ON e.Department_Id = d.Department_ID " +
                         "WHERE e.Employee_Id = ?"*/
	public void callmethod() throws SQLException
	{
		System.out.println("enter employee id ");
		int id  = sc.nextInt();
		stm=con.prepareCall("{call Calculatepf2(?,?)}");
		stm.setDouble(1, id);
		stm.registerOutParameter(2,Types.DOUBLE);
		stm.execute();
		System.out.println("the salary is"+stm.getDouble(2));
		//System.out.println("employee salary is");
		

		
	}

		
	
	public static void main(String[] args) throws Exception{
		Insertdata dt = new Insertdata();
		dt.insertemployeedata();
		/*try {
			dt.deptdata();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//dt.insertemployeedata();
		//dt.retivedetails();
		//dt.Values();
		dt.callmethod();
	}

}
