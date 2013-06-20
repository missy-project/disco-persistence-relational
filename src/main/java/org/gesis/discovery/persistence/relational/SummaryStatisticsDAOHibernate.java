package org.gesis.discovery.persistence.relational;

import org.gesis.discovery.SummaryStatistics;
import org.gesis.discovery.persistence.SummaryStatisticsDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class SummaryStatisticsDAOHibernate extends GenericHibernateDAO<SummaryStatistics> implements SummaryStatisticsDAO
{

	public SummaryStatisticsDAOHibernate( HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
