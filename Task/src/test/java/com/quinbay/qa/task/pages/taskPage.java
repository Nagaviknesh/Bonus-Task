package com.quinbay.qa.task.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class taskPage extends BasePage {
    WebDriver webDriver;
    public JavascriptExecutor js;
    public taskPage(WebDriver driver)
    {
        webDriver=driver;

        js=(JavascriptExecutor) driver;
    }

    public int env1,env2;
        static int n = 0;
        String environment;
        public void getEnvironment(String string) {
         environment=string;
         switch (string) {
                case "Qa1":
                    n = 2;
                    break;
                case "QA2":
                    n = 3;
                    break;
                case "Stg":
                    n = 4;
                    break;
                case "Preprod":
                    n = 5;
                    break;
                case "Prod":
                    n = 6;
                    break;
            }
        }

        public void getName() throws IOException {
            Date objDate = new Date(); // Current System Date and time is assigned to objDate
            System.out.println(objDate);
            String strDateFormat = "dd MMM yyyy  hh:mm"; //Date format is Specified
            SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat); //Date format string is passed as an argument to the Date format object
            String obj = objSDF.format(objDate);
            System.out.println(obj);

            String filename = environment + obj;
            FileWriter writer = new FileWriter("/Users/nagavikneshm/Downloads/"+filename+".txt");
            BufferedWriter bufferedWriter = new BufferedWriter(writer);


            int limit=334;bufferedWriter.write("The missing appName for the environment " + environment + "  are :");
            for(int i=1;i<=limit;i++)
            {
                WebElement number = driver.findElement(By.xpath("//div//div//tr["+i+"]//td["+n+"]"));
               js.executeScript("arguments[0].scrollIntoView()",number);
                if(number.getText().equals(""))
                {
                    WebElement Name = driver.findElement(By.xpath("//div//div//tr["+i+"]//td[1]"));
                    bufferedWriter.write(Name.getText());
                    bufferedWriter.newLine();
                    System.out.println(Name.getText());
                }
            }bufferedWriter.close();
            driver.quit();
        }
    public void setEnvironments(String arg0, String arg1) {
//environment=arg0;
        for(int i=2;i<7;++i)
        {
            if(driver.findElement(By.xpath("//tr//th["+i+"]")).getText().equals(arg0))
            {
                env1=i;
            }
            if(driver.findElement(By.xpath("//tr//th["+i+"]")).getText().equals(arg1))
            {
                env2=i;
            }
        }
        System.out.println(env1);
        System.out.println(env2);
    }
    public void check() throws IOException {
        Date objDate = new Date();
        System.out.println(objDate);
        String strDateFormat = "dd MMM yyyy  hh:mm";
        SimpleDateFormat objSDF = new SimpleDateFormat(strDateFormat);
        String obj = objSDF.format(objDate);
        System.out.println(obj);

        String filename = "new" + obj;
        FileWriter writer = new FileWriter("/Users/nagavikneshm/Downloads/"+filename+".txt");
        BufferedWriter br = new BufferedWriter(writer);
        int i = 1;
        while (i<335) {
            js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//tr["+i+"]//td["+env1+"]")));
            if(driver.findElement(By.xpath("//tr["+i+"]//td["+env1+"]")).getText().equals(driver.findElement(By.xpath("//tr["+i+"]//td["+env2+"]")).getText()))
            {
                ++i;
                continue;
            }
            else
            {

                br.write(driver.findElement(By.xpath("//tr["+i+"]//td[1]")).getText());
                br.newLine();
                System.out.println(driver.findElement(By.xpath("//tr["+i+"]//td[1]")).getText());
            }
            ++i;
        }
        br.close();
        driver.close();
    }
}
