package hackernoon;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DefaultController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/")
    public Default greeting(@RequestParam(value="name", defaultValue="Hackernoon") String name) {
        return new Default(counter.incrementAndGet(),
                            String.format(template, name));
    }
}
