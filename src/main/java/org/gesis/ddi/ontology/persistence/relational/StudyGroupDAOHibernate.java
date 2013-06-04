package org.gesis.ddi.ontology.persistence.relational;

import org.gesis.ddi.ontology.StudyGroup;
import org.gesis.ddi.ontology.persistence.StudyGroupDAO;
import org.gesis.persistence.relational.GenericHibernateDAO;
import org.springframework.orm.hibernate3.HibernateTemplate;

public class StudyGroupDAOHibernate extends GenericHibernateDAO<StudyGroup> implements StudyGroupDAO
{

	public StudyGroupDAOHibernate( HibernateTemplate hibernateTemplate )
	{
		super( hibernateTemplate );
	}

}
