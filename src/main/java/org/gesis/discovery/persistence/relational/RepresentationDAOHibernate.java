package org.gesis.discovery.persistence.relational;

import org.gesis.discovery.Representation;
import org.gesis.discovery.persistence.RepresentationDAO;
import org.gesis.persistence.relational.GenericResourceHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author matthaeus
 * 
 */
public class RepresentationDAOHibernate extends GenericResourceHibernateDAO<Representation> implements RepresentationDAO
{

	public RepresentationDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
