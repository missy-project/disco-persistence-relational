package org.gesis.ddi.ontology.persistence.relational;

import org.gesis.ddi.ontology.CategoryStatistics;
import org.gesis.ddi.ontology.persistence.CategoryStatisticsDAO;
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
