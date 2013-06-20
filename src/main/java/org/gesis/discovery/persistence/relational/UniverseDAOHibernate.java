package org.gesis.discovery.persistence.relational;

import java.util.Collections;
import java.util.List;

import org.gesis.discovery.Universe;
import org.gesis.discovery.persistence.UniverseDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class UniverseDAOHibernate extends GenericHibernateDAO<Universe> implements UniverseDAO
{

	public UniverseDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

	@Override
	@Transactional
	public List<Universe> getByExample( Universe exampleInstance, String... excludeProperty )
	{
		Example example = Example.create( exampleInstance );

		if ( excludeProperty != null )
			for ( String property : excludeProperty )
				example.excludeProperty( property );

		DetachedCriteria criteria = DetachedCriteria.forClass( getPersistenceClass() );
		criteria.add( example );

		if ( exampleInstance.getSkos_definition() != null )
			criteria.createCriteria( "skos_definition" ).add( Example.create( exampleInstance.getSkos_definition() ) );
		if ( exampleInstance.getSkos_prefLabel() != null )
			criteria.createCriteria( "skos_prefLabel" ).add( Example.create( exampleInstance.getSkos_prefLabel() ) );

		@SuppressWarnings( "unchecked" )
		List<Universe> list = getHibernateTemplate().findByCriteria( criteria );

		if ( list == null )
			return Collections.emptyList();

		return list;
	}

}
