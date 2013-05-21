package org.gesis.ddi.persistence.relational;

import org.gesis.ddi.ontology.Representation;
import org.gesis.ddi.persistence.dataAccess.RepresentationDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class RepresentationDAOHibernate extends GenericHibernateDAO<Representation> implements RepresentationDAO
{

	public RepresentationDAOHibernate( HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
