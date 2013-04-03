package org.gesis.ddi.persistence.relational;

import java.util.Collections;
import java.util.List;

import org.gesis.ddi.persistence.dataAccess.ConceptDAO;
import org.gesis.skos.Concept;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class ConceptDAOHibernate extends GenericHibernateDAO<Concept> implements ConceptDAO
{

	public ConceptDAOHibernate(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

	@Override
	public Concept getById( final String urn, final boolean lock )
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Concept> getAll()
	{
		@SuppressWarnings( "unchecked" )
		List<Concept> concepts = getHibernateTemplate().find( "from Concept" );

		if ( concepts == null )
			return Collections.emptyList();

		return concepts;
	}

}
