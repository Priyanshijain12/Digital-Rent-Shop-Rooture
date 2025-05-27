package rooture.com.rooture_server.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "rooture.com.rooture_server")
@EnableTransactionManagement
public class JpaConfig {
} 