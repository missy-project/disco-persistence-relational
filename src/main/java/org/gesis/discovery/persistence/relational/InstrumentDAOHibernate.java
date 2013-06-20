package org.gesis.discovery.persistence.relational;

import org.gesis.discovery.Instrument;
import org.gesis.discovery.persistence.InstrumentDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class InstrumentDAOHibernate extends GenericHibernateDAO<Instrument> implements InstrumentDAO
{

	public InstrumentDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
