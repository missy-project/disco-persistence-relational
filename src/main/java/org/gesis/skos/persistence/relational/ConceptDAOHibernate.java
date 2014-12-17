package org.gesis.skos.persistence.relational;

import java.util.Collections;
import java.util.List;

import org.gesis.persistence.relational.GenericResourceHibernateDAO;
import org.gesis.skos.Concept;
import org.gesis.skos.persistence.ConceptDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.util.StringUtils;

/**
 * Hibernate implementation for Concept.
 * 
 * @author matthaeus
 * 
 */
public class ConceptDAOHibernate extends GenericResourceHibernateDAO<Concept> implements ConceptDAO
{

	public ConceptDAOHibernate()
	{
		// TODO Auto-generated constructor stub
	}

	public ConceptDAOHibernate(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

	@Override
	public List<Concept> getByNotation( final String notation )
	{
		if ( StringUtils.isEmpty( notation ) )
			return Collections.emptyList();

		@SuppressWarnings( "unchecked" )
		List<Concept> concepts = getHibernateTemplate().find( "FROM " + getPersistenceClass().getName() + " c WHERE c.notation = ?", notation );

		if ( concepts == null )
			return Collections.emptyList();

		return concepts;
	}

}
