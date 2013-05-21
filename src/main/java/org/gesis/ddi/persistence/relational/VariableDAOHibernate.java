package org.gesis.ddi.persistence.relational;

import org.gesis.ddi.ontology.Variable;
import org.gesis.ddi.persistence.dataAccess.VariableDAO;
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
