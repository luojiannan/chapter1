import org.junit.Assert;
import org.junit.Test;
import org.kaluote.chapter1.model.Customer;
import org.kaluote.chapter1.service.CustomerService;
import org.kaluote.chapter1.util.DatabaseHelper;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ljn
 * @date 2018/6/1.
 */
public class TestCustomer {

    private final CustomerService customerService;

    public TestCustomer() {
        this.customerService = new CustomerService();
    }

//    @Before
    public void init() throws IOException {
        DatabaseHelper.executeSqlFile("sql/customer_init.sql");
    }

    @Test
    public void getCustomerList() {
        List<Customer> customerList = customerService.getCustomerList();
        System.out.println(customerList);
        Assert.assertEquals(2,customerList.size());
    }

    @Test
    public void getCustomer() {
        Customer customer = customerService.getCustomer(1l);
        System.out.println(customer);
        Assert.assertNotNull(customer);
    }

    @Test
    public void createCustomer() {
        Map<String, Object> map = new HashMap<>();
        map.put("name","rose");
        map.put("contact","rose");
        map.put("telephone","15171008574");
        boolean result = customerService.createCustomer(map);
        System.out.println(result);
    }

    @Test
    public void updateCustomer() {
        Long id = 3l;
        Map<String, Object> map = new HashMap<>();
        map.put("contact","Tom");
        boolean result = customerService.updateCustomer(id, map);
        Assert.assertTrue(result);
    }

    @Test
    public void deleteCustomer(){
        boolean result = customerService.deleteCustomer(2l);
        Assert.assertTrue(result);
    }
}
