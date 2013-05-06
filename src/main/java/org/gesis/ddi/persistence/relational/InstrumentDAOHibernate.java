package org.gesis.ddi.persistence.relational;

import java.util.Collections;
import java.util.List;

import org.gesis.ddi.ontology.Instrument;
import org.gesis.ddi.persistence.dataAccess.InstrumentDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class InstrumentDAOHibernate extends GenericHibernateDAO<Instrument> implements InstrumentDAO
{

	public InstrumentDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

	@Override
	@Transactional
	public List<Instrument> getAll()
	{
		List<Instrument> instruments = getHibernateTemplate().loadAll( getPersistenceClass() );

		if ( instruments == null )
			return Collections.emptyList();

		return instruments;
	}

}
