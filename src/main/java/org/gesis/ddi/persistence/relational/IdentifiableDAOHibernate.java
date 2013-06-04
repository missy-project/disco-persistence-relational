package org.gesis.ddi.persistence.relational;

import org.gesis.ddi.Identifiable;
import org.gesis.ddi.persistence.IdentifiableDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class IdentifiableDAOHibernate extends GenericHibernateDAO<Identifiable> implements IdentifiableDAO
{

	public IdentifiableDAOHibernate(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

}
