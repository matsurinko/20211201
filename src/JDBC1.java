import java.sql.*;

public class JDBC1 {
    public static void main(String[] args){
        Connection conn=null;
        String url ="jdbc:oracle:thin:@120.77.235.6:1521:orcl";
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        String sql="SELECT * FROM departments";
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn= DriverManager.getConnection(url,"mhp","mhP1234_");
            pstmt=conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next()) {
                int dept_id = rs.getInt("DEPARTMENT_ID");
                String dept_name = rs.getString("DEPARTMENT_NAME");
                System.out.println("部门ID：" + dept_id + "，部门名称：" + dept_name);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            try {
                rs.close();
                pstmt.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
