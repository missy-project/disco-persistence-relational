package org.gesis.ddi.persistence;

import java.io.Serializable;

import org.gesis.ddi.Identifiable;
import org.hibernate.HibernateException;
import org.hibernate.engine.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class URNGenerator implements IdentifierGenerator
{

	@Override
	public Serializable generate( SessionImplementor sessionImplementor, Object object ) throws HibernateException
	{
		// we only look at Identifiable objects
		if ( object instanceof Identifiable )
			return null;

		Identifiable identifiable = (Identifiable) object;

		StringBuilder urn = new StringBuilder();

		// the id is the urn. the urn is build up of this object properties
		urn.append( identifiable.getAgencyId() );
		urn.append( ":" );
		urn.append( identifiable.getObjectId() );
		urn.append( ":" );
		urn.append( identifiable.getMajorVersion() );

		if ( urn.toString().equals( "" ) )
			return null;

		return urn.toString();
	}

}
