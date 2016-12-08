package test.aws.kms.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableAutoConfiguration
@RestController
@ComponentScan(basePackages = "test.aws.kms")
public class Application {

//	@SuppressWarnings("unused")
//	@Autowired
//	private TextEncryptor encryptor;

	@Value("${not.secret}")
	private String notSecret;

	@Value("${yes.secret}")
	private String yesSecret;

	@RequestMapping("/")
	public String testConfiguration() {
		// values that start with {cipher} are automatically decrypted. Or you
		// can use the injected encryptor to encrypt/decrypt text on the fly.
		//String decrypted = encryptor.decrypt("Another secret");
		return String.format("No Secret = %s<br/>Secret = %s", notSecret, yesSecret);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
