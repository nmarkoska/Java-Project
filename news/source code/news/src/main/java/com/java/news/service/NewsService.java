package com.java.news.service;

import com.java.news.exception.MyCustomException;
import com.java.news.module.News;
import com.java.news.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {

    @Autowired
    NewsRepository repository;

    public List<News> list(String title, String date, String description, Integer categoryId) {
        return repository.findAll(searchCriteria(title, date, description, categoryId));
    }

    private Specification<News> searchCriteria(String title, String date, String description, Integer categoryId) {
        return new Specification<News>() {
            @Override
            public Predicate toPredicate(Root<News> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return searchPredicates(root, criteriaQuery, criteriaBuilder, title, date, description, categoryId);
            }
        };
    }

    private Predicate searchPredicates(Root<News> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder, String title, String date, String description, Integer categoryId){
        List<Predicate> predicates = new ArrayList<>();

        if (title != null && !"".equals(title)) {
            predicates.add(criteriaBuilder.like(root.get("title"), "%" + title + "%"));
        }

        if (date != null && !"".equals(date)) {
            predicates.add(criteriaBuilder.like(root.get("date"), date));
        }

        if (description != null && !"".equals(description)) {
            predicates.add(criteriaBuilder.like(root.get("description"), "%" + description + "%"));
        }

        if (categoryId != null && categoryId != 0) {
            predicates.add(criteriaBuilder.equal(root.get("category").get("id"), categoryId));
        }

        criteriaQuery.orderBy(criteriaBuilder.desc(root.get("id")));
        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }

    public News show(Integer id) {
        return repository.findById(id).orElseThrow(
                () -> new MyCustomException("Can not find news", HttpStatus.NOT_FOUND)
        );
    }

    public News save(News news) {
        return repository.save(news);
    }

    public News update(Integer id, News news) {
        if (!repository.existsById(id)) {
            throw new MyCustomException("Can not find news", HttpStatus.NOT_FOUND);
        }

        return repository.save(news);
    }

    public boolean delete(Integer id) {
        if (!repository.existsById(id)) {
            throw new MyCustomException("Can not find news", HttpStatus.NOT_FOUND);
        }

        repository.deleteById(id);

        return true;
    }
}
