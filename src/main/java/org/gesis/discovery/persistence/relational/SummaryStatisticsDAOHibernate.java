package org.gesis.discovery.persistence.relational;

import org.gesis.discovery.SummaryStatistics;
import org.gesis.discovery.persistence.SummaryStatisticsDAO;
import org.gesis.persistence.relational.GenericResourceHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author matthaeus
 * 
 */
public class SummaryStatisticsDAOHibernate extends GenericResourceHibernateDAO<SummaryStatistics> implements SummaryStatisticsDAO
{

	public SummaryStatisticsDAOHibernate()
	{
		super();
	}

	public SummaryStatisticsDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
