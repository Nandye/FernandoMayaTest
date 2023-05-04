package com.example.demo.infrastructure.db.repository;

import com.example.demo.infrastructure.db.entity.PriceEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PricesCriteriaRepository {

    private EntityManager entityManager;

    @Transactional
    public List<PriceEntity> getPricesOfDemandDate(LocalDateTime demandDate, Long productId, Long brandId) {

        CriteriaBuilder criteria = entityManager.getCriteriaBuilder();
        CriteriaQuery<PriceEntity> criteriaQuery = criteria.createQuery(PriceEntity.class);
        Root<PriceEntity> root = criteriaQuery.from(PriceEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        predicates.add(criteria.lessThanOrEqualTo(root.get("startDate"), demandDate));
        predicates.add(criteria.greaterThanOrEqualTo(root.get("endDate"), demandDate));
        predicates.add(criteria.equal(root.get("brandId"), brandId));
        predicates.add(criteria.equal(root.get("productId"), productId));
        criteriaQuery.where(predicates.toArray(new Predicate[]{}));

        return entityManager.createQuery(criteriaQuery)
                .getResultList();
    }
}
