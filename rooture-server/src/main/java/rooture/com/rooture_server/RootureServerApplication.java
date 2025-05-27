package rooture.com.rooture_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "rooture.com.rooture_server")
@EnableJpaRepositories(basePackages = "rooture.com.rooture_server")
public class RootureServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RootureServerApplication.class, args);
	}

}
