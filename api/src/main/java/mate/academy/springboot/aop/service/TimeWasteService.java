package mate.academy.springboot.aop.service;

import org.springframework.stereotype.Component;

// This service was created to test aspect classes collected in the "aspect" package.
@Component
public class TimeWasteService {
    public void wasteFiveSecond() {
        wasteTime(5);
    }

    public void wasteTwoSecond() {
        wasteTime(2);
    }

    private void wasteTime(int second) {
        try {
            Thread.sleep(second * 1000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
