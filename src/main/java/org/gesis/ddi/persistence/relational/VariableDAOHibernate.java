package org.gesis.ddi.persistence.relational;

import java.util.Collections;
import java.util.List;

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

	@Override
	public List<Variable> getAll()
	{
		@SuppressWarnings( "unchecked" )
		List<Variable> variables = getHibernateTemplate().find( "from Variable" );

		if ( variables == null )
			return Collections.emptyList();

		return variables;
	}

}
