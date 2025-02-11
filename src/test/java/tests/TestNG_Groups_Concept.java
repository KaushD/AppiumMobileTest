package tests;

import org.testng.annotations.Test;

public class TestNG_Groups_Concept extends BaseClass
{
    @Test (groups = {"smoke"})
    public void test1(){
        System.out.println("test1");
    }

    @Test (groups = {"smoke"})
    public void test2(){
        System.out.println("test2");
    }

    @Test (groups = {"regression","smoke"})
    public void test3(){
        System.out.println("test3");
    }
}
