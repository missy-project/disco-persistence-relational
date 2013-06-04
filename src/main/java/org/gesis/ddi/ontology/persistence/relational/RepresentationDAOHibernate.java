package org.gesis.ddi.ontology.persistence.relational;

import org.gesis.ddi.ontology.Representation;
import org.gesis.ddi.ontology.persistence.RepresentationDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class RepresentationDAOHibernate extends GenericHibernateDAO<Representation> implements RepresentationDAO
{

	public RepresentationDAOHibernate( HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
