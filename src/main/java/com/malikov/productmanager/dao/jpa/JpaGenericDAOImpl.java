package com.malikov.productmanager.dao.jpa;

import com.malikov.productmanager.dao.GenericDAO;
import com.malikov.productmanager.model.NamedEntity;
import org.springframework.core.GenericTypeResolver;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class JpaGenericDAOImpl<T extends NamedEntity> implements GenericDAO<T> {

    @PersistenceContext
    EntityManager em;


    public T save(T t) {
        if (t.isNew()) {
            em.persist(t);
            return t;
        }
        return em.merge(t);
    }

    @Override
    public void delete(int id) {
        T t = get(id);
        if (t != null) {
            em.remove(t);
        }
    }

    @Override
    public T get(int id) {
        T t = null;
        t = em.find(getClazz(), id);
        return t;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        return (List<T>) em.createQuery("FROM T").getResultList();
    }

    protected Class<T> getClazz() {
        return (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), JpaGenericDAOImpl.class);
    }
}
