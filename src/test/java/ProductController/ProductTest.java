package ProductController;

import com.catalog.Application;
import com.catalog.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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

import java.sql.SQLOutput;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Random;

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
        mockMvc.perform(MockMvcRequestBuilders.get("/getProducts").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$",hasSize(0)));
    }

    private Product getProductItem() throws Exception{
        Product product=new Product();
        Random random = new Random();
        product.setId(random.nextInt(1000));
        product.setName("Red Shirt");
        product.setDescription("Red hugo boss shirt");
        product.setBrand("Hugo Boss");
        product.setTags("red,shirt,slim fit");
        product.setCategory("Apparel");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_INSTANT;
        //System.out.println(dateTimeFormatter);
        OffsetDateTime localDateTime =LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS).atOffset(ZoneOffset.ofHoursMinutes(5,30));
        System.out.println(localDateTime);
        String datetime1 = localDateTime.format(dateTimeFormatter);

        LocalDateTime localDateTime1=localDateTime.toLocalDateTime();

        //LocalDateTime localDateTime2 = LocalDateTime.parse(datetime1);
        System.out.println(datetime1);
        product.setCreatedat(localDateTime1);

        return product;
    }

    @Test
    public void creationProduct() throws Exception{
        Product product = getProductItem();
        ObjectMapper objectMapper = new ObjectMapper();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_INSTANT;
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        String json = objectMapper.writeValueAsString(product);
        System.out.println(json);
        createProduct(json);
    }

    private void createProduct(String json) throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/productcreation")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        /*.andExpect(MockMvcResultMatchers.jsonPath("$.name", Matchers.notNullValue()))
        .andExpect(MockMvcResultMatchers.jsonPath("$.createdat",Matchers.notNullValue()));*/
    }

}
