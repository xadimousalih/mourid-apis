package com.mycompany.newsclient.controller;

import com.mycompany.newsclient.client.PublisherApiClient;
import com.mycompany.newsclient.client.dto.MyPage;
import com.mycompany.newsclient.client.dto.Khassida;
import com.mycompany.newsclient.client.dto.SearchDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@RequiredArgsConstructor
@Controller
public class KhassidaController {

    private final PublisherApiClient publisherApiClient;

    @GetMapping(value = {"/"})
    public String getKhassida(@RequestParam(required = false) Integer page,
                          @RequestParam(required = false) Integer size,
                          @RequestParam(required = false, defaultValue = "datetime,desc") String sort,
                          Model model) {
        model.addAttribute("searchDto", new SearchDto());
        model.addAttribute("khassidaList", publisherApiClient.listKhassidaByPage(page, size, sort));
        return "khassida";
    }

    @PostMapping("/search")
    public String searchKhassida(@RequestParam(required = false) Integer page,
                             @RequestParam(required = false) Integer size,
                             @RequestParam(required = false, defaultValue = "datetime,desc") String sort,
                             @ModelAttribute SearchDto searchDto,
                             Model model) {
        MyPage<Khassida> result;
        if (searchDto.getText().trim().isEmpty()) {
            result = publisherApiClient.listKhassidaByPage(page, size, sort);
        } else {
            result = publisherApiClient.searchKhassidaByPage(searchDto, page, size, sort);
        }
        model.addAttribute("khassidaList", result);
        return "khassida";
    }

}
