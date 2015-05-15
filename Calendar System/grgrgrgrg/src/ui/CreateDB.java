package ui;

import java.sql.*;

class CreateDB
{
    public static void main( String args[] )
    {
        CreateDB db = new CreateDB();
        db.createDB();       // Create & setup connection
        db.createTable();    // Create table in database
        db.populate();       // Populate table in database
        db.close();          
    }

    private Connection con = null;   // Connection to database
    private Statement  stm = null;   // Used to talk to database

    private static final String urlDB =
        "jdbc:derby:derby.db;create=true";
    private static final String DRIVER =
        "org.apache.derby.jdbc.EmbeddedDriver";

    //Create Database and connect
    public void createDB()
    {
        try
        {
            Class.forName(DRIVER).newInstance();    //  Driver to access database
            con  = DriverManager.getConnection( urlDB, "", "" );
    
        }
        catch ( SQLException e )
        {
            System.err.println( "Problem with connection to " + urlDB );
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState:     " + e.getSQLState());
            System.out.println("VendorError:  " + e.getErrorCode());
            System.exit( -1 );
        }
        catch ( Exception e )
        {
            System.err.println("Can not load JDBC/ODBC driver.");
            System.exit( -1 );
        }

        try {
            stm = con.createStatement();
        } catch (Exception e) {
            System.err.println("problems creating statement object" );
        }
    }

    //Create table for users
    public void createTable()
    {
        try
        {
              stm.execute( "drop table Users" );  
        } catch (Exception e)
        {
            // Table did not exist - just ignore
        }

        String sql = "create table Users (      " +
            "  User_ID     VarChar(20) ,   " +
            "  Password     VarChar(20))";
        try
        {
            stm.execute( sql );

        } catch (Exception e)
        {
            System.out.printf("problems with SQL statement:\n %s\n %s\n",
                sql, e.getMessage() );
            System.exit(-1);  // Give up
        } 

    }

    public void populate()
    {
        try
        {
            // Populate with some values

            stm.execute( "insert into Users values " +
                "('MalC', '123456')" );
            stm.execute( "insert into Users values " +
                "('DavC', '654321')" );

        } catch (Exception e)
        {
            System.err.println("problems with SQL statement:\n" +
                e.getMessage() );
        }
    }

    /**
     * Close the Database
     */
    public void close()
    {
        try
        {
            stm.close();          // Close the statement Object
            con.close();           // Close the connection to the Database
        } catch (SQLException e )
        {
            System.err.println( e.getMessage() );
        }
    }
}
