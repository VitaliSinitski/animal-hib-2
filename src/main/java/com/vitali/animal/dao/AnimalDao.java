package com.vitali.animal.dao;

import com.vitali.animal.entity.Animal;
import com.vitali.animal.util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.util.List;

import static com.vitali.animal.util.HibernateUtil.*;

public class AnimalDao implements Dao<Integer, Animal> {
    private static final AnimalDao INSTANCE = new AnimalDao();
    public static AnimalDao getInstance() {
        return INSTANCE;
    }
    @Override
    public List<Animal> findAll() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Animal> criteriaQuery = cb.createQuery(Animal.class);
        Root<Animal> root = criteriaQuery.from(Animal.class);
        criteriaQuery.select(root);
        List<Animal> resultList = em.createQuery(criteriaQuery).getResultList();

        em.getTransaction().commit();
        close();
        return resultList;
    }

    @Override
    public Animal findById(Integer id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Animal animal = em.find(Animal.class, id);
        em.getTransaction().commit();
        close();
        return animal;
    }

    @Override
    public void delete(Integer id) {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Animal animal = em.find(Animal.class, id);
        em.remove(animal);
        em.getTransaction().commit();
        close();
    }

    @Override
    public void update(Animal entity, Integer id) {
        String name = entity.getName();
        Integer weight = entity.getWeight();

        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaUpdate<Animal> criteriaUpdate = builder.createCriteriaUpdate(Animal.class);
        Root<Animal> root = criteriaUpdate.from(Animal.class);

        criteriaUpdate.set("name", name);
        criteriaUpdate.set("weight", weight);
        criteriaUpdate.where(builder.equal(root.get("id"), id));

        em.createQuery(criteriaUpdate).executeUpdate();
        em.getTransaction().commit();
        close();
    }

    @Override
    public Animal save(Animal entity) {
        Animal animal = Animal.builder()
                .name(entity.getName())
                .weight(entity.getWeight())
                .build();

        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.merge(animal);
        em.getTransaction().commit();
        close();

        return animal;
    }
}
