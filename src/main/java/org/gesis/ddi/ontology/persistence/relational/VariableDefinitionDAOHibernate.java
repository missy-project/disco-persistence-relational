package org.gesis.ddi.ontology.persistence.relational;

import org.gesis.ddi.ontology.VariableDefinition;
import org.gesis.ddi.ontology.persistence.VariableDefinitionDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class VariableDefinitionDAOHibernate extends GenericHibernateDAO<VariableDefinition> implements VariableDefinitionDAO
{

	public VariableDefinitionDAOHibernate(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

}
