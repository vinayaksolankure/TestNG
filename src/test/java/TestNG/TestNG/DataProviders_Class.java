package TestNG.TestNG;

import org.testng.annotations.DataProvider;

public class DataProviders_Class {

	// 1. India QutubMinar
		// 2. Agra TajMahal
		// 3. Hyderabad charminar
		@DataProvider(name = "searchDataSet")
		public Object[][] searchData(){
			Object[][] searchKeyword = new Object[3][2];
			searchKeyword[0][0] = "India";
			searchKeyword[0][1] = "QutubMinar"; 
			
			searchKeyword[1][0] = "Agra";
			searchKeyword[1][1] = "TajMahal";
			
			searchKeyword[2][0] = "Hyderabad";
			searchKeyword[2][1] = "charminar";
			
			return searchKeyword;
		}
}
