package org.gesis.ddi.ontology.persistence.relational;

import org.gesis.ddi.ontology.Variable;
import org.gesis.ddi.ontology.persistence.VariableDAO;
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
