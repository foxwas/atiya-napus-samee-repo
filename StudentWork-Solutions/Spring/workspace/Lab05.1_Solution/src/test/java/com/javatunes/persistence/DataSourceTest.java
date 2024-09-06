/*
 * This code is sample code, provided as-is, and we make NO 
 * warranties as to its correctness or suitability for any purpose.
 * 
 * We hope that it's useful to you. Enjoy. 
 * Copyright LearningPatterns Inc.
 */

package com.javatunes.persistence;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.javatunes.config.SpringConfig;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes={SpringConfig.class})
public class DataSourceTest {

    // Inject a datasource
	@Autowired
    DataSource dataSource;

	@Test
	public void testDataSourceConnectedPositive() {
		System.out.println("\n*** Checking connection to database ***");
		
		try (Connection conn = dataSource.getConnection()){  // try-with-resources - automatically closes the connection
			assertTrue(conn.isValid(10), "Connection should be valid");

			// Useful information for seeing what's happening in lab.
			DatabaseMetaData meta = conn.getMetaData();
			System.out.format("\nDB Driver name is: %s\n\n", meta.getDriverName());

		} catch (SQLException e) {
			e.printStackTrace();
			fail("Couldn't connect to database");
		}
		

	}  
	

}
