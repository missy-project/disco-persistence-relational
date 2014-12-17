package org.gesis.persistence.relational;

import org.gesis.persistence.PersistableResource;
import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

/**
 * @author matthaeus
 * 
 */
public class PersistenceUtil
{

	/**
	 * This method retrieves all relations that are associated with the
	 * <i>entity</i>-object so that they not need to be fetched via lazy-mode.
	 * This is necessary sometimes when there is no Transactional-annotation
	 * given.
	 * 
	 * @param entity
	 * @return
	 */
	@SuppressWarnings( "unchecked" )
	public static <R extends PersistableResource> R unproxy( R entity )
	{
		if ( entity == null )
			return null;

		if ( !(entity instanceof HibernateProxy) )
			return entity;

		Hibernate.initialize( entity );
		entity = (R) ((HibernateProxy) entity).getHibernateLazyInitializer().getImplementation();

		return entity;
	}
}
