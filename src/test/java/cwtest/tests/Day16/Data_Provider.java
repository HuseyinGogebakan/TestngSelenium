package cwtest.tests.Day16;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_Provider {


    @Test(dataProvider = "data")
    public void test01(String email,String password,String errorMessage){
        System.out.println("navigate to  the website");
        System.out.println("enter email on username tab: "+email);
        System.out.println("Password : "+password);
        System.out.println("errorMessage = " + errorMessage);



    }

    @DataProvider(parallel = true)
    public Object[][] data(){


        Object[][] data = new Object[5][3];
        
        data[0] = new Object[]{"example@example.com","Aa1.","6 harften kisa"};
        data[1] = new Object[]{"example@example.com","Aa1.","6 harften kisa"};
        data[2] = new Object[]{"example@example.com","Aa1.","20 harften harften kisa"};
        data[3] = new Object[]{"example@example.com","Aa1.","20 harften harften kisa"};
        data[4] = new Object[]{"example@example.com","Aa1.","20 harften harften kisa"};


        return data;

    }
}
