/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
public class DAO {    
    private Connection conn;
    
    public DAO()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/baohiemyte"
            + "?useUnicode=true&characterEncoding=utf-8","root","0793145");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void close()
    {
        if (conn != null)
        {
            try
            {
                conn.close();
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public Account getAccount(String username, String password)
    {
        try {
            String sql="SELECT * FROM baohiemyte.ACCOUNT "
                      +"WHERE USERNAME=? AND PASSWORD=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(rs.next())
            {
                Account a = new Account();
                a.setId(rs.getInt("ID"));
                a.setUsername(rs.getString("USERNAME"));
                a.setRole(rs.getInt("ROLE"));
                return a;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList<Customer> getAllCustomer()
    {
        ArrayList<Customer> list = new ArrayList<>();
        String sql = "SELECT * FROM baohiemyte.CUSTOMERS";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Customer c = new Customer();
                c.setId(rs.getInt("ID"));
                c.setAddr(rs.getString("ADDR"));
                c.setBirthday(rs.getString("BIRTHDAY"));
                c.setBusinesses_id(rs.getInt("BUSSINESSES_ID"));
                c.setCard_id(rs.getString("Card_id"));
                c.setCode_BHXH(rs.getString("Code_BHXH"));
                c.setCreated_at(rs.getString("Created_at"));
                c.setDate_given(rs.getString("Date_given"));
                c.setFamilies_id(rs.getInt("Families_id"));
                c.setGender(rs.getInt("gender"));
                c.setGroup_id(rs.getInt("groups_id"));
                c.setGroup_objects_id(rs.getInt("group_objects_id"));
                c.setJobs(rs.getString("jobs"));
                c.setName(rs.getString("name"));
                c.setOriginal_addr(rs.getString("original_addr"));
                c.setPhone(rs.getInt("phone"));
                c.setPlace_given(rs.getString("place_given"));
                c.setUpdated_at(rs.getString("updated_at"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Transaction> getAllTransaction()
    {
        ArrayList<Transaction> list = new ArrayList<>();
        String sql = "SELECT * FROM baohiemyte.TRANSACTIONS";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Transaction t = new Transaction();
                t.setId(rs.getInt("ID"));
                t.setCustomer_id(rs.getString("Customer_id"));
                t.setPaid(rs.getLong("paid"));
                t.setSupport(rs.getLong("support"));
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Customer> getCustomerByString(String key, String value)
    {
        ArrayList<Customer> list = new ArrayList<>();
        String sql = "SELECT * FROM baohiemyte.customers "
                    +"WHERE " + key + " LIKE '%"+value+"%'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Customer c = new Customer();
                c.setId(rs.getInt("ID"));
                c.setAddr(rs.getString("ADDR"));
                c.setBirthday(rs.getString("BIRTHDAY"));
                c.setBusinesses_id(rs.getInt("BUSSINESSES_ID"));
                c.setCard_id(rs.getString("Card_id"));
                c.setCode_BHXH(rs.getString("Code_BHXH"));
                c.setCreated_at(rs.getString("Created_at"));
                c.setDate_given(rs.getString("Date_given"));
                c.setFamilies_id(rs.getInt("Families_id"));
                c.setGender(rs.getInt("gender"));
                c.setGroup_id(rs.getInt("groups_id"));
                c.setGroup_objects_id(rs.getInt("group_objects_id"));
                c.setJobs(rs.getString("jobs"));
                c.setName(rs.getString("name"));
                c.setOriginal_addr(rs.getString("original_addr"));
                c.setPhone(rs.getInt("phone"));
                c.setPlace_given(rs.getString("place_given"));
                c.setUpdated_at(rs.getString("updated_at"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Transaction> getTransactionByString(String key, String value)
    {
        ArrayList<Transaction> list = new ArrayList<>();
        String sql = "SELECT * FROM baohiemyte.transactions "
                    +"WHERE " + key + " LIKE '%"+value+"%'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Transaction t = new Transaction();
                t.setId(rs.getInt("ID"));
                t.setCustomer_id(rs.getString("Customer_id"));
                t.setPaid(rs.getLong("paid"));
                t.setSupport(rs.getLong("support"));
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public ArrayList<Config_BaseSalary> getAllConfig_BaseSalary()
    {
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ArrayList<Config_BaseSalary> list = new ArrayList<>();
        String sql = "SELECT * FROM baohiemyte.config_base_salaries";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Config_BaseSalary c = new Config_BaseSalary();                
                c.setBase_salary(rs.getLong("base_salary"));
                c.setId(rs.getInt("id"));
                c.setUpdated_at(rs.getString(sql));
                c.setStart_date(rs.getString("start_date"));
                list.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Config_BaseSalary getLastConfig_BaseSalary()
    {
        String sql = "SELECT * FROM baohiemyte.config_base_salaries ORDER BY ID DESC LIMIT 1";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Config_BaseSalary c = new Config_BaseSalary();                
                c.setBase_salary(rs.getLong("base_salary"));
                c.setId(rs.getInt("id"));
                c.setUpdated_at(rs.getString("updated_at"));
                c.setStart_date(rs.getString("start_date"));
                return c;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Config_rate_families getLastConfig_rate_families()
    {
        String sql = "SELECT * FROM baohiemyte.config_rate_families ORDER BY ID DESC LIMIT 1";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Config_rate_families c = new Config_rate_families();                
                c.setId(rs.getInt("id"));
                c.setMember1(rs.getDouble("member1"));
                c.setMember2(rs.getDouble("member2"));
                c.setMember3(rs.getDouble("member3"));
                c.setMember4(rs.getDouble("member4"));
                c.setMember5(rs.getDouble("member5"));
                c.setStart_date(rs.getString("start_date"));
                c.setUpdated_at(rs.getString("updated_at"));
                return c;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Config_rate_objects getLastConfig_rate_objects()
    {
        String sql = "SELECT * FROM baohiemyte.config_rate_families ORDER BY ID DESC LIMIT 1";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                Config_rate_objects c = new Config_rate_objects();                
                c.setId(rs.getInt("id"));
                c.setBase(rs.getLong("base"));
                c.setGroups_objects_id(rs.getInt("groups_objects_id"));
                c.setRate(rs.getDouble("rate"));
                c.setStart_date(rs.getString("start_date"));
                c.setUpdated_at(rs.getString("updated_at"));
                return c;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }    

    public void addConfig_BaseSalary(Config_BaseSalary c)
    {
        String sql="INSERT INTO baohiemyte.config_base_salaries(start_date, base_salary, updated_at) "
                 + "VALUES(?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, c.getStart_date());
            ps.setLong(2, c.getBase_salary());
            ps.setString(3, c.getUpdated_at());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void addConfig_rate_families(Config_rate_families c)
    {
        String sql="INSERT INTO baohiemyte.config_rate_families(member1, member2, member3, member4, member5, start_date, updated_at) "
                 + "VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, c.getMember1());
            ps.setDouble(2, c.getMember2());
            ps.setDouble(3, c.getMember3());
            ps.setDouble(4, c.getMember4());
            ps.setDouble(5, c.getMember5());
            ps.setString(6, c.getStart_date());
            ps.setString(7, c.getUpdated_at());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
