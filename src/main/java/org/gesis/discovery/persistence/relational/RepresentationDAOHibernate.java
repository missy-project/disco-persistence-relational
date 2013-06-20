package org.gesis.discovery.persistence.relational;

import org.gesis.discovery.Representation;
import org.gesis.discovery.persistence.RepresentationDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class RepresentationDAOHibernate extends GenericHibernateDAO<Representation> implements RepresentationDAO
{

	public RepresentationDAOHibernate( HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
