package kr.ac.koreatech.devops_step1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;


@Controller
@Slf4j
public class HomeController {
    @GetMapping("/")
    public String index() {
        log.info("hello world");
        return "index.html";
    }
}
