package TestNG.TestNG;

import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DataProviderWithExel {
	WebDriver driver;

	@BeforeMethod
	public void setup()
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions(); 
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	} 

	@Test(dataProvider = "searchDataProvider")
	public void searchKeyword(String keyword)
	{
		WebElement searchBox = driver.findElement(By.name("q"));
		searchBox.sendKeys(keyword);
		searchBox.sendKeys(Keys.ENTER);
	}

	@DataProvider(name = "searchDataProvider")
	public Object[][] searchDataProviderMethod()
	{
		String fileName = "F:\\searchData.xlsx";
		Object[][] searchData = getExelData(fileName,"sheet1");

		// HARD CODED DATA
		//		Object[][] searchData = new Object[2][1];
		//		searchData[0][0] = "Taj Mahal";
		//		searchData[1][0] = "India Gate";

		return searchData;
	}

	public String[][] getExelData(String fileName, String sheetName)
	{
		// declare array
		String[][] data = null;

		// Open file in read mode
		try {
			FileInputStream inputStream = new FileInputStream(fileName);

			// Create XSSFWorkBook class object for excel file manipulation
			XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
			XSSFSheet exelSheet = workBook.getSheet(sheetName);

			// Get total no of rows
			int ttlRows = exelSheet.getLastRowNum() + 1;

			// Get total no of cells
			int ttlCells = exelSheet.getRow(0).getLastCellNum();

			// Initialize array
			data = new String[ttlRows-1][ttlCells];

			for(int currentRow = 1; currentRow < ttlRows; currentRow++) // loop for row
			{
				for(int currentCell = 1; currentCell < ttlCells; currentCell++) // loop for cell
				{
					data[currentRow-1][currentCell] = exelSheet.getRow(currentRow).getCell(currentCell).getStringCellValue();
				}
			}
			workBook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
