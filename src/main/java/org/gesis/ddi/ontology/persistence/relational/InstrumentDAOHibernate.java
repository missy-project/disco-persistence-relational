package org.gesis.ddi.ontology.persistence.relational;

import org.gesis.ddi.ontology.Instrument;
import org.gesis.ddi.ontology.persistence.InstrumentDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class InstrumentDAOHibernate extends GenericHibernateDAO<Instrument> implements InstrumentDAO
{

	public InstrumentDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
