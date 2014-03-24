package org.gesis.skos.persistence.relational;

import java.util.List;

import org.gesis.persistence.relational.GenericResourceHibernateDAO;
import org.gesis.skos.Concept;
import org.gesis.skos.persistence.ConceptDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * Hibernate implementation for Concept.
 * 
 * @author matthaeus
 * 
 */
public class ConceptDAOHibernate extends GenericResourceHibernateDAO<Concept> implements ConceptDAO
{

	public ConceptDAOHibernate(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

	@Override
	public List<Concept> getByNotation( final String notation )
	{
		// TODO Auto-generated method stub
		return null;
	}

}
