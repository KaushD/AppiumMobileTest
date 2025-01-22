package tests;

import org.testng.annotations.Test;

public class TestNG_HelperAttributes {
@Test
    public void etest1(){
    System.out.println("test1");
}

    @Test(dependsOnMethods = {"etest1"})
    public void dtest2(){
        System.out.println("test2");
    }

    //IF the test takes longer to execute, then add a customise timeout
    @Test (timeOut = 40)
    public void ctest3(){
        System.out.println("test3");
    }

    @Test(enabled = false)
    public void btest4(){
        System.out.println("test4");
    }

    @Test(dependsOnMethods = {"etest1", "ctest3"})
    public void atest5() {
        System.out.println("test5");
    }
}
