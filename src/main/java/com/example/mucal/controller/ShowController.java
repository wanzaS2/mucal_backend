package com.example.mucal.controller;

import com.example.mucal.service.ShowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ShowController {

    private final ShowService showService;

    @GetMapping("/hello")
    public void test() throws Exception {
        showService.readJsonFile();
    }
}
