package com.example.spring_connect_to_oracle_demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import oracle.jdbc.pool.OracleDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@SpringBootApplication
public class SpringConnectToOracleDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringConnectToOracleDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL("jdbc:oracle:thin:@localhost:1521/FREEPDB1"); // jdbc:oracle:thin@[hostname]:[port]/[DB service name]
		ods.setUser("SYSTEM");
		ods.setPassword("Nola110916!!");
		Connection conn = ods.getConnection();

		// PreparedStatement stmt = conn.prepareStatement("INSERT INTO Issues(TITLE,
		// DESCRIPT) values (?,?)");
		// stmt.setString(1, "Issue #2");
		// stmt.setString(2 , "This is issue #2" );
		// stmt.execute();

		// PreparedStatement stmt3 = conn.prepareStatement("INSERT INTO Persons(PersonID, FirstName, LastName) values (?,?,?)");
		// stmt3.setString(1, "88885");
		// stmt3.setString(2, "Debra");
		// stmt3.setString(3, "McFly");
		// stmt3.execute();

		// System.out.println("Inserted one row");

		PreparedStatement stmt4 = conn.prepareStatement("CREATE TABLE Animals(AnimalName varchar(255), AnimalColor varchar(255))");
		stmt4.execute();

	
		System.out.println("Created table Animals");
		// PreparedStatement select = conn.prepareStatement("SELECT * FROM PERSONS");
		// ResultSet rslt = select.executeQuery();
		// while (rslt.next()) {
		// System.out.println("--------------");
		// System.out.println("First Name:" + rslt.getString("FIRSTNAME"));

		// }

		// PreparedStatement stmt = conn.prepareStatement("SELECT 'Hello World!' FROM
		// dual");
		// ResultSet rslt = stmt.executeQuery();
		// while (rslt.next()) {
		// System.out.println(rslt.getString(1));
		// }
	}

}
