package com.LiveProject.Dataprovidrs;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.LiveProject.utility.NewExcellLibrary;

public class DataProvidrsCls  {
	
	
	NewExcellLibrary obj = new NewExcellLibrary();
		

	//Class --> LoginPageTest,HomePageTest Test Case--> loginTest, wishListTest, orderHistoryandDetailsTest

		@DataProvider (name = "Credentials")
		public static Object[][] getCredentials() {
			NewExcellLibrary obj = new NewExcellLibrary();
			// Totals rows count
			int rows = obj.getRowCount("credentials");
			// Total Columns
			int column = obj.getColumnCount("credentials");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("credentials", j, i + 2);
				}
			}
			return data;
		}

	//Class --> AccountCreationPage  Test Case--> verifyCreateAccountPageTest	
		@DataProvider(name = "email")
		public Object[][] getEmail() {
			// Totals rows count
			int rows = obj.getRowCount("Email");
			// Total Columns
			int column = obj.getColumnCount("Email");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("Email", j, i + 2);
				}
			}
			return data;
		}

	//Class --> AddToCartPageTest, EndToEndTest,  Test Case--> addToCartTest, endToEndTest	
		@DataProvider(name = "getProduct")
		public Object[][] getProduct() {
			// Totals rows count
			int rows = obj.getRowCount("ProductDetails");
			// Total Columns
			int column = obj.getColumnCount("ProductDetails");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("ProductDetails", j, i + 2);
				}
			}
			return data;
		}

		// Class --> SearchResultPageTest, Test Case--> productAvailabilityTest
		@DataProvider(name = "searchProduct")
		public Object[][] getProductPrice() {
			// Totals rows count
			int rows = obj.getRowCount("SearchProduct");
			// Total Columns
			int column = obj.getColumnCount("SearchProduct");
			int actRows = rows - 1;

			Object[][] data = new Object[actRows][column];

			for (int i = 0; i < actRows; i++) {
				for (int j = 0; j < column; j++) {
					data[i][j] = obj.getCellData("SearchProduct", j, i + 2);
				}
			}
			return data;
		}
		
		@DataProvider(name = "createAccntDetails")
		public static Object[][] accountCreation() {

			NewExcellLibrary obj = new NewExcellLibrary();

			// Totals rows count
			int rows = obj.getRowCount("accountcreationdetails");
			// Total Columns
			int column = obj.getColumnCount("accountcreationdetails");
			int actRows = rows - 1;
			//Created an object of array to store data
			Object[][] data = new Object[actRows][1];
			
			for (int i = 0; i < actRows; i++) {
				Map<String, String> hashMap = new HashMap<>();
				for (int j = 0; j < column; j++) {
					hashMap.put(obj.getCellData("accountcreationdetails", j, 1),
							obj.getCellData("accountcreationdetails", j, i + 2));
				}
				data[i][0]=hashMap;
			}
			return data;
		}

	}
