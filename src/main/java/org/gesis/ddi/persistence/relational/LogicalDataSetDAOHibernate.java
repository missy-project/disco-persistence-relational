package org.gesis.ddi.persistence.relational;

import java.util.Collections;
import java.util.List;

import org.gesis.ddi.ontology.LogicalDataSet;
import org.gesis.ddi.persistence.dataAccess.LogicalDataSetDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class LogicalDataSetDAOHibernate extends GenericHibernateDAO<LogicalDataSet> implements LogicalDataSetDAO
{

	public LogicalDataSetDAOHibernate(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

	@Override
	public List<LogicalDataSet> getAll()
	{
		@SuppressWarnings( "unchecked" )
		List<LogicalDataSet> sets = getHibernateTemplate().find( "from LogicalDataSet" );

		if ( sets == null )
			return Collections.emptyList();

		return sets;
	}

}
