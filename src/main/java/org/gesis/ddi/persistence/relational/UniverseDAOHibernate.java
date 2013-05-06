package org.gesis.ddi.persistence.relational;

import java.util.Collections;
import java.util.List;

import org.gesis.ddi.ontology.Universe;
import org.gesis.ddi.persistence.dataAccess.UniverseDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class UniverseDAOHibernate extends GenericHibernateDAO<Universe> implements UniverseDAO
{

	public UniverseDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

	@Override
	@Transactional
	public List<Universe> getAll()
	{
		List<Universe> universes = getHibernateTemplate().loadAll( getPersistenceClass() );

		if ( universes == null )
			return Collections.emptyList();

		return universes;
	}

}
