package org.gesis.ddi.persistence.relational;

import java.util.Collections;
import java.util.List;

import org.gesis.ddi.ontology.CategoryStatistics;
import org.gesis.ddi.persistence.dataAccess.CategoryStatisticsDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	@Transactional
	public List<CategoryStatistics> getAll()
	{
		List<CategoryStatistics> categoryStatistics = getHibernateTemplate().loadAll( getPersistenceClass() );

		if ( categoryStatistics == null )
			return Collections.emptyList();

		return categoryStatistics;
	}

}
