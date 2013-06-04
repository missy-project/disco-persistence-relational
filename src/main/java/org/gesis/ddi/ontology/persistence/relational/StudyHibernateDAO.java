package org.gesis.ddi.ontology.persistence.relational;

import org.gesis.ddi.ontology.Study;
import org.gesis.ddi.ontology.persistence.StudyDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class StudyHibernateDAO extends GenericHibernateDAO<Study> implements StudyDAO
{

	public StudyHibernateDAO(final HibernateTemplate hibernateTemplate)
	{
		super( hibernateTemplate );
	}

}
