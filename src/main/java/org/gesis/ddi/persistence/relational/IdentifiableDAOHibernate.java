package org.gesis.ddi.persistence.relational;

import java.util.Collections;
import java.util.List;

import org.gesis.ddi.Identifiable;
import org.gesis.ddi.persistence.dataAccess.IdentifiableDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class IdentifiableDAOHibernate extends GenericHibernateDAO<Identifiable> implements IdentifiableDAO
{

	public IdentifiableDAOHibernate(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

	@Override
	public List<Identifiable> getAll()
	{
		@SuppressWarnings( "unchecked" )
		List<Identifiable> ids = getHibernateTemplate().find( "from Identifiable" );

		if ( ids == null )
			return Collections.emptyList();

		return ids;
	}

}
