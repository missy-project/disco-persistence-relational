package org.gesis.skos.persistence.relational;

import org.gesis.persistence.relational.GenericResourceHibernateDAO;
import org.gesis.skos.ConceptScheme;
import org.gesis.skos.persistence.ConceptSchemeDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author matthaeus
 * 
 */
public class ConceptSchemeDAOHibernate extends GenericResourceHibernateDAO<ConceptScheme> implements ConceptSchemeDAO
{

	public ConceptSchemeDAOHibernate()
	{
		super();
	}

	public ConceptSchemeDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
