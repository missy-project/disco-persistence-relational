package org.gesis.rdfs.persistence.relational;

import org.gesis.persistence.relational.GenericResourceHibernateDAO;
import org.gesis.rdfs.Resource;
import org.gesis.rdfs.persistence.ResourceDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author matthaeus
 * 
 */
public class ResourceDAOHibernate extends GenericResourceHibernateDAO<Resource> implements ResourceDAO
{

	public ResourceDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
