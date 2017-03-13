package com.tarena.dao;
// default package

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.tarena.entity.d_fooId;
import com.tarena.entity.ext.d_foo;

public class d_fooDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(d_fooDAO.class);


    
    public void save(d_foo transientInstance) {
        log.debug("saving d_foo instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(d_foo persistentInstance) {
        log.debug("deleting d_foo instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public d_foo findById( d_fooId id) {
        log.debug("getting d_foo instance with id: " + id);
        try {
            d_foo instance = (d_foo) getSession()
                    .get("d_foo", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(d_foo instance) {
        log.debug("finding d_foo instance by example");
        try {
            List results = getSession()
                    .createCriteria("d_foo")
                    .add(Example.create(instance))
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    }    
    
    public List findByProperty(String propertyName, Object value) {
      log.debug("finding d_foo instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from d_foo as model where model." 
         						+ propertyName + "= ?";
         Query queryObject = getSession().createQuery(queryString);
		 queryObject.setParameter(0, value);
		 return queryObject.list();
      } catch (RuntimeException re) {
         log.error("find by property name failed", re);
         throw re;
      }
	}


	public List findAll() {
		log.debug("finding all d_foo instances");
		try {
			String queryString = "from d_foo";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public d_foo merge(d_foo detachedInstance) {
        log.debug("merging d_foo instance");
        try {
            d_foo result = (d_foo) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(d_foo instance) {
        log.debug("attaching dirty d_foo instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(d_foo instance) {
        log.debug("attaching clean d_foo instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}