package org.gesis.ddi.persistence.relational;

import org.gesis.ddi.ontology.VariableDefinition;
import org.gesis.ddi.persistence.dataAccess.VariableDefinitionDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class VariableDefinitionDAOHibernate extends GenericHibernateDAO<VariableDefinition> implements VariableDefinitionDAO
{

	public VariableDefinitionDAOHibernate(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

}
