package org.gesis.ddi.persistence.relational;

import java.util.List;

import org.gesis.ddi.ontology.Instrument;
import org.gesis.ddi.persistence.dataAccess.InstrumentDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class InstrumentDAOHibernate extends GenericHibernateDAO<Instrument> implements InstrumentDAO
{

	public InstrumentDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

	@Override
	public Instrument getById( final String urn, final boolean lock )
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Instrument> getAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
