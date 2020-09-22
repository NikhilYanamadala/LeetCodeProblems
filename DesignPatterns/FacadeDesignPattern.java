package DesignPatterns;

import java.sql.Driver;

class FireFox {
    public static Driver getFireFoxDriver() {
        return null;
    }

    public static void generateHTMLReport(String test, Driver driver) {
        System.out.println("HTML report for fireFox");

    }
    public static void generateJunitReport(String test, Driver driver){
        System.out.println("JUNIT report for fireFox");
    }
}

class Chrome {
    public static Driver getChromeDriver() {
        return null;
    }

    public static void generateHTMLReport(String test, Driver driver) {
        System.out.println("HTML report for Chrome");

    }
    public static void generateJunitReport(String test, Driver driver){
        System.out.println("JUNIT report for Chrome");
    }
}
class WebExplorerHelperFacade{
    public static void generateReports(String explorer,String report,String test){
        Driver driver = null;
        switch (explorer){
            case "firefox":
                driver = FireFox.getFireFoxDriver();
                switch (report) {
                    case "html":
                        FireFox.generateHTMLReport(test, driver);
                        break;
                    case "juint":
                        FireFox.generateJunitReport(test, driver);
                        break;
                }
                break;
            case "chrome":
                driver = Chrome.getChromeDriver();
                switch (report) {
                    case "html":
                        Chrome.generateHTMLReport(test, driver);
                        break;
                    case "junit":
                        Chrome.generateJunitReport(test, driver);
                        break;
                }
        }

    }
}
public class FacadeDesignPattern {
    public static void main(String[] args) {
        String test = "test";
        WebExplorerHelperFacade.generateReports("firefox","html",test);
        WebExplorerHelperFacade.generateReports("chrome","junit",test);
    }
}
