package org.gesis.discovery.persistence.relational;

import org.gesis.persistence.relational.GenericHibernateDAO;
import org.gesis.rdf.List;
import org.gesis.rdf.persistence.ListDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author matthaeus
 * 
 */
public class ListDAOHibernate extends GenericHibernateDAO<List> implements ListDAO
{

	public ListDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
