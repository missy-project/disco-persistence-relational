package org.gesis.ddi.persistence.relational;

import org.gesis.ddi.ontology.SummaryStatistics;
import org.gesis.ddi.persistence.dataAccess.SummaryStatisticsDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class SummaryStatisticsDAOHibernate extends GenericHibernateDAO<SummaryStatistics> implements SummaryStatisticsDAO
{

	public SummaryStatisticsDAOHibernate( HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
