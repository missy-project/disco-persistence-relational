package org.gesis.ddi.persistence.relational;

import org.gesis.ddi.persistence.dataAccess.ConceptDAO;
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
