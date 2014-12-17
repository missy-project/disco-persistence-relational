package org.gesis.discovery.persistence.relational;

import org.gesis.discovery.Instrument;
import org.gesis.discovery.persistence.InstrumentDAO;
import org.gesis.persistence.relational.GenericResourceHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

/**
 * @author matthaeus
 * 
 */
public class InstrumentDAOHibernate extends GenericResourceHibernateDAO<Instrument> implements InstrumentDAO
{

	public InstrumentDAOHibernate()
	{
		super();
	}

	public InstrumentDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
