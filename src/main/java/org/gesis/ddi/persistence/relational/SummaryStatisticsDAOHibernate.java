package org.gesis.ddi.persistence.relational;

import java.util.Collections;
import java.util.List;

import org.gesis.ddi.ontology.SummaryStatistics;
import org.gesis.ddi.persistence.dataAccess.SummaryStatisticsDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class SummaryStatisticsDAOHibernate extends GenericHibernateDAO<SummaryStatistics> implements SummaryStatisticsDAO
{

	public SummaryStatisticsDAOHibernate( HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

	@Override
	@Transactional
	public List<SummaryStatistics> getAll()
	{
		List<SummaryStatistics> summaryStatistics = getHibernateTemplate().loadAll( getPersistenceClass() );

		if ( summaryStatistics == null )
			return Collections.emptyList();

		return summaryStatistics;
	}

}
