package org.gesis.ddi.ontology.persistence.relational;

import org.gesis.ddi.ontology.SummaryStatistics;
import org.gesis.ddi.ontology.persistence.SummaryStatisticsDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class SummaryStatisticsDAOHibernate extends GenericHibernateDAO<SummaryStatistics> implements SummaryStatisticsDAO
{

	public SummaryStatisticsDAOHibernate( HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
