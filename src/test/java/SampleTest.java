import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootTest
public class SampleTest {
    @Autowired
    private WebClient.Builder webClientBuilder;

    @Test
    public void webClientTest() {
        System.out.println(webClientBuilder);
    }
}
