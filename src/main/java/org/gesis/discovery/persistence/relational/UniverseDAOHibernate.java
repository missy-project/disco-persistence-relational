package org.gesis.discovery.persistence.relational;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.gesis.discovery.Universe;
import org.gesis.discovery.persistence.UniverseDAO;
import org.gesis.persistence.relational.GenericResourceHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

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
	public Universe getByDefinitionEn( final String definition )
	{
		if ( StringUtils.isEmpty( definition ) )
			return null;

		@SuppressWarnings( "unchecked" )
		List<Universe> universes = getHibernateTemplate().find( "FROM " + getPersistenceClass().getName() + " u WHERE u.definition.en = ?", definition );

		if ( universes == null || universes.size() == 0 )
			return null;

		return universes.get( 0 );
	}
}
