package org.gesis.rdf.persistence.relational;

import org.gesis.persistence.relational.GenericResourceHibernateDAO;
import org.gesis.rdf.List;
import org.gesis.rdf.persistence.ListDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author matthaeus
 * 
 */
public class ListDAOHibernate extends GenericResourceHibernateDAO<List> implements ListDAO
{

	public ListDAOHibernate()
	{
		super();
	}

	public ListDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
