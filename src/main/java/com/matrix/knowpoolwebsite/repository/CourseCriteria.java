package com.matrix.knowpoolwebsite.repository;

import com.matrix.knowpoolwebsite.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseCriteria {
    @PersistenceContext
    EntityManager entityManager;

    public Page<Course> getCoursesByNameStartingWith(String prefix, Pageable pageable) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
        Root<Course> courseRoot = criteriaQuery.from(Course.class);
        List<Predicate> predicates = new ArrayList<>();

        if (prefix != null) {
            String lowerCasePrefix = prefix.toLowerCase(); // Convert to lowercase
            predicates.add(criteriaBuilder.like(criteriaBuilder.lower(courseRoot.get("title")), lowerCasePrefix + "%"));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Course> query = entityManager.createQuery(criteriaQuery)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize());

        List<Course> courses = query.getResultList();
        return new PageImpl<>(courses, pageable, courses.size());
    }
    public Page<Course> getFilteredCoursesByDuration(Integer minDuration, Integer maxDuration, Pageable pageable) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Course> criteriaQuery = criteriaBuilder.createQuery(Course.class);
        Root<Course> courseRoot = criteriaQuery.from(Course.class);
        List<Predicate> predicates = new ArrayList<>();

        if (minDuration != null && maxDuration != null) {
            predicates.add(criteriaBuilder.between(courseRoot.get("duration"), minDuration, maxDuration));
        } else if (minDuration != null) {
            predicates.add(criteriaBuilder.greaterThanOrEqualTo(courseRoot.get("duration"), minDuration));
        } else if (maxDuration != null) {
            predicates.add(criteriaBuilder.lessThanOrEqualTo(courseRoot.get("duration"), maxDuration));
        }

        criteriaQuery.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Course> query = entityManager.createQuery(criteriaQuery)
                .setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize());

        List<Course> courses = query.getResultList();
        return new PageImpl<>(courses, pageable, courses.size());
    }

}
