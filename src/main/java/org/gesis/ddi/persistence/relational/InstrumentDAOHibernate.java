package org.gesis.ddi.persistence.relational;

import org.gesis.ddi.ontology.Instrument;
import org.gesis.ddi.persistence.dataAccess.InstrumentDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class InstrumentDAOHibernate extends GenericHibernateDAO<Instrument> implements InstrumentDAO
{

	public InstrumentDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
