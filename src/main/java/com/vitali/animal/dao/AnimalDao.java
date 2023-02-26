package com.vitali.animal.dao;

import com.vitali.animal.entity.Animal;
import com.vitali.animal.util.HibernateUtil;
import lombok.SneakyThrows;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.List;

public class AnimalDao implements Dao<Integer, Animal> {
    private static final AnimalDao INSTANCE = new AnimalDao();
    public static AnimalDao getInstance() {
        return INSTANCE;
    }
    @Override
    public List<Animal> findAll() {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Animal> criteriaQuery = cb.createQuery(Animal.class);
        Root<Animal> root = criteriaQuery.from(Animal.class);
        criteriaQuery.select(root);

        List<Animal> resultList = em.createQuery(criteriaQuery).getResultList();

        em.getTransaction().commit();
        em.close();
        return resultList;
    }

    public List<Animal> findAllByPage(Integer currentPage, Integer recordsPerPage) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Animal> criteria = cb.createQuery(Animal.class);
        Root<Animal> root = criteria.from(Animal.class);

        TypedQuery<Animal> typedQuery = em.createQuery(criteria);
        typedQuery.setFirstResult(currentPage);
        typedQuery.setMaxResults(recordsPerPage);
        List<Animal> resultList = typedQuery.getResultList();

        em.getTransaction().commit();
        em.close();
        return resultList;
    }

    public Integer getNumberOfRows() {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Animal> criteria = builder.createQuery(Animal.class);
        Root<Animal> root = criteria.from(Animal.class);

        Integer size = em.createQuery(criteria).getResultList().size();

        em.getTransaction().commit();
        em.close();
        return size;
    }


    @Override
    public Animal findById(Integer id) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();

        Animal animal = em.find(Animal.class, id);
        em.getTransaction().commit();
        em.close();
        return animal;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        Animal animal = em.find(Animal.class, id);
        em.remove(animal);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void update(Animal entity, Integer id) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();

        entity.setId(id);
        em.merge(entity);

        em.getTransaction().commit();
        em.close();
    }

    @SneakyThrows
    @Override
    public Animal save(Animal entity) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();

//        Animal animal = Animal.builder()
//                .name(entity.getName())
//                .weight(entity.getWeight())
//                .build();

        em.persist(entity);
//        Integer id = animal.getId();
//        animal.setId(id);

        em.getTransaction().commit();
        em.close();

        return entity;
    }
}
