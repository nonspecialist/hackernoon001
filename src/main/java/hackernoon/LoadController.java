package hackernoon;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadController {

    @RequestMapping("/load")
    public Load load() {

        //https://caffinc.github.io/2016/03/cpu-load-generator/

        long startTime = System.currentTimeMillis();
        long duration = 1000;
        //random load percentage
        double load = Math.random();
        try {
            // Loop for the given duration
            while (System.currentTimeMillis() - startTime < duration) {
                // Every 100ms, sleep for the percentage of unladen time
                if (System.currentTimeMillis() % 100 == 0) {
                    Thread.sleep((long) Math.floor((1 - load) * 100));
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new Load(String.valueOf(load));
    }

}
