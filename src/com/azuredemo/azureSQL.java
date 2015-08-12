package com.azuredemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.common.AzureSettings;

public class azureSQL {
	public void readSQL() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection con = DriverManager.getConnection(AzureSettings.sqlconnectionString);
			System.out.print("Connected.<br/>");
			String SQL = "SELECT * FROM [User]";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);

			while (rs.next()) {
				System.out.print(rs.getString(1) + ": " + rs.getString(2)
						+ "<br/>");
			}
		} catch (Exception e) {
			System.out.print("Error message: " + e.getMessage());
		}
	}
}
