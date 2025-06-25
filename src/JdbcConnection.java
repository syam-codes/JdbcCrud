import java.sql.*;
public class JdbcConnection {
    public static void main(String[] args) throws Exception {

        String query = "Select * from student";

        String delete="delete from student where id=102";

        String update="UPDATE student SET sname = 'sundarrr' WHERE id = 9";

        String insert="Insert into student values(999,'kohli',36)";


        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo", "postgres", "root");

        System.out.println("Connection Established");
        Statement statement = con.createStatement();
        ResultSet res= statement.executeQuery(query);

        while (res.next()){
            System.out.print(res.getInt(1)+" - ");
            System.out.print(res.getString(2)+" - ");
            System.out.println(res.getInt(3));

        }

        statement.execute(delete);
        System.out.println("After deleting the row");
        ResultSet res2= statement.executeQuery(query);
        while (res2.next()){
            System.out.print(res2.getInt(1)+" - ");
            System.out.print(res2.getString(2)+" - ");
            System.out.println(res2.getInt(3));

        }
        System.out.println("After Updating the row");
        statement.execute(update);
        ResultSet res3= statement.executeQuery(query);
        while (res3.next()){
            System.out.print(res3.getInt(1)+" - ");
            System.out.print(res3.getString(2)+" - ");
            System.out.println(res3.getInt(3));
        }

        statement.execute(insert);
        System.out.println("After inserting into table");
        ResultSet res4=statement.executeQuery(query);
        while (res4.next()){
            System.out.print(res4.getInt(1)+" - ");
            System.out.print(res4.getString(2)+" - ");
            System.out.println(res4.getInt(3));
        }

        con.close();
    }
}
