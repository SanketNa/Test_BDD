package Configuration;



import com.cucumber.listener.Reporter;
import org.apache.log4j.Level;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.apache.commons.io.FileUtils.copyFile;

public class SetUp {

    public WebDriver driver;
    public Properties prop;
    public static String TESTDATA_SHEET_PATH = "D:\\Test\\Test_BDD\\src\\main\\java\\testdata\\TestData.xlsx";

    static Workbook book;
    static Sheet sheet;
    static XSSFSheet ExcelWSheet;
    static XSSFWorkbook ExcelWBook;
    static XSSFCell Cell;
    static XSSFRow Row;


    //*********** To read the proper
    public SetUp() {

        File file = new File("D:\\Test\\Test_BDD\\src\\test\\resources\\configuration.properties");
        FileInputStream fileInput = null;
        try {
            fileInput = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        prop = new Properties();
        try {
            prop.load(fileInput);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void browserInitialise() {

        String Browser=prop.getProperty("Browser");
        if (Browser.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\driver\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        else if (Browser.equals("FF") ){
            System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\driver\\geckodriver.exe\"");
            WebDriver driver = new FirefoxDriver();
        }
        else if (Browser.equals("IE") ){
            System.setProperty("webdriver.ie.driver", "src\\test\\resources\\driver\\IEDriverServer.exe");
            WebDriver driver=new InternetExplorerDriver();

        }
        driver.get(prop.getProperty("Website"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }



//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

    public static void setExcelFile(String Path,String SheetName) throws Exception {

        try {
            // Open the Excel file
            FileInputStream ExcelFile = new FileInputStream(Path);
            // Access the required test data sheet
            ExcelWBook = new XSSFWorkbook(ExcelFile);
            ExcelWSheet = ExcelWBook.getSheet(SheetName);
        } catch (Exception e){
            throw (e);

        }

    }

//This method is to read the test data from the Excel cell, in this we are passing parameters as Row num and Col num

    public String getCellData(int RowNum, int ColNum) throws Exception{

        try{
            Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
            String CellData = Cell.getStringCellValue();
            return CellData;
        }catch (Exception e){
            return"";

        }
    }

    public void addScreenshot(String screenshotName) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String ImageName =  screenshotName+ "_" + timeStamp;
        File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshot/" + ImageName + ".png");
        copyFile(sourcePath, destinationPath);
        Reporter.addScreenCaptureFromPath("./screenshot/"+ImageName+".png");
    }


}