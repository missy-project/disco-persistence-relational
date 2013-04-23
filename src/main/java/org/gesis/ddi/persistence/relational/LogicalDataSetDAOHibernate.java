package org.gesis.ddi.persistence.relational;

import java.util.Collections;
import java.util.List;

import org.gesis.ddi.ontology.LogicalDataSet;
import org.gesis.ddi.persistence.dataAccess.LogicalDataSetDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class LogicalDataSetDAOHibernate extends GenericHibernateDAO<LogicalDataSet> implements LogicalDataSetDAO
{

	public LogicalDataSetDAOHibernate(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

	@Override
	@Transactional
	public List<LogicalDataSet> getAll()
	{
		List<LogicalDataSet> logicalDataSets = getHibernateTemplate().loadAll( getPersistenceClass() );

		if ( logicalDataSets == null )
			return Collections.emptyList();

		return logicalDataSets;
	}

}
