package org.gesis.discovery.persistence.relational;

import org.gesis.discovery.VariableDefinition;
import org.gesis.discovery.persistence.VariableDefinitionDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class VariableDefinitionDAOHibernate extends GenericHibernateDAO<VariableDefinition> implements VariableDefinitionDAO
{

	public VariableDefinitionDAOHibernate(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

}
