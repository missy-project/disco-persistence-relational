package org.gesis.ddi.persistence.relational;

import java.util.Collections;
import java.util.List;

import org.gesis.ddi.ontology.Variable;
import org.gesis.ddi.persistence.dataAccess.VariableDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

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
	@Transactional
	public List<Variable> getAll()
	{
		List<Variable> variables = getHibernateTemplate().loadAll( getPersistenceClass() );

		if ( variables == null )
			return Collections.emptyList();

		return variables;
	}

}
