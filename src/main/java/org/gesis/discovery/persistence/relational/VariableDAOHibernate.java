package org.gesis.discovery.persistence.relational;

import org.gesis.discovery.Variable;
import org.gesis.discovery.persistence.VariableDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author matthaeus
 * 
 */
public class VariableDAOHibernate extends GenericHibernateDAO<Variable> implements VariableDAO
{

	public VariableDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
