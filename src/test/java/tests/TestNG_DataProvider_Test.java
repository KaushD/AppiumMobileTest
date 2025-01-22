package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG_DataProvider_Test {

    @Test (dataProvider = "getData")
    public void test1(String count, String description, String name){
        System.out.println("Count = " +count);
        System.out.println("Description = "+ description);
        System.out.println("Name = "+name);
    }

    @Test
    public void test(){
        System.out.println("Test 2 executed");
    }

    @DataProvider
    public Object[][] getData(){
       Object[][] obj =  new Object[2][3];

       // Dataset 1
        obj[0][0] = "1";
        obj[0][1]="descrption 1";
        obj[0][2] = "name 1";


        // Dataset 2
        obj[1][0] = "2";
        obj[1][1]="descrption 2";
        obj[1][2] = "name 2";

        return obj;
    }

}
