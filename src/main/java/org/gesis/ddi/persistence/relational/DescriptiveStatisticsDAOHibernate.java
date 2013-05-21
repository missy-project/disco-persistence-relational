package org.gesis.ddi.persistence.relational;

import org.gesis.ddi.ontology.DescriptiveStatistics;
import org.gesis.ddi.persistence.dataAccess.DescriptiveStatisticsDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class DescriptiveStatisticsDAOHibernate extends GenericHibernateDAO<DescriptiveStatistics> implements DescriptiveStatisticsDAO
{

	public DescriptiveStatisticsDAOHibernate( HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
