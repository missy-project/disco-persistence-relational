package org.gesis.discovery.persistence.relational;

import org.gesis.discovery.DescriptiveStatistics;
import org.gesis.discovery.persistence.DescriptiveStatisticsDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class DescriptiveStatisticsDAOHibernate extends GenericHibernateDAO<DescriptiveStatistics> implements DescriptiveStatisticsDAO
{

	public DescriptiveStatisticsDAOHibernate( HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
