package org.gesis.discovery.persistence.relational;

import org.gesis.discovery.DescriptiveStatistics;
import org.gesis.discovery.persistence.DescriptiveStatisticsDAO;
import org.gesis.persistence.relational.GenericResourceHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author matthaeus
 * 
 */
public class DescriptiveStatisticsDAOHibernate extends GenericResourceHibernateDAO<DescriptiveStatistics> implements DescriptiveStatisticsDAO
{

	public DescriptiveStatisticsDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
