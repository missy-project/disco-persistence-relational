package org.gesis.discovery.persistence.relational;

import java.util.Collections;
import java.util.List;

import org.gesis.discovery.Universe;
import org.gesis.discovery.persistence.UniverseDAO;
import org.gesis.persistence.relational.GenericResourceHibernateDAO;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author matthaeus
 * 
 */
public class UniverseDAOHibernate extends GenericResourceHibernateDAO<Universe> implements UniverseDAO
{

	public UniverseDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

	@Override
	@Transactional
	public List<Universe> getByExample( final Universe exampleInstance, final String... excludeProperty )
	{
		final Example example = Example.create( exampleInstance );

		if ( excludeProperty != null )
			for ( final String property : excludeProperty )
				example.excludeProperty( property );

		final DetachedCriteria criteria = DetachedCriteria.forClass( getPersistenceClass() );
		criteria.add( example );

		if ( exampleInstance.getDefinition() != null )
			criteria.createCriteria( "definition" ).add( Example.create( exampleInstance.getDefinition() ) );
		if ( exampleInstance.getPrefLabel() != null )
			criteria.createCriteria( "prefLabel" ).add( Example.create( exampleInstance.getPrefLabel() ) );

		@SuppressWarnings( "unchecked" )
		final
		List<Universe> list = getHibernateTemplate().findByCriteria( criteria );

		if ( list == null )
			return Collections.emptyList();

		return list;
	}

}
