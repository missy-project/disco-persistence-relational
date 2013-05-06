package org.gesis.ddi.persistence.relational;

import java.util.Collections;
import java.util.List;

import org.gesis.ddi.ontology.VariableDefinition;
import org.gesis.ddi.persistence.dataAccess.VariableDefinitionDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class VariableDefinitionDAOHibernate extends GenericHibernateDAO<VariableDefinition> implements VariableDefinitionDAO
{

	public VariableDefinitionDAOHibernate(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

	@Override
	@Transactional
	public List<VariableDefinition> getAll()
	{
		List<VariableDefinition> variableDefinitions = getHibernateTemplate().loadAll( getPersistenceClass() );

		if ( variableDefinitions == null )
			return Collections.emptyList();

		return variableDefinitions;
	}

}
