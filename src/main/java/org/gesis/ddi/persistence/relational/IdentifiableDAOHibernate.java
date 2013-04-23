package org.gesis.ddi.persistence.relational;

import java.util.Collections;
import java.util.List;

import org.gesis.ddi.Identifiable;
import org.gesis.ddi.persistence.dataAccess.IdentifiableDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class IdentifiableDAOHibernate extends GenericHibernateDAO<Identifiable> implements IdentifiableDAO
{

	public IdentifiableDAOHibernate(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

	@Override
	@Transactional
	public List<Identifiable> getAll()
	{
		List<Identifiable> identifiables = getHibernateTemplate().loadAll( getPersistenceClass() );

		if ( identifiables == null )
			return Collections.emptyList();

		return identifiables;
	}

}
