package tests;

import org.testng.annotations.Test;

public class TestNG_Loan {

    @Test
    public void loan1(){
        System.out.println("loan test 1");
    }

    @Test(groups = {"smoke"})
    public void loan2(){
        System.out.println("loan test 2");
    }

    @Test
    public void loan3(){
        System.out.println("loan test 3");
    }
}
