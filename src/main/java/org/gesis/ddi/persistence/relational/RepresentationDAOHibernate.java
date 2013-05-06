package org.gesis.ddi.persistence.relational;

import java.util.Collections;
import java.util.List;

import org.gesis.ddi.ontology.Representation;
import org.gesis.ddi.persistence.dataAccess.RepresentationDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class RepresentationDAOHibernate extends GenericHibernateDAO<Representation> implements RepresentationDAO
{

	public RepresentationDAOHibernate( HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

	@Override
	@Transactional
	public List<Representation> getAll()
	{
		List<Representation> representations = getHibernateTemplate().loadAll( getPersistenceClass() );

		if ( representations == null )
			return Collections.emptyList();

		return representations;
	}

}
