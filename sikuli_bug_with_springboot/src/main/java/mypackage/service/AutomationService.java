package mypackage.service;


import org.sikuli.script.FindFailed;
import org.sikuli.script.ImagePath;
import org.sikuli.script.Screen;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class AutomationService {

    private static Logger log = LoggerFactory.getLogger(AutomationService.class);

    public static void init() throws IOException {
        System.setProperty("java.awt.headless", "false");
        ImagePath.add(new ClassPathResource("images").getURL());
    }

    public void start() {
        Screen screen = new Screen();
        screen.mouseMove(0, 0);
        try {
            screen.click("START_BUTTON_WIN10.png");
        } catch (FindFailed e) {
            throw new IllegalStateException(e);
        }
        log.info("ok");
    }
}
