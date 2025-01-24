package sparta.week1.Simple_Memo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SimpleMemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleMemoApplication.class, args);
	}


}
