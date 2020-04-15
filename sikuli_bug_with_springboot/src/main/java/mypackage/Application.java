package mypackage;

import mypackage.service.AutomationService;
import org.sikuli.script.ImagePath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;


@SpringBootApplication
public class Application {

    @Autowired
    private AutomationService automationService;

    private static Logger log = LoggerFactory.getLogger(Application.class);

	@Bean
	public CommandLineRunner commandLineRunner() {
        return new DefaultCommandLineRunner();
	}

	public static void main(String[] args) throws IOException {
        AutomationService.init();
        SpringApplication springApp = new SpringApplication(Application.class);
        try {
            springApp.run(args);
        } catch (Exception e) {
            log.error("ERROR: {}", e.getCause() == null ? "Detail." : e.getCause().getMessage());
            System.exit(1);
        }
	}

    public static class DefaultCommandLineRunner implements CommandLineRunner {

        @Autowired
        private AutomationService automationService;

		@Override
		public void run(String... strings) throws Exception {
            try {
                automationService.start();
            } catch (Exception e) {
                throw e;
            }
		}
	}
}
