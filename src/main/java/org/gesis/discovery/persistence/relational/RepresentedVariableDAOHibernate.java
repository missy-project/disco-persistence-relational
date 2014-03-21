package org.gesis.discovery.persistence.relational;

import org.gesis.discovery.RepresentedVariable;
import org.gesis.discovery.persistence.RepresentedVariableDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class RepresentedVariableDAOHibernate extends GenericHibernateDAO<RepresentedVariable> implements RepresentedVariableDAO
{

	public RepresentedVariableDAOHibernate(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

}
