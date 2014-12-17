package org.gesis.discovery.persistence.relational;

import org.gesis.discovery.CategoryStatistics;
import org.gesis.discovery.persistence.CategoryStatisticsDAO;
import org.gesis.persistence.relational.GenericResourceHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * Hibernate implementation for CategoryStatistics.
 * 
 * @author matthaeus
 * 
 */
public class CategoryStatisticsDAOHibernate extends GenericResourceHibernateDAO<CategoryStatistics> implements CategoryStatisticsDAO
{

	public CategoryStatisticsDAOHibernate()
	{
		super();
	}

	public CategoryStatisticsDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
