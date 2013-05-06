package org.gesis.ddi.persistence.relational;

import java.util.Collections;
import java.util.List;

import org.gesis.dcterms.PeriodOfTime;
import org.gesis.ddi.persistence.dataAccess.PeriodOfTimeDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class PeriodOfTimeDAOHibernate extends GenericHibernateDAO<PeriodOfTime> implements PeriodOfTimeDAO
{

	public PeriodOfTimeDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

	@Override
	@Transactional
	public List<PeriodOfTime> getAll()
	{
		List<PeriodOfTime> periods = getHibernateTemplate().loadAll( getPersistenceClass() );

		if ( periods == null )
			return Collections.emptyList();

		return periods;
	}

}