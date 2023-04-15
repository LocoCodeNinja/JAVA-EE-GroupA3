package prog3060.groupa3;

import Service.HRManagerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;

@SpringBootApplication
@ComponentScan(basePackageClasses = {HRManagerService.class})
@EntityScan("Model")
@EnableJpaRepositories("Repository")
public class GroupA3Application {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(GroupA3Application.class, args);
        // test all Services here
        HRManagerService hrManagerService = ctx.getBean(HRManagerService.class);

        hrManagerService.runQueries();
    }
}


