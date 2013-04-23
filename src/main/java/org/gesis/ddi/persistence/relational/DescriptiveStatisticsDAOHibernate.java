package org.gesis.ddi.persistence.relational;

import java.util.Collections;
import java.util.List;

import org.gesis.ddi.ontology.DescriptiveStatistics;
import org.gesis.ddi.persistence.dataAccess.DescriptiveStatisticsDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class DescriptiveStatisticsDAOHibernate extends GenericHibernateDAO<DescriptiveStatistics> implements DescriptiveStatisticsDAO
{

	public DescriptiveStatisticsDAOHibernate( HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

	@Override
	@Transactional
	public List<DescriptiveStatistics> getAll()
	{
		List<DescriptiveStatistics> descriptiveStatistics = getHibernateTemplate().loadAll( getPersistenceClass() );

		if ( descriptiveStatistics == null )
			return Collections.emptyList();

		return descriptiveStatistics;
	}

}
