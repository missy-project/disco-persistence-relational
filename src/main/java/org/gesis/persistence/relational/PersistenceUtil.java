package org.gesis.persistence.relational;

import org.gesis.persistence.PersistableResource;
import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

public class PersistenceUtil
{

	/**
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
			return null;

		Hibernate.initialize( entity );
		entity = (R) ((HibernateProxy) entity).getHibernateLazyInitializer().getImplementation();

		return entity;
	}
}
