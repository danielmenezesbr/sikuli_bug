package mypackage;

import mypackage.service.AutomationService;
import org.sikuli.script.ImagePath;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;

public class ApplicationWithoutSpringboot {

    public static void main(String[] args) throws IOException {
        AutomationService.init();
        new AutomationService().start();
    }
}
