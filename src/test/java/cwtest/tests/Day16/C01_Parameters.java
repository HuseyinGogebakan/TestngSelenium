package cwtest.tests.Day16;

import cwtest.utilities.BaseClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class C01_Parameters  {

    @Test
    @Parameters({"Name"})
    public void parameterized(String name1){
        System.out.println("Name is" + name1);
    }

    @Test
    @Parameters({"Name","Surname","Age"})
    public void parameterizedSec(String name , String surname, int age){
        System.out.println(surname + " : " + name+" : "+age);

    }
}
