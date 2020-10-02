package ProductController;

import com.catalog.Application;
import com.catalog.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class ProductTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private MockMvc mockMvc;
    /*private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }*/

    @Test
    public void checkEmpty() throws Exception
    {
        mockMvc.perform(MockMvcRequestBuilders.get("/productcreation").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(0)));
    }

    private Product getProductItem() throws Exception{
        Product product=new Product();
        product.setName("Red Shirt");
        product.setDescription("Red hugo boss shirt");
        product.setBrand("Hugo Boss");
        product.setTags(new String[]{"red", "shirt", "slim fit"});
        product.setCategory("Apparel");

        return product;
    }

    @Test
    public void creationProduct() throws Exception{
        Product product = new Product();
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(product);
        createProduct(json);
    }

    private void createProduct(String json) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/productcreation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.notNullValue()))
        .andExpect(MockMvcResultMatchers.jsonPath("$.createdat",Matchers.notNullValue()));
    }

}
