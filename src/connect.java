import java.sql.*;
public class connect {
    Connection c;
    Statement s;
   public connect(){
       try{
           //Class.forName(com.mysql.cj.jdbc.Driver);//no need to register driver now,java can do it itself
           c=DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","computer@1");//creating connection
           s=c.createStatement();//creating statement

       }catch(Exception e){

       }
   }
}
