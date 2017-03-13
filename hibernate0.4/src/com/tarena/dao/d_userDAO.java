package com.tarena.dao;
// default package

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;

import com.tarena.entity.d_user;

public class d_userDAO extends BaseHibernateDAO  {
    private static final Log log = LogFactory.getLog(d_userDAO.class);


    
    public void save(d_user transientInstance) {
        log.debug("saving d_user instance");
        try {
            getSession().save(transientInstance);
            log.debug("save successful");
        } catch (RuntimeException re) {
            log.error("save failed", re);
            throw re;
        }
    }
    
	public void delete(d_user persistentInstance) {
        log.debug("deleting d_user instance");
        try {
            getSession().delete(persistentInstance);
            log.debug("delete successful");
        } catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public d_user findById( java.lang.Integer id) {
        log.debug("getting d_user instance with id: " + id);
        try {
            d_user instance = (d_user) getSession()
                    .get("d_user", id);
            return instance;
        } catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    
    public List findByExample(d_user instance) {
        log.debug("finding d_user instance by example");
        try {
            List results = getSession()
                    .createCriteria("d_user")
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
      log.debug("finding d_user instance with property: " + propertyName
            + ", value: " + value);
      try {
         String queryString = "from d_user as model where model." 
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
		log.debug("finding all d_user instances");
		try {
			String queryString = "from d_user";
	         Query queryObject = getSession().createQuery(queryString);
			 return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	
    public d_user merge(d_user detachedInstance) {
        log.debug("merging d_user instance");
        try {
            d_user result = (d_user) getSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        } catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }

    public void attachDirty(d_user instance) {
        log.debug("attaching dirty d_user instance");
        try {
            getSession().saveOrUpdate(instance);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(d_user instance) {
        log.debug("attaching clean d_user instance");
        try {
            getSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        } catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
}