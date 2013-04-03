package org.gesis.ddi.persistence.relational;

import java.util.Collections;
import java.util.List;

import org.gesis.ddi.ontology.VariableDefinition;
import org.gesis.ddi.persistence.dataAccess.VariableDefinitionDAO;
import org.hibernate.LockMode;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class DataElementDAOHibernate extends GenericHibernateDAO<VariableDefinition> implements VariableDefinitionDAO
{

	public DataElementDAOHibernate(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

	@Override
	public VariableDefinition getById( final String urn, final boolean lock )
	{
		VariableDefinition entity = getHibernateTemplate().get( VariableDefinition.class, urn, lock ? LockMode.READ : LockMode.NONE );
		return entity;
	}

	@Override
	public List<VariableDefinition> getAll()
	{
		@SuppressWarnings( "unchecked" )
		List<VariableDefinition> elements = getHibernateTemplate().find( "from DataElement" );

		if ( elements == null )
			return Collections.emptyList();

		return elements;
	}

}
