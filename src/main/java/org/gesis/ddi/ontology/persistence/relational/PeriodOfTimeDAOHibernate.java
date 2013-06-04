package org.gesis.ddi.ontology.persistence.relational;

import org.gesis.dcterms.PeriodOfTime;
import org.gesis.ddi.ontology.persistence.PeriodOfTimeDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class PeriodOfTimeDAOHibernate extends GenericHibernateDAO<PeriodOfTime> implements PeriodOfTimeDAO
{

	public PeriodOfTimeDAOHibernate( final HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}