package org.gesis.discovery.persistence.relational;

import org.gesis.discovery.CategoryStatistics;
import org.gesis.discovery.persistence.CategoryStatisticsDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * Hibernate implementation for CategoryStatistics.
 * 
 * @author matthaeus
 * 
 */
public class CategoryStatisticsDAOHibernate extends GenericHibernateDAO<CategoryStatistics> implements CategoryStatisticsDAO
{

	public CategoryStatisticsDAOHibernate( HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
