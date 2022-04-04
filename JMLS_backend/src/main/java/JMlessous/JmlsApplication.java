package JMlessous;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
@EnableAutoConfiguration(exclude={BatchAutoConfiguration.class})
@SpringBootApplication
public class JmlsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmlsApplication.class, args);

	}

}
