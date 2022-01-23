package com.java.news.controller;

import com.java.news.module.News;
import com.java.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/news")
public class NewsController {

    @Autowired
    NewsService newsService;

    @GetMapping()
    public ResponseEntity<?> list(
            @RequestParam(value = "title", required = false) String title,
            @RequestParam(value = "date", required = false) String date,
            @RequestParam(value = "description", required = false) String description,
            @RequestParam(value = "categoryId", required = false) Integer categoryId){
        return new ResponseEntity<>(newsService.list(title, date, description, categoryId), HttpStatus.OK);
    }

    @GetMapping(path = "{id}")
    public ResponseEntity<?> show(@PathVariable("id") Integer id){
        return new ResponseEntity<>(newsService.show(id), HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<?> save(@RequestBody @Valid News news){
        return new ResponseEntity<>(newsService.save(news), HttpStatus.CREATED);
    }

    @PutMapping(path = "{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id, @RequestBody @Valid News news){
        return new ResponseEntity<>(newsService.update(id, news), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        return new ResponseEntity<>(newsService.delete(id), HttpStatus.OK);
    }

}
