package org.gesis.discovery.persistence.relational;

import org.gesis.discovery.persistence.ConceptDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.gesis.skos.Concept;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * Hibernate implementation for Concept.
 * 
 * @author matthaeus
 * 
 */
public class ConceptDAOHibernate extends GenericHibernateDAO<Concept> implements ConceptDAO
{

	public ConceptDAOHibernate(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

}
