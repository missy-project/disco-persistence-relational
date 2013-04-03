package org.gesis.ddi.persistence.relational;

import java.util.List;

import org.gesis.ddi.ontology.Universe;
import org.gesis.ddi.persistence.dataAccess.UniverseDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class UniverseDAOHibernate extends GenericHibernateDAO<Universe> implements UniverseDAO
{

	public UniverseDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

	@Override
	public List<Universe> getAll()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
