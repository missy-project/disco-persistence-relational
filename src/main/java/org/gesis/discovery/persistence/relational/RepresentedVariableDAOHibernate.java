package org.gesis.discovery.persistence.relational;

import org.gesis.discovery.RepresentedVariable;
import org.gesis.discovery.persistence.RepresentedVariableDAO;
import org.gesis.persistence.relational.GenericResourceHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author matthaeus
 * 
 */
public class RepresentedVariableDAOHibernate extends GenericResourceHibernateDAO<RepresentedVariable> implements RepresentedVariableDAO
{

	public RepresentedVariableDAOHibernate(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

}
