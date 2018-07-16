package web.controller;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试控制类
 */
@RestController
@Aspect
public class TestController {
    @GetMapping("/")
    public String test() {
        return "hello";
    }

    @GetMapping("/call/{name}")
    public String test(@PathVariable String name) {
        return String.format("%s is called!", name);
    }

    @GetMapping("/test/1")
    public String test1(@RequestParam("info") String info) {
        return String.format("%s is called by test2", info);
    }
}
