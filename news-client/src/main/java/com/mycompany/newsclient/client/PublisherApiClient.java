package com.mycompany.newsclient.client;

import com.mycompany.newsclient.client.dto.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("publisher-api")
public interface PublisherApiClient {

    @GetMapping("/api/news")
    MyPage<News> listNewsByPage(@RequestParam Integer page, @RequestParam Integer size,
                                @RequestParam String sort);

    @PutMapping("/api/news/search")
    MyPage<News> searchNewsByPage(@RequestBody SearchDto searchDto, @RequestParam Integer page,
                                  @RequestParam Integer size, @RequestParam String sort);

    @GetMapping("/api/khassidas")
    MyPage<Khassida> listKhassidaByPage(@RequestParam Integer page, @RequestParam Integer size,
                                @RequestParam String sort);

    @PutMapping("/api/khassidas/search")
    MyPage<Khassida> searchKhassidaByPage(@RequestBody SearchDto searchDto, @RequestParam Integer page,
                                           @RequestParam Integer size, @RequestParam String sort);
    @GetMapping("/api/bayites")
    MyPage<Bayite> listBayiteByPage(@RequestParam Integer page, @RequestParam Integer size,
                                @RequestParam String sort);

    @PutMapping("/api/bayites/search")
    MyPage<Bayite> searchBayiteByPage(@RequestBody SearchDto searchDto, @RequestParam Integer page,
                                      @RequestParam Integer size, @RequestParam String sort);

}
