package org.gesis.ddi.ontology.persistence.relational;

import org.gesis.ddi.ontology.DescriptiveStatistics;
import org.gesis.ddi.ontology.persistence.DescriptiveStatisticsDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class DescriptiveStatisticsDAOHibernate extends GenericHibernateDAO<DescriptiveStatistics> implements DescriptiveStatisticsDAO
{

	public DescriptiveStatisticsDAOHibernate( HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
