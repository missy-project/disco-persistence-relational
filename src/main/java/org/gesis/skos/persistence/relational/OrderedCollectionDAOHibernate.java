package org.gesis.skos.persistence.relational;

import org.gesis.persistence.relational.GenericResourceHibernateDAO;
import org.gesis.skos.OrderedCollection;
import org.gesis.skos.persistence.OrderedCollectionDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author matthaeus
 * 
 */
public class OrderedCollectionDAOHibernate extends GenericResourceHibernateDAO<OrderedCollection> implements OrderedCollectionDAO
{

	public OrderedCollectionDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
